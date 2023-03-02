package com.example.equran;

public class Ayat {
    private String ar;
    private String id;
    private String nomor;

    public Ayat(String ar, String id, String nomor) {
        this.ar = ar;
        this.id = id;
        this.nomor = nomor;
    }

    public String getAr() {
        return ar;
    }

    public String getId() {
        return id;
    }

    public String getNomor() {
        return nomor;
    }
}
