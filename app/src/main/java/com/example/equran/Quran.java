package com.example.equran;

import java.io.Serializable;

public class Quran implements Serializable {
    private String arti;
    private String nama;
    private String asma;
    private String nomor;
    private String keterangan;

    public Quran(String arti, String nama, String asma, String nomor, String keterangan) {
        this.arti = arti;
        this.nama = nama;
        this.asma = asma;
        this.nomor = nomor;
        this.keterangan = keterangan;
    }

    public String getArti() {
        return arti;
    }

    public String getNama() {
        return nama;
    }

    public String getAsma() {
        return asma;
    }

    public String getNomor() {
        return nomor;
    }

    public String getKeterangan() {
        return keterangan;
    }
}
