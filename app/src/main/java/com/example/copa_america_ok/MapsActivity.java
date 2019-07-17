package com.example.copa_america_ok;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnInfoWindowClickListener {

    private GoogleMap mMap;
    private Marker InfoWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;


        // Add a marker in Sydney and move the camera
        LatLng morumbi = new LatLng(-23.853687, -54.112186);
        mMap.addMarker(new MarkerOptions().position(morumbi).title("Estadio Morumbi").icon(BitmapDescriptorFactory.fromResource(R.drawable.estadio)).snippet("Capacidad 66 mil Espectadores"));


        LatLng cor = new LatLng(-23.5455266, -46.4741904);
        mMap.addMarker(new MarkerOptions().position(cor).title("Estadio Arena Corinthians").icon(BitmapDescriptorFactory.fromResource(R.drawable.estadio)).snippet("Capacidad 49 mil Espectadores"));

        LatLng font = new LatLng(-12.978897132319617, -38.50380191294835);
        mMap.addMarker(new MarkerOptions().position(font).title("Estadio Arena Fonte Nova").icon(BitmapDescriptorFactory.fromResource(R.drawable.estadio)).snippet("Capacidad 50 mil Espectadores"));

        LatLng min = new LatLng(-19.86587799285769, -43.971066688529845);
        mMap.addMarker(new MarkerOptions().position(min).title("Estadio Mineirao").icon(BitmapDescriptorFactory.fromResource(R.drawable.estadio)).snippet("Capacidad 62 mil Espectadores"));

        LatLng gre = new LatLng(-29.974045178392814, -51.195108892496194
        );
        mMap.addMarker(new MarkerOptions().position(gre).title("Estadio Arena do Gremio").icon(BitmapDescriptorFactory.fromResource(R.drawable.estadio)).snippet("Capacidad 60 mil Espectadores"));

        LatLng mar = new LatLng(-22.912092, -43.2311454
        );
        mMap.addMarker(new MarkerOptions().position(mar).title("Estadio Maracana").icon(BitmapDescriptorFactory.fromResource(R.drawable.estadio)).snippet("Capacidad 87 mil Espectadores"));

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(mar,4));
        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);


            }

    @Override
    public void onInfoWindowClick(Marker marker) {
    if (marker.equals(InfoWindow)){
    Mapfragment.newInstance(marker.getTitle(),
            getString(R.string.Morumbiinfo))
            .show(getSupportFragmentManager(),null);
    }
    }
}

