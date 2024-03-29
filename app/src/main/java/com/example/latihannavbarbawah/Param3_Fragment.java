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


public class Param3_Fragment extends Fragment {

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
    EditText Sisi;
    EditText Lebar;
    EditText Tinggi;
    Button calculate;
    Button clear;

    public Param3_Fragment(String name) {

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
        return inflater.inflate(R.layout.fragment_3param, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Sisi = view.findViewById(R.id.Sisi1);
        Lebar = view.findViewById(R.id.Sisi2);
        Tinggi = view.findViewById(R.id.Sisi3);
        calculate = view.findViewById(R.id.calculate);
        clear = view.findViewById(R.id.Clear);
        Shape = view.findViewById(R.id.idk);
        rult = view.findViewById(R.id.ruslt);
        Shape.setText(SName);
        if (SName == "Trapezium"){
            Sisi.setHint("Lebar atas");
            Lebar.setHint("Lebar bawah");
            Tinggi.setHint("Tinggi");
        }

        calculate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (Sisi.getText().toString().isEmpty() || Lebar.getText().toString().isEmpty() || Tinggi.getText().toString().isEmpty()){

                    rult.setText("Isikan Semuanya");

                } else {
                    Calculations calc = new Calculations(Double.parseDouble(Sisi.getText().toString()), Double.parseDouble(Lebar.getText().toString()), Double.parseDouble(Tinggi.getText().toString()));
                    if(Shape.getText().equals("Cube")){

                        rult.setText("Hasilnya: " + String.valueOf(calc.Cube()));

                    } else if(Shape.getText().equals("Trapezium")){

                        rult.setText("Hasilnya: " + String.valueOf(calc.Trapezium()));

                    }else if(Shape.getText().equals("Prism")){

                        rult.setText("Hasilnya: " + String.valueOf(calc.Prism()));

                    } else if(Shape.getText().equals("Cone")){

                        rult.setText("Hasilnya: " + String.valueOf(calc.Cone()));

                    }

                }

            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sisi.setText(null);
                Lebar.setText(null);
                Tinggi.setText(null);
                rult.setText("Result");
            }
        });
    }
}