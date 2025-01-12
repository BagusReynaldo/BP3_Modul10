package com.projectbp3.bp3_modul10;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListMangaAdapter extends RecyclerView.Adapter<ListMangaAdapter.ListViewHolder> {

    private ArrayList<manga> listManga;
    private OnItemClickCallback onItemClickCallback;

    public ListMangaAdapter(ArrayList<manga> list) {
        this.listManga = list;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_card, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        manga manga = listManga.get(position);

        // Set data ke elemen UI
        holder.nama.setText(manga.getTitle());
        holder.view.setText(manga.getView());
        holder.imgPhoto.setImageResource(manga.getPhoto());

        // Tambahkan klik listener
        holder.itemView.setOnClickListener(v -> {
            if (onItemClickCallback != null) {
                onItemClickCallback.onItemClicked(manga);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listManga.size();
    }

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    public static class ListViewHolder extends RecyclerView.ViewHolder {
        private TextView nama, view;
        private ImageView imgPhoto;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            nama = itemView.findViewById(R.id.tv_item_name);
            view = itemView.findViewById(R.id.tv_item_view);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
        }
    }

    public interface OnItemClickCallback {
        void onItemClicked(manga manga);
    }
}


