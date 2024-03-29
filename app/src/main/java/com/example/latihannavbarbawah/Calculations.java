package com.example.latihannavbarbawah;

public class Calculations {
    Double uno;
    Double dos;
    Double tress;

    public Calculations(Double uno, Double dos, Double tress) {
        this.uno = uno;
        this.dos = dos;
        this.tress = tress;
    }

    public Double Square(){
        Double result;
        result = uno*dos;
        return result;
    }
    public Double Triangle(){
        Double result;
        result = uno*dos*0.5;
        return result;
    }
    public Double Circle(){
        Double result;
        result = Math.pow(uno, 2)*Math.PI;
        return result;
    }
    public Double Trapezium(){
        Double result;
        result = (uno+dos)*tress*0.5;
        return result;
    }



    public Double Cube(){
        Double result;
        result = uno*dos*tress;
        return result;
    }
    public Double Sphere(){
        Double result;
        result = (4.0 / 3.0) * Math.PI * Math.pow(uno, 3);
        return result;
    }
    public Double Cone(){
        Double result;
        result = (1.0 / 3.0)*Math.pow(uno, 2)*Math.PI*dos;
        return result;
    }
    public Double Prism(){
        Double result;
        result = uno*dos*tress*0.5;
        return result;
    }
    public Double Cylinder(){
        Double result;
        result = Math.pow(uno, 2)*Math.PI*dos;
        return result;
    }

}
