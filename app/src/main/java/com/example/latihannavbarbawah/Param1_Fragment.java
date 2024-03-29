package com.example.latihannavbarbawah;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class Param1_Fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    String SName;
    TextView Shape;
    TextView rult;
    EditText Radious;
    Button calculate;
    Button clear;

    public Param1_Fragment(String name) {

        this.SName = name;

    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_1param, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Radious = view.findViewById(R.id.Sisi1);
        calculate = view.findViewById(R.id.calculate);
        clear = view.findViewById(R.id.Clear);
        Shape = view.findViewById(R.id.idk);
        rult = view.findViewById(R.id.ruslt);
        Shape.setText(SName);

        calculate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if(Radious.getText().toString().isEmpty()){

                    rult.setText("isikan Radious");

                } else {
                    Calculations calc = new Calculations(Double.parseDouble(Radious.getText().toString()), 0.0, 0.0);
                    if(Shape.getText().equals("Circle")){
                        rult.setText("Hasilnya: " + String.valueOf(calc.Circle()));
                    } else if (Shape.getText().equals("Sphere")){
                        rult.setText("Hasilnya: " + String.valueOf(calc.Sphere()));
                    }
                }

            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Radious.setText(null);
                rult.setText("Result");
            }
        });
    }
}