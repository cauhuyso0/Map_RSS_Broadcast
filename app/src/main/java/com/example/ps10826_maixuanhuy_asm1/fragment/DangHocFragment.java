package com.example.ps10826_maixuanhuy_asm1.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ps10826_maixuanhuy_asm1.R;
import com.example.ps10826_maixuanhuy_asm1.adapter.DaDKAdapter;
import com.example.ps10826_maixuanhuy_asm1.adapter.SapHocAdapter;

import static com.example.ps10826_maixuanhuy_asm1.Activity.MainActivity.ds;
import static com.example.ps10826_maixuanhuy_asm1.adapter.SapHocAdapter.list;

/**
 * A simple {@link Fragment} subclass.
 */
public class DangHocFragment extends Fragment {
    LinearLayoutManager mLayoutManager;
    RecyclerView rcvDaDK;
    DaDKAdapter adapter;
    public DangHocFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view =  inflater.inflate(R.layout.fragment_dang_hoc, container, false);

        rcvDaDK = view.findViewById(R.id.rcvDaDK);

        mLayoutManager = new LinearLayoutManager(getContext());
        rcvDaDK.setLayoutManager(mLayoutManager);

        adapter = new DaDKAdapter(getContext(), list, this);

        rcvDaDK.setAdapter(adapter);

        return view;
    }

}
