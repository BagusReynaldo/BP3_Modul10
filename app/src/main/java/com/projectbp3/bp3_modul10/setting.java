package com.projectbp3.bp3_modul10;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link setting#newInstance} factory method to
 * create an instance of this fragment.
 */
public class setting extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public setting() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment setting.
     */
    // TODO: Rename and change types and number of parameters
    public static setting newInstance(String param1, String param2) {
        setting fragment = new setting();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_setting, container, false);

        // Ambil username dari SharedPreferences
        SharedPreferences sharedPreferences = requireActivity().getSharedPreferences("user_prefs", Context.MODE_PRIVATE);
        String username = sharedPreferences.getString("username", "Tidak ada username");

        // Tampilkan username di TextView dengan ID akun
        TextView akunTextView = view.findViewById(R.id.akun);
        akunTextView.setText(username); // Set teks username ke TextView

        // Klik event untuk "About Us"
        RelativeLayout about_us = view.findViewById(R.id.about_us);
        about_us.setOnClickListener(v -> {
            Intent intent = new Intent(requireContext(), AboutUs.class);
            startActivity(intent);
        });

        // Klik event untuk Logout
        RelativeLayout logout = view.findViewById(R.id.layout_logout);
        logout.setOnClickListener(v -> {
            // Tampilkan dialog konfirmasi
            new AlertDialog.Builder(requireContext())
                    .setTitle("Konfirmasi Logout")
                    .setMessage("Apakah Anda yakin ingin logout?")
                    .setPositiveButton("Ya", (dialog, which) -> {
                        // Hapus username dari SharedPreferences
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove("username");
                        editor.apply();

                        // Kembali ke MainActivity
                        Intent intent = new Intent(requireContext(), MainActivity.class);
                        startActivity(intent);
                        requireActivity().finish();
                    })
                    .setNegativeButton("Tidak", (dialog, which) -> {
                        // Tutup dialog tanpa melakukan apa pun
                        dialog.dismiss();
                    })
                    .create()
                    .show();
        });

        return view;
    }

}