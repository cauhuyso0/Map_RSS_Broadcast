package com.example.ps10826_maixuanhuy_asm1.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ps10826_maixuanhuy_asm1.R;
import com.example.ps10826_maixuanhuy_asm1.adapter.SapHocAdapter;

import static com.example.ps10826_maixuanhuy_asm1.Activity.MainActivity.ds;

/**
 * A simple {@link Fragment} subclass.
 */
public class SapHocFragment extends Fragment {
    RecyclerView rcvSapHoc;
    LinearLayoutManager mLayoutManager;
    SapHocAdapter adapter;

    public SapHocFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sap_hoc, container, false);

        rcvSapHoc = view.findViewById(R.id.rcvSapHoc);

        mLayoutManager = new LinearLayoutManager(getContext());
        rcvSapHoc.setLayoutManager(mLayoutManager);

        adapter = new SapHocAdapter(getContext(), ds, this);

        rcvSapHoc.setAdapter(adapter);

        return view;
    }

}
