package com.example.aluno.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.google.android.gms.maps.MapView;

public class MainActivity extends AppCompatActivity {
    private TextView crono;
    private ToggleButton onoff;
    private Button stop;
    private MapView mapa;
    private Chronometer cronome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MapView mapa = (MapView) findViewById(R.id.mapa) ;
        mapa.setClickable(true) ;

       /* MyLocationOverlay
        MyLocation
        MyLocationOverlay mlo = new MyLocationOverlay(this, mapView) ;
        mlo.enableCompass() ;
        mlo.enableMyLocation() ;
        mapView.getOverlays().add(mlo) ;*/
    }
}
