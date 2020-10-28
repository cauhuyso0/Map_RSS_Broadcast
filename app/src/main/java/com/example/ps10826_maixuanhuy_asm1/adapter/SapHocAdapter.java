package com.example.ps10826_maixuanhuy_asm1.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ps10826_maixuanhuy_asm1.R;
import com.example.ps10826_maixuanhuy_asm1.fragment.SapHocFragment;
import com.example.ps10826_maixuanhuy_asm1.model.KhoaHoc;

import java.util.ArrayList;
import java.util.List;

public class SapHocAdapter extends RecyclerView.Adapter<SapHocAdapter.ViewHolder> {
    public static  List list = new ArrayList();
    public static  List listLichThi = new ArrayList();
    static Context context;
    List<KhoaHoc> ds;
    SapHocFragment fr;

    public SapHocAdapter(Context context, List<KhoaHoc> ds, SapHocFragment fr){
        this.context = context;
        this.ds = ds;
        this.fr = fr;
    }

    @NonNull
    @Override
    public SapHocAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context)
                .inflate(R.layout.card_view_sap_hoc, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final SapHocAdapter.ViewHolder holder, final int position) {
        final KhoaHoc khoaHoc = ds.get(position);
        holder.tvMaKH.setText(khoaHoc.getMaKH()+"");
        holder.tvTenKH.setText(khoaHoc.getTenKH());
        holder.tvLich.setText(khoaHoc.getLichTrinh());
        holder.tvLop.setText(khoaHoc.getLop());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Bạn có muốn đăng ký khóa học này ?")
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String maKH = khoaHoc.getMaKH();
                                String tenKH = khoaHoc.getTenKH();
                                String lich = khoaHoc.getLichTrinh();
                                String lop = khoaHoc.getLop();
                                KhoaHoc khoaHoc1 = new KhoaHoc(maKH, tenKH, lich, lop);
                                KhoaHoc khoaHoc2 = new KhoaHoc(tenKH, lich);
                                list.add(khoaHoc1);
                                listLichThi.add(khoaHoc2);
                            }
                        })
                        .setNegativeButton("Canel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                builder.show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return ds.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvMaKH, tvTenKH, tvLich, tvLop;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvMaKH = itemView.findViewById(R.id.tvMaKH);
            tvTenKH = itemView.findViewById(R.id.tvTenKH);
            tvLich = itemView.findViewById(R.id.tvLich);
            tvLop = itemView.findViewById(R.id.tvLop);

        }
    }
}
