package com.projectbp3.bp3_modul10;

public class manga {
    private String title;
    private String author;
    private String tahun;
    private String genre;
    private String status;
    private String premis;
    private String view;
    private int photo;

    public manga(String tahun, String title, String author, String genre, String status, String premis, String view, int photo) {
        this.tahun = tahun;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.status = status;
        this.premis = premis;
        this.view = view;
        this.photo = photo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTahun() {
        return tahun;
    }

    public void setTahun(String tahun) {
        this.tahun = tahun;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPremis() {
        return premis;
    }

    public void setPremis(String premis) {
        this.premis = premis;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }
}
