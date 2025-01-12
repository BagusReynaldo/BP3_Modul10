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

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        TextView register = findViewById(R.id.register);
        register.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, RegisterForm.class));
        });

        Button login = findViewById(R.id.btn_login);
        login.setOnClickListener(v -> {
            // Ambil input email dan password dari form
            EditText passInput = findViewById(R.id.txt_password);
            EditText userInput = findViewById(R.id.txt_username);
            String username = userInput.getText().toString().trim();
            String password = passInput.getText().toString().trim();

            // Validasi email kosong
            if (username.isEmpty()) {
                userInput.setError("Username tidak boleh kosong!");
                userInput.requestFocus();
                return;
            }

            // Validasi password kosong
            if (password.isEmpty()) {
                passInput.setError("Password tidak boleh kosong!");
                passInput.requestFocus();
                return;
            }

            // Setelah validasi berhasil, simpan username ke SharedPreferences
            SharedPreferences sharedPreferences = getSharedPreferences("user_prefs", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("username", username); // Simpan username
            editor.apply();

            // Beralih ke Dashboard
            Intent intent = new Intent(MainActivity.this, Dashboard.class);
            startActivity(intent);

        });



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}