package com.example.latihannavbarbawah;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class DatarFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ArrayList<Items> itemArraylist;
    private RecyclerView recyclerview;
    MAdapter adapter;

    public DatarFragment() {

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_datar, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        dataInitialized();
        recyclerview = view.findViewById(R.id.Rvlist);
        recyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerview.setHasFixedSize(true);
        adapter = new MAdapter(getContext(),itemArraylist);
        recyclerview.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        adapter.setClickListener(this::onItemClick);
    }

    private void dataInitialized() {

        itemArraylist = new ArrayList<>();

        Items triangle = new Items("Triangle", R.drawable.triangle, new Param2_Fragment("Triangle"));
        itemArraylist.add(triangle);

        Items Square = new Items("Square", R.drawable.baseline_crop_square_24, new Param2_Fragment("Square"));
        itemArraylist.add(Square);

        Items Circle = new Items("Circle", R.drawable.circle, new Param1_Fragment("Circle"));
        itemArraylist.add(Circle);

        Items Trapezium = new Items("Trapezium", R.drawable.trapezium, new Param3_Fragment("Trapezium"));
        itemArraylist.add(Trapezium);

        Items Kite = new Items("Kite", R.drawable.kite, new Param2_Fragment("Kite"));
        itemArraylist.add(Kite);
    }

    private void setFragment(Fragment fragment){
        FragmentManager manager = getParentFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.frame, fragment);
        transaction.commit();

    }
    public void onItemClick(View view, int position){
        setFragment(adapter.getFragment(position));
    }
}
