package com.example.equran;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView rvAll;
    RecyclerView.LayoutManager layoutAll;
    ApiInterface interfaceQuran;
    List<Quran> quranAll;
    QuranAllAdapter quranAllAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvAll = (RecyclerView) findViewById(R.id.rv_all);
        layoutAll = new LinearLayoutManager(this);
        rvAll.setLayoutManager(layoutAll);
        interfaceQuran = ApiClient.getApiClient().create(ApiInterface.class);
        Call<List<Quran>> call = interfaceQuran.ambilSemua();
        call.enqueue(new Callback<List<Quran>>() {
            @Override
            public void onResponse(Call<List<Quran>> call, Response<List<Quran>> response) {
                quranAll = response.body();
                quranAllAdapter = new QuranAllAdapter(quranAll,MainActivity.this);
                rvAll.setAdapter(quranAllAdapter);
            }

            @Override
            public void onFailure(Call<List<Quran>> call, Throwable t) {

            }
        });

    }
}