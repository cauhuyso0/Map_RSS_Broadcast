package com.example.ps10826_maixuanhuy_asm1.adapter;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.ps10826_maixuanhuy_asm1.R;
import com.example.ps10826_maixuanhuy_asm1.fragment.DaHocFragment;
import com.example.ps10826_maixuanhuy_asm1.fragment.DangHocFragment;

import com.example.ps10826_maixuanhuy_asm1.fragment.SapHocFragment;

public class PageAdapter extends FragmentStatePagerAdapter {
    public PageAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    public PageAdapter(FragmentManager supportFragmentManager) {
        super(supportFragmentManager);
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
// hàm chọn item trên viewpager
        switch (position){
            case 0:
                SapHocFragment f0 = new SapHocFragment();

                Bundle b1 = new Bundle();
                b1.putInt("daDK", R.layout.fragment_sap_hoc);
                f0.setArguments(b1);
                return f0;

            case 1:
                DangHocFragment f1 = new DangHocFragment();

                Bundle b2  = new Bundle();
                b2.putInt("dangHoc", R.layout.fragment_dang_hoc);
                f1.setArguments(b2);
                return f1;

            case 2:
                DaHocFragment f2 = new DaHocFragment();

                Bundle b3  = new Bundle();
                b3.putInt("daHoc", R.layout.fragment_da_hoc);
                f2.setArguments(b3);
                return f2;
        }

        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
