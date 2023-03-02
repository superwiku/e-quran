package com.example.equran;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiInterface {
    @GET("data")
    Call<List<Quran>> ambilSemua();

    @GET("surat/{nomor}")
    Call<List<Ayat>> getAyat(@Path("nomor") String nomor);

}
