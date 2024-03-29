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


public class RuangFragment extends Fragment {

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

    public RuangFragment() {

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ruang, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        dataInitialized();
        recyclerview = view.findViewById(R.id.Rvlist2);
        recyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerview.setHasFixedSize(true);
        adapter = new MAdapter(getContext(),itemArraylist);
        recyclerview.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        adapter.setClickListener(this::onItemClick);
    }

    private void dataInitialized() {

        itemArraylist = new ArrayList<>();

        Items Cube = new Items("Cube", R.drawable.cube, new Param3_Fragment("Cube"));
        itemArraylist.add(Cube);

        Items sphere = new Items("Sphere", R.drawable.circle, new Param1_Fragment("Sphere"));
        itemArraylist.add(sphere);

        Items Prism = new Items("Prism", R.drawable.prism, new Param3_Fragment("Prism"));
        itemArraylist.add(Prism);

        Items Cylinder = new Items("Cylinder", R.drawable.cylinder, new Param2_Fragment("Cylinder"));
        itemArraylist.add(Cylinder);

        Items Cone = new Items("Cone", R.drawable.cone, new Param2_Fragment("Cone"));
        itemArraylist.add(Cone);

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
