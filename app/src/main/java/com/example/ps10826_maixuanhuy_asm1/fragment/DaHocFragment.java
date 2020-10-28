package com.example.ps10826_maixuanhuy_asm1.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ps10826_maixuanhuy_asm1.R;
import com.example.ps10826_maixuanhuy_asm1.adapter.LichThiAdapter;

import static com.example.ps10826_maixuanhuy_asm1.adapter.SapHocAdapter.listLichThi;

/**
 * A simple {@link Fragment} subclass.
 */
public class DaHocFragment extends Fragment {
    RecyclerView rcvLichThi;
    LinearLayoutManager mLayoutManager;
    LichThiAdapter adapter;
    public DaHocFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_da_hoc, container, false);
        rcvLichThi = view.findViewById(R.id.rcvLichThi);
        mLayoutManager = new LinearLayoutManager(getContext());
        rcvLichThi.setLayoutManager(mLayoutManager);

        adapter = new LichThiAdapter(getContext(), listLichThi, this);

        rcvLichThi.setAdapter(adapter);

        return view;
    }

}
