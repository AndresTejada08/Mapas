package com.example.mapas;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.mapas.databinding.ActivityMapsBinding;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    private GoogleMap mMap;
    private Marker markerPrueba;
    private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng IPD = new LatLng(-13.5233536, -71.9650816);
        mMap.addMarker(new MarkerOptions().position(IPD).title("IPD").snippet("El Instituto Peruano de Deporte es un lugar donde las personas pueden hacer todo tipo de deporte"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(IPD));

        //Agregar un icono diferente de marcador
        LatLng UAC = new LatLng(-13.5371066, -71.904043);
        mMap.addMarker(new MarkerOptions().position(UAC).title("UAC").snippet("Universidad Andina del Cusco").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_mapa)));

        //Color marcador
        LatLng Quillabamba = new LatLng(-12.8663479, -72.6924428);
        mMap.addMarker(new MarkerOptions().position(Quillabamba).title("Quillabamba").snippet("Quillabamba, ciudad del eterno verano").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));

        //Arrastrar Marcador
        LatLng Machupicchu = new LatLng(-13.164422, -72.5450851);
        mMap.addMarker(new MarkerOptions().position(Machupicchu).draggable(true).title("Machupicchu").snippet("4ta Maravilla del Mundo").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        //Marcador Prueba
        LatLng Lima = new LatLng(-12.0621065, -77.0365256);
        mMap.addMarker(new MarkerOptions().position(Lima).title("Lima").snippet("La ciudad mas grande y capital del Perú").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)));

        //Camara zoom
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Lima, 7));

        googleMap.setOnMarkerClickListener(this);
    }

    @Override
    public boolean onMarkerClick(@NonNull Marker marker) {
        //Obtener la latitud y la longitud
        String lat, lon;
        lat = Double.toString(marker.getPosition().latitude);
        lon = Double.toString(marker.getPosition().longitude);
        Toast.makeText(this, lat + ", " + lon, Toast.LENGTH_LONG).show();
        return false;
    }
}