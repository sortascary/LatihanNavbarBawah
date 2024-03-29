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


public class Param2_Fragment extends Fragment {

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
    EditText Sisi1;
    EditText Tinggi;
    Button calculate;
    Button clear;

    public Param2_Fragment(String name) {

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
        return inflater.inflate(R.layout.fragment_2param, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Sisi1 = view.findViewById(R.id.Sisi1);
        Tinggi = view.findViewById(R.id.Sisi2);
        calculate = view.findViewById(R.id.calculate);
        clear = view.findViewById(R.id.Clear);
        Shape = view.findViewById(R.id.idk);
        rult = view.findViewById(R.id.ruslt);
        Shape.setText(SName);
        if (SName == "Kite"){
            Sisi1.setHint("D1");
            Tinggi.setHint("D2");
        } else if (SName == "Cylinder"){
            Sisi1.setHint("Radious");
            Tinggi.setHint("Height");
        }

        calculate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (Sisi1.getText().toString().isEmpty() || Tinggi.getText().toString().isEmpty()){

                    rult.setText("Isikan Semuanya");

                } else {
                    Calculations calc = new Calculations(Double.parseDouble(Sisi1.getText().toString()), Double.parseDouble(Tinggi.getText().toString()), 1.0);
                    if(Shape.getText().equals("Square")){

                        rult.setText("Hasilnya: " + String.valueOf(calc.Square()));

                    } else if (Shape.getText().equals("Triangle")){

                        rult.setText("Hasilnya: " + String.valueOf(calc.Triangle()));

                    } else if (Shape.getText().equals("Kite")){

                        rult.setText("Hasilnya: " + String.valueOf(calc.Triangle()));

                    }else if (Shape.getText().equals("Cylinder")){

                        rult.setText("Hasilnya: " + String.valueOf(calc.Cylinder()));

                    }

                }

            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sisi1.setText(null);
                Tinggi.setText(null);
                rult.setText("Result");
            }
        });
    }
}