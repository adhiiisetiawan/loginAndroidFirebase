package com.oxcart.loginfirebasekuy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewBarangAdapter extends RecyclerView.Adapter<RecyclerViewBarangAdapter.ViewHolder>{
    Context context;
    List<Barang> barangs;

    public RecyclerViewBarangAdapter(Context context, List<Barang> mainImageUploadInfoList) {
        this.context = context;
        barangs = mainImageUploadInfoList;
    }

    @NonNull
    @Override
    public RecyclerViewBarangAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_items, parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewBarangAdapter.ViewHolder holder, int position) {
        Barang barang = barangs.get(position);
        holder.NamaBarang.setText(barang.getNamaBarang());
        holder.JenisBarang.setText(barang.getJenisBarang());
        holder.UmurBarang.setText(barang.getUmurBarang());
        holder.JumlahPerKilo.setText(barang.getJumlahPerKilo());
        holder.HargaBarang.setText(barang.getHargaBarang());
    }

    @Override
    public int getItemCount() {
        return barangs.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView NamaBarang;
        public TextView JenisBarang;
        public TextView UmurBarang;
        public TextView JumlahPerKilo;
        public TextView HargaBarang;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            NamaBarang = itemView.findViewById(R.id.nama_barang);
            JenisBarang = itemView.findViewById(R.id.jenis_barang);
            UmurBarang = itemView.findViewById(R.id.umur_barang);
            JumlahPerKilo = itemView.findViewById(R.id.jumlah_per_kilo);
            HargaBarang = itemView.findViewById(R.id.harga_barang);
        }
    }
}
