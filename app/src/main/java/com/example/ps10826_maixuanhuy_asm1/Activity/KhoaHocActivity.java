package com.example.ps10826_maixuanhuy_asm1.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.ps10826_maixuanhuy_asm1.Activity.MainActivity.ds;
import com.example.ps10826_maixuanhuy_asm1.R;
import com.example.ps10826_maixuanhuy_asm1.fragment.DaHocFragment;
import com.example.ps10826_maixuanhuy_asm1.fragment.DangHocFragment;
import com.example.ps10826_maixuanhuy_asm1.fragment.SapHocFragment;
import com.example.ps10826_maixuanhuy_asm1.model.KhoaHoc;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class KhoaHocActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_khoa_hoc);


        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        FloatingActionButton btnTim = (FloatingActionButton) findViewById(R.id.btnTim);

        btnTim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(KhoaHocActivity.this);
                View view = LayoutInflater.from(KhoaHocActivity.this).inflate(R.layout.tim_khoa_hoc, null, false);
                final EditText edtTimKH = view.findViewById(R.id.edtTimKH);
                builder.setTitle("Tìm Khóa Học")
                        .setView(view)
                        .setPositiveButton("Tìm", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                for (int i = 0; i < ds.size(); i++){
                                    KhoaHoc khoaHoc = ds.get(i);
                                    if (khoaHoc.getTenKH().equalsIgnoreCase(edtTimKH.getText().toString())){
                                        AlertDialog.Builder builder1 = new AlertDialog.Builder(KhoaHocActivity.this);
                                        View view1 = LayoutInflater.from(KhoaHocActivity.this).inflate(R.layout.show_khoa_hoc, null, false);
                                        TextView tvMaKH = view1.findViewById(R.id.tvMaKH);
                                        TextView tvTenKH = view1.findViewById(R.id.tvTenKH);
                                        TextView tvLichTrinh = view1.findViewById(R.id.tvLich);
                                        TextView tvLop = view1.findViewById(R.id.tvLop);

                                        tvMaKH.setText("Mã KH: " +khoaHoc.getMaKH());
                                        tvTenKH.setText("Tên KH: " +khoaHoc.getTenKH());
                                        tvLichTrinh.setText("Lịch trình: "+khoaHoc.getLichTrinh());
                                        tvLop.setText("Lớp: " +khoaHoc.getLop());

                                        builder1.setTitle(edtTimKH.getText().toString())
                                                .setView(view1);
                                        builder1.show();
                                        break;
                                    }
                                    else {
                                        Toast.makeText(KhoaHocActivity.this, "Không có khóa học cần tìm", Toast.LENGTH_SHORT).show();
                                    }

                                }

                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                builder.show();
            }
        });
    }



    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.khoaHoc:
                    fragment = new SapHocFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.daDK:

                    fragment = new DangHocFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.lichHoc:
                    fragment = new DaHocFragment();
                    loadFragment(fragment);
                    return true;
            }
            return false;
        }
    };

    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout_bottom, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
