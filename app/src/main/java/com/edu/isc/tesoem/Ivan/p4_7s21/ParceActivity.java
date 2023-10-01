package com.edu.isc.tesoem.omar.p4_7s21;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import DatosParce.DatosParce;

public class ParceActivity extends AppCompatActivity {

    TextView lblnombre, lblcorreo, lbledad;
    Button btnregresa;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parce);

        lblnombre = findViewById(R.id.p3lblnombre);
        lbledad = findViewById(R.id.p3lbledad);
        lblcorreo = findViewById(R.id.p3lblcorreo);
        btnregresa = findViewById(R.id.p3btnregresa);

        DatosParce datosParce = getIntent().getParcelableExtra("datosparcelables");
        lblnombre.setText(datosParce.getNombre());
        lbledad.setText(String.valueOf(datosParce.getEdad()));
        lblcorreo.setText(datosParce.getCorreo());

        btnregresa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent lanza = new Intent(ParceActivity.this, ParceActivity.class);
                startActivity(lanza);
                finish();
            }
        });

    }
}