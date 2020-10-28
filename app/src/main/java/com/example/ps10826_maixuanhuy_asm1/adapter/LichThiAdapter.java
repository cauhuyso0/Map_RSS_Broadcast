package com.example.ps10826_maixuanhuy_asm1.adapter;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;

import com.example.ps10826_maixuanhuy_asm1.R;
import com.example.ps10826_maixuanhuy_asm1.fragment.DaHocFragment;
import com.example.ps10826_maixuanhuy_asm1.model.KhoaHoc;

import java.util.List;

public class LichThiAdapter extends RecyclerView.Adapter<LichThiAdapter.ViewHolder> {
    static Context context;
    List<KhoaHoc> ds;
    DaHocFragment fr;

    public LichThiAdapter(Context context, List<KhoaHoc> ds, DaHocFragment fr){
        this.context = context;
        this.ds = ds;
        this.fr = fr;
    }

    @NonNull
    @Override
    public LichThiAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context)
                .inflate(R.layout.card_view_lich_thi, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final LichThiAdapter.ViewHolder holder, final int position) {
        final KhoaHoc khoaHoc = ds.get(position);
        holder.tvTenKH.setText(khoaHoc.getTenKH());
        holder.tvLichThi.setText("Ngày thi: " + khoaHoc.getLichTrinh().substring(13));

    }

    @Override
    public int getItemCount() {
        return ds.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvTenKH, tvLichThi;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvTenKH = itemView.findViewById(R.id.tvTenKH);
            tvLichThi = itemView.findViewById(R.id.tvLichThi);

        }
    }
}

