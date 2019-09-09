package com.example.aluno.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.google.android.gms.maps.MapView;

public class MainActivity extends AppCompatActivity {

    private Button loc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button loc = (Button) findViewById(R.id.loc);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED ||
                    ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                String[] permissoes = {Manifest.permission.INTERNET, Manifest.permission.WRITE_EXTERNAL_STORAGE};requestPermissions(permissoes, 1);}}


        //Pega o mapa adicionada no arquivo activity_main.xml
        MapView mapa = (MapView) findViewById(R.id.mapaId);
//Fonte de imagens
        mapa.setTileSource(TileSourceFactory.MAPNIK);

//Cria um ponto de referência com base na latitude e longitude
        GeoPoint pontoInicial = new GeoPoint(-7.082433, -41.468516);

        IMapController mapController = mapa.getController();
//Faz zoom no mapa
        mapController.setZoom(15);
//Centraliza o mapa no ponto de referência
        mapController.setCenter(pontoInicial);

//Cria um marcador no mapa
        Marker startMarker = new Marker(mapa);
        startMarker.setPosition(pontoInicial);
        startMarker.setTitle("Ponto Inicial");
//Posição do ícone
        startMarker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        mapa.getOverlays().add(startMarker);

    }
        @Override
        public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
            switch (requestCode) {
                case 1: {
                    // Se a solicitação de permissão foi cancelada o array vem vazio.
                    if (grantResults.length > 0
                            && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                        // Permissão cedida, recria a activity para carregar o mapa, só será executado uma vez
                        this.recreate();

                    }

                }
            }
        }

}
