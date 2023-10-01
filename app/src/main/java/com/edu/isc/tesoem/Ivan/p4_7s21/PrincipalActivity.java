package com.edu.isc.tesoem.omar.p4_7s21;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import DatosParce.DatosParce;

public class PrincipalActivity extends AppCompatActivity {

    Button btnab,btnap,btnar;

    EditText txtnombre,txtcorreo,txtedad;

    ActivityResultLauncher<Intent> activityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            if (result.getResultCode() == RESULT_OK){
                Toast.makeText(PrincipalActivity.this, "Regreso con exito", Toast.LENGTH_SHORT).show();
            }else if (result.getResultCode() == RESULT_CANCELED){
                Toast.makeText(PrincipalActivity.this, "Se cancelo por el usuario", Toast.LENGTH_SHORT).show();
            }
        }
    });

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        txtnombre = findViewById(R.id.p1txtnombre);
        txtcorreo = findViewById(R.id.p1txtcorreo);
        txtedad = findViewById(R.id.p1txtedad);

        //aqui enlazamos los botones
        btnab = findViewById(R.id.p1btnab);
        btnap = findViewById(R.id.p1btnap);
        btnar = findViewById(R.id.p1btnar);

        //aqui activmamos la escucha del click
        btnab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent lanza = new Intent(PrincipalActivity.this, BasicaActivity.class);
                lanza.putExtra("nombre",txtnombre.getText().toString());
                startActivity(lanza);
            }
        });

        btnap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatosParce datosParce = new DatosParce(txtnombre.getText().toString(),txtcorreo.getText().toString(),Integer.parseInt(txtedad.getText().toString()));
                Intent lanza = new Intent(PrincipalActivity.this, ParceActivity.class);
                lanza.putExtra("datosparcelables",datosParce);
                startActivity(lanza);
            }
        });

        btnar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent lanza = new Intent(PrincipalActivity.this, RegresaActivity.class);
                activityResult.launch(lanza);
            }
        });
    }

    }
