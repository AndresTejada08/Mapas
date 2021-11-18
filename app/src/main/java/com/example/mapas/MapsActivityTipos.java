package com.example.mapas;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.mapas.databinding.ActivityMapsTiposBinding;

public class MapsActivityTipos extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsTiposBinding binding;
    Button bttn_hibrido, bttn_satelital, bttn_terreno, bttn_normal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsTiposBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        bttn_hibrido = findViewById(R.id.bttnHibrido);
        bttn_satelital = findViewById(R.id.bttnSatelital);
        bttn_terreno = findViewById(R.id.bttnTerreno);
        bttn_normal = findViewById(R.id.bttnNormal);
    }

    public void cambiarHibrido (View view) { mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID); }
    public void cambiarSatelital (View view) { mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE); }
    public void cambiarTerreno (View view) { mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN); }
    public void cambiarNormal (View view) { mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL); }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }
}