package com.example.manuel.calculadoraprobabilidad;

import java.util.Collections;
import java.util.List;

/**
 * Created by manuel on 10/6/16.
 */
public class CalculadoraProbabilidad {

    private double media;
    private double mediana;
    private double moda;
    private List<Double> numeros;
    private double frecModa;

    //private ArrayList<Double> datos;

    public CalculadoraProbabilidad() {

    }

    public CalculadoraProbabilidad(List numeros) {

        this.numeros = numeros;
    }


    //------------------metodos------------------------------------


    public double getMedia() {

        return this.compara(media);

    }

    public double getMediana() {
        return this.compara(mediana);
    }

    public double getModa() {
        return this.compara(moda);
    }

    private double compara(double x){
        if(!Double.isNaN(x)){
            return x;
        } else {
            return 0.0;
        }

    }

    public List getNumeros() {
        return numeros;
    }

    public void setNumeros(List numeros) {
        this.numeros = numeros;
    }


    public double Suma(){
        double sum = 0;

        for (double l:numeros
                ) {
            sum += l;
        }

        return sum;

    }

    public double getFrecModa() {
        return frecModa;
    }

    public double CalculoMedia(){



        this.media = this.Suma()/numeros.size();

        return media;
    }

    public double CalculoMediana(){

        int i = 0; double valor = 0.0;

        Collections.sort(numeros);

        if(numeros.size()%2 == 0){
            i = (numeros.size()/2)-1;
            valor = numeros.get(i) + numeros.get(i+1);
            this.mediana = valor/2;
        }else{
            //es impar
            i = (numeros.size()/2) - 1;
            this.mediana =  numeros.get(i);
        }

        return this.mediana;
    }

    public double CalculoModa(){

        Collections.sort(numeros);

        double frecModa = 0.0, moda = 0.0;
        int tempFrecuencia;


        for(int i = 0; i < numeros.size(); i++){
            tempFrecuencia = 1;

            for(int j = i + 1; j < numeros.size(); j++){
                if(numeros.get(i) == numeros.get(j))
                    tempFrecuencia ++;
            }

            if(tempFrecuencia > frecModa){
                frecModa = tempFrecuencia;
                moda = numeros.get(i);
            }
        }

        this.moda = moda;
        this.frecModa = frecModa;

        return this.moda;
    }

}
