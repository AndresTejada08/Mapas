package com.example.mapas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button bttn_sitios_turisticos, bttn_mi_ubicacion, bttn_tipos_mapa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bttn_sitios_turisticos = findViewById(R.id.bttnSitiosTuristicos);
        bttn_mi_ubicacion = findViewById(R.id.bttnMiUbicacion);
        bttn_tipos_mapa = findViewById(R.id.bttnTiposMapa);

        bttn_sitios_turisticos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MapsActivity.class);
                startActivity(intent);
            }
        });

        bttn_mi_ubicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MapsActivityUbicacion.class);
                startActivity(intent);
            }
        });

        bttn_tipos_mapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MapsActivityTipos.class);
                startActivity(intent);
            }
        });
    }
}