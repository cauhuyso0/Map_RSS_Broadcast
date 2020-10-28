package com.example.ps10826_maixuanhuy_asm1.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ps10826_maixuanhuy_asm1.R;
import com.example.ps10826_maixuanhuy_asm1.fragment.DangHocFragment;
import com.example.ps10826_maixuanhuy_asm1.model.KhoaHoc;

import java.util.List;

public class DaDKAdapter extends RecyclerView.Adapter<DaDKAdapter.ViewHolder> {
    static Context context;
    List<KhoaHoc> ds;
    DangHocFragment fr;

    public DaDKAdapter(Context context, List<KhoaHoc> ds, DangHocFragment fr){
        this.context = context;
        this.ds = ds;
        this.fr = fr;
    }

    @NonNull
    @Override
    public DaDKAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context)
                .inflate(R.layout.card_view_da_dk, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final DaDKAdapter.ViewHolder holder, final int position) {
        final KhoaHoc khoaHoc = ds.get(position);
        holder.tvMaKH.setText(khoaHoc.getMaKH()+"");
        holder.tvTenKH.setText(khoaHoc.getTenKH());
        holder.tvLich.setText(khoaHoc.getLichTrinh());
        holder.tvLop.setText(khoaHoc.getLop());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String tenKhoaHoc = khoaHoc.getTenKH();

                Toast.makeText(context, "click được nha", Toast.LENGTH_SHORT).show();
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                View view = LayoutInflater.from(context).inflate(R.layout.show_kh, null, false);
                TextView tvTenKH = view.findViewById(R.id.tvTenKH);
                TextView tvGioiThieu = view.findViewById(R.id.tvGioiThieu);
                TextView tvGiaoVien = view.findViewById(R.id.tvGV);
                TextView tvLichHoc = view.findViewById(R.id.tvLichHoc);
                if (tenKhoaHoc.equalsIgnoreCase("Khoa hoc lap trinh")){
                    tvTenKH.setText(tenKhoaHoc);
                    tvGioiThieu.setText("Giới thiệu: Khóa học lập trình cơ bản giúp học viên có thể bước đầu làm quen với lập trình. Học viên sẽ được tìm hiểu các ngôn ngữ lập trình như java, html, css, javascript, python......");
                    tvGiaoVien.setText("Giảng Viên: TS.Trần Gia Đăng Khoa");
                    tvLichHoc.setText("Lịch học trong tuần: Thứ 3, thứ 5, thứ 7.   ca 2");
                }
                if (tenKhoaHoc.equalsIgnoreCase("Khoa hoc tieng anh")){
                    tvTenKH.setText(tenKhoaHoc);
                    tvGioiThieu.setText("Giới thiệu: Khóa học tiếng anh giao tiếp giúp học viên có thể tự tin khi giao tiếp bằng tiếng anh......");
                    tvGiaoVien.setText("Giảng Viên: Trần Văn Đức");
                    tvLichHoc.setText("Lịch học trong tuần: Thứ 2, thứ 6.      ca 4");
                }
                if (tenKhoaHoc.equalsIgnoreCase("Khoa hoc quan ly nhan su")){
                    tvTenKH.setText(tenKhoaHoc);
                    tvGioiThieu.setText("Giới thiệu: Khóa học quản lý nhân sự với sự giảng dạy của giảng viên có 25 kinh nghiệm trong ngành, giúp học viên nắm bắt được ......");
                    tvGiaoVien.setText("Giảng Viên: Nguyễn Văn Hoài");
                    tvLichHoc.setText("Lịch học trong tuần: Thứ 4, thứ 7.     ca 1");
                }
                builder.setView(view)
                        .setTitle("Thông tin chi tiết về khóa học");
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
