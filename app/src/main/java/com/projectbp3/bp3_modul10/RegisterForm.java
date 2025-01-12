package com.projectbp3.bp3_modul10;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class RegisterForm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register_form);

        Button register = findViewById(R.id.register);
        register.setOnClickListener(v -> {

            // Ambil input dari form
            EditText passInput = findViewById(R.id.txt_password);
            EditText userInput = findViewById(R.id.txt_username);
            EditText emailInput = findViewById(R.id.txt_email);

            String email = emailInput.getText().toString().trim();
            String username = userInput.getText().toString().trim();
            String password = passInput.getText().toString().trim();

            // Validasi email kosong
            if (email.isEmpty()) {
                emailInput.setError("Email tidak boleh kosong!");
                emailInput.requestFocus();
                return;
            }

            // Validasi username kosong
            if (username.isEmpty()) {
                userInput.setError("Ulangi Username tidak boleh kosong!");
                userInput.requestFocus();
                return;
            }

            // Validasi password kosong
            if (password.isEmpty()) {
                passInput.setError("Password tidak boleh kosong!");
                passInput.requestFocus();
                return;
            }


            // Simpan email, username, dan password ke SharedPreferences
            SharedPreferences sharedPreferences = getSharedPreferences("user_prefs", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("email", email);      // Simpan email
            editor.putString("username", username); // Simpan username
            editor.putString("password", password); // Simpan password
            editor.apply(); // Terapkan perubahan

            // Beralih ke LoginForm
            Intent intent = new Intent(RegisterForm.this, Dashboard.class);
            startActivity(intent);

        });

        TextView login = findViewById(R.id.txt_login);
        login.setOnClickListener(v -> {
            startActivity(new Intent(RegisterForm.this, MainActivity.class));
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}