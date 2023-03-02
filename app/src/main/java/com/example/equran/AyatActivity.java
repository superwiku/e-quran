package com.example.equran;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AyatActivity extends AppCompatActivity {
    RecyclerView rvAyat;
    RecyclerView.LayoutManager layoutManager;
    AyatAdapter ayatAdapter;
    Quran ayatnya;
    String nomorAyat;
    ApiInterface interfaceAyat;
    List<Ayat> daftarAyat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayat);
        rvAyat = (RecyclerView) findViewById(R.id.rv_ayat);
        layoutManager = new LinearLayoutManager(this);
        rvAyat.setLayoutManager(layoutManager);
        Intent dapet = getIntent();
        ayatnya = (Quran) dapet.getSerializableExtra("suratnya");
        nomorAyat = ayatnya.getNomor();
        interfaceAyat = ApiClient.getApiClient().create(ApiInterface.class);
        Call<List<Ayat>> call = interfaceAyat.getAyat(nomorAyat);
        call.enqueue(new Callback<List<Ayat>>() {
            @Override
            public void onResponse(Call<List<Ayat>> call, Response<List<Ayat>> response) {
                daftarAyat = response.body();
                ayatAdapter = new AyatAdapter(daftarAyat,AyatActivity.this);
                rvAyat.setAdapter(ayatAdapter);
            }

            @Override
            public void onFailure(Call<List<Ayat>> call, Throwable t) {

            }
        });

    }
}