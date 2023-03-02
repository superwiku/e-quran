package com.example.equran;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class QuranAllAdapter extends RecyclerView.Adapter<QuranAllAdapter.QuranAllHolder> {
    List<Quran> data;
    Activity activity;

    public QuranAllAdapter(List<Quran> data, Activity activity) {
        this.data = data;
        this.activity = activity;
    }

    @NonNull
    @Override
    public QuranAllHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_all,parent,false);
        return new QuranAllHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuranAllHolder holder, int position) {
        holder.txtNama.setText(data.get(position).getNama());
        holder.txtArab.setText(data.get(position).getAsma());
        holder.txtNomor.setText(data.get(position).getNomor());
        holder.txtArti.setText(data.get(position).getArti());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindah = new Intent(activity,AyatActivity.class);
                pindah.putExtra("suratnya",data.get(position));
                v.getContext().startActivity(pindah);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    static class QuranAllHolder extends RecyclerView.ViewHolder{
        TextView txtNama,txtArab,txtNomor,txtArti;
        public QuranAllHolder(@NonNull View itemView) {
            super(itemView);
            txtNama = (TextView) itemView.findViewById(R.id.txt_nama);
            txtArab = (TextView) itemView.findViewById(R.id.txt_arab);
            txtNomor = (TextView) itemView.findViewById(R.id.txt_nomor);
            txtArti = (TextView) itemView.findViewById(R.id.txt_arti);

        }
    }
}
