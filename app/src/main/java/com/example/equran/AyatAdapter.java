package com.example.equran;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AyatAdapter extends RecyclerView.Adapter<AyatAdapter.AyatHolder> {
    List<Ayat> data;
    Activity activity;

    public AyatAdapter(List<Ayat> data, Activity activity) {
        this.data = data;
        this.activity = activity;
    }

    @NonNull
    @Override
    public AyatHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.rv_ayat,parent,false);
        return new AyatHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AyatHolder holder, int position) {
        holder.txtNomor.setText(data.get(position).getNomor());
        holder.txtAr.setText(data.get(position).getAr());
        holder.txtId.setText(data.get(position).getId());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static class AyatHolder extends RecyclerView.ViewHolder{
        TextView txtNomor,txtAr,txtId;
        public AyatHolder(@NonNull View itemView) {
            super(itemView);
            txtAr = (TextView) itemView.findViewById(R.id.txt_arab_ayat);
            txtId = (TextView) itemView.findViewById(R.id.txt_id_ayat);
            txtNomor = (TextView) itemView.findViewById(R.id.txt_nomor_ayat);
        }
    }
}
