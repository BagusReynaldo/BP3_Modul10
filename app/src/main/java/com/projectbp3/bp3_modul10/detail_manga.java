package com.projectbp3.bp3_modul10;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link detail_manga#newInstance} factory method to
 * create an instance of this fragment.
 */
public class detail_manga extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public detail_manga() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static detail_manga newInstance(String title, String author, String tahun, String genre, String status, String premis, int photo) {
        detail_manga fragment = new detail_manga();
        Bundle args = new Bundle();
        args.putString("TITLE", title);
        args.putString("AUTHOR", author);
        args.putString("TAHUN", tahun);
        args.putString("GENRE", genre);
        args.putString("STATUS", status);
        args.putString("PREMIS", premis);
        args.putInt("PHOTO", photo);
        fragment.setArguments(args);
        return fragment;
    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString("DETAIL");
            mParam2 = getArguments().getString("PREMIS");
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail_manga, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recycler_chapters);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        List<String> chapters = new ArrayList<>();
        chapters.add("Chapter 1 : Episode pertama");
        chapters.add("Chapter 2 : Episode dua");
        chapters.add("Chapter 3 : Episode tiga");
        chapters.add("Chapter 4 : Episode empat");
        chapters.add("Chapter 5 : Episode lima");
        chapters.add("Chapter 6 : Episode enam");
        chapters.add("Chapter 7 : Episode tujuh");
        chapters.add("Chapter 8 : Episode delapan");
        chapters.add("Chapter 9 : Episode sembilan");
        chapters.add("Chapter 10 : Episode sepuluh");
        chapters.add("Chapter 11 : Episode sebelas");

        ChapterAdapter adapter = new ChapterAdapter(chapters);
        recyclerView.setAdapter(adapter);

        // Referensi ke TextView dan ImageView
        TextView tvTitle = view.findViewById(R.id.tv_item_title);
        TextView tvAuthor = view.findViewById(R.id.tv_item_author);
        TextView tvTahun = view.findViewById(R.id.tv_item_tahun);
        TextView tvGenre = view.findViewById(R.id.tv_item_genre);
        TextView tvStatus = view.findViewById(R.id.tv_item_status);
        TextView tvPremis = view.findViewById(R.id.tv_item_premis);
        ImageView imgPhoto = view.findViewById(R.id.img_item_photo);

        // Ambil data dari arguments
        if (getArguments() != null) {
            String title = getArguments().getString("TITLE");
            String author = getArguments().getString("AUTHOR");
            String tahun = getArguments().getString("TAHUN");
            String genre = getArguments().getString("GENRE");
            String status = getArguments().getString("STATUS");
            String premis = getArguments().getString("PREMIS");
            int photo = getArguments().getInt("PHOTO");

            // Set data ke TextView dan ImageView
            tvTitle.setText(title);
            tvAuthor.setText(author);
            tvTahun.setText(tahun);
            tvGenre.setText(genre);
            tvStatus.setText(status);
            tvPremis.setText(premis);
            imgPhoto.setImageResource(photo); // Set gambar
        }

        return view;
    }


}