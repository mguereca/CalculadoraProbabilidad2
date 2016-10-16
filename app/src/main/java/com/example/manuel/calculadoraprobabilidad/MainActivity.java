package com.example.manuel.calculadoraprobabilidad;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btnCalcular;
    EditText etDatos;
    TextView tvRespuestas;

    CalculadoraProbabilidad calculadoraProbabilidad;
    double media, mediana, moda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCalcular = (Button) findViewById(R.id.btnCalcular);
        etDatos = (EditText) findViewById(R.id.etDatos);
        tvRespuestas = (TextView) findViewById(R.id.tvRespuestas);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String datos = etDatos.getText().toString();


                if(datos.length() > 0){
                    calculadoraProbabilidad = new CalculadoraProbabilidad(this.Convertir(datos));
                    media = calculadoraProbabilidad.CalculoMedia();
                    mediana = calculadoraProbabilidad.CalculoMediana();
                    moda = calculadoraProbabilidad.CalculoModa();

                    tvRespuestas.setText("Media: "+media+" Mediana: "+mediana+" Moda: "+moda);

                }
            }; //set de datos de tipo double

            private List<Double> Convertir(String datos) {

                String[] arrDatos = datos.split(",");
                List<Double> arrDatos2 = new ArrayList<Double>();

                for(int i = 0; i < arrDatos.length; i++){
                    arrDatos2.add(Double.parseDouble(arrDatos[i]));
                }

                return arrDatos2;
            }
        });
    }
}
