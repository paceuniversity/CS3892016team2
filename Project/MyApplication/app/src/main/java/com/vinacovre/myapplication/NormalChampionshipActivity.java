package com.vinacovre.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.Query;

import com.google.android.gms.maps.*;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.*;


public class NormalChampionshipActivity extends AppCompatActivity implements OnMapReadyCallback {



    TextView champName;
    //TextView champCreator;
    TextView champLocation;
    TextView champDate;
    TextView champTime;
    TextView champType;
    TextView champDesc;
    TextView champiCity;
    EditText search;
    Button searchButton;
    Button Attend;
    private final static String FIREBASE_URL = "https://meupipaapplication.firebaseio.com/championships";
    private Firebase firebaseRef;
    private GoogleMap mMap;
    int n = 2;
    String newName, champCity;
    Championship champ;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Bundle extras = getIntent().getExtras();

        if (extras != null) {
         //champ = (Championship) extras.get("Name");
            newName = extras.getString("name");
            champCity = extras.getString("city");
        }


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal_championship);
        Firebase.setAndroidContext(this);
        firebaseRef = new Firebase(FIREBASE_URL);
        champName = (TextView) findViewById(R.id.ChampionshipName);
        //champCreator = (TextView) findViewById(R.id.ChampionshipCreator);
        champDesc = (TextView) findViewById(R.id.ChampionshipDesc);
        champLocation = (TextView) findViewById(R.id.ChampionshipLocation);
        champDate = (TextView) findViewById(R.id.ChampionshipDate);
        champTime = (TextView) findViewById(R.id.ChampionshipTime);
        champType = (TextView) findViewById(R.id.ChampionshipType);
        champiCity = (TextView)findViewById(R.id.ChampionshipCity);
        search = (EditText) findViewById(R.id.searchText);
        searchButton = (Button) findViewById(R.id.Search);
        Attend = (Button) findViewById(R.id.Attending);
//        champName.setText(champ.getChampionshipName());

        pullsearch();
        setUpMapIfNeeded();
       // champName.setText(champ.getChampionshipName());
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
//        searchButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//               pullsearch();
//
//            }
//        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }
    private void setUpMapIfNeeded() {
        if (mMap != null) {
            return;
        }
        mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map_fragment)).getMap();
        if (mMap == null) {
            return;
        }
        // Initialize map options. For example:
        // mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
    }
    private void moveToCurrentLocation(LatLng currentLocation)
    {
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(currentLocation,15));
        // Zoom in, animating the camera.
        mMap.animateCamera(CameraUpdateFactory.zoomIn());
        // Zoom out to zoom level 10, animating with a duration of 2 seconds.
        mMap.animateCamera(CameraUpdateFactory.zoomTo(15), 2000, null);


    }

    @Override
    public void onMapReady(GoogleMap map) {
//        if (champCity == "Sao Paolo" ){
        map.addMarker(new MarkerOptions().position(new LatLng(-3.732107, -38.525680)).title("Fortaleza Pipa"));
         // Marker saoPaolo = map.addMarker(new MarkerOptions().position(new LatLng(-23.576016, -46.628434)).title("Marker"));
            //moveToCurrentLocation(saoPaolo.getPosition());
//        }
//        if (champCity == "Rio de Janeiro" ){
//            Marker Rio = map.addMarker(new MarkerOptions().position(new LatLng(-22.908458, -43.191578)).title("Marker"));
//            moveToCurrentLocation(Rio.getPosition());
//        }
//        if (champCity == "Salvador" ){
//            Marker salvador = map.addMarker(new MarkerOptions().position(new LatLng(-12.972584, -38.492443)).title("Marker"));
//            moveToCurrentLocation(salvador.getPosition());
//        }
//        if (champCity == "Fortaleza" ){
//           Marker fortaleza = map.addMarker(new MarkerOptions().position(new LatLng(-3.732107, -38.525680)).title("Marker"));
//            moveToCurrentLocation(fortaleza.getPosition());
//        }
//        if (champCity == "Belo Horizonte" ){
//           Marker belo =  map.addMarker(new MarkerOptions().position(new LatLng(-19.916525, -43.923245)).title("Marker"));
//            moveToCurrentLocation(belo.getPosition());
//        }
//        if (champCity == "Brasilia" ){
//           Marker brasilia = map.addMarker(new MarkerOptions().position(new LatLng(-15.792428, -47.866838)).title("Marker"));
//            moveToCurrentLocation(brasilia.getPosition());
//        }
//        if (champCity == "Curitiba" ){
//           Marker curitiba = map.addMarker(new MarkerOptions().position(new LatLng(-25.429371, -49.265442)).title("Marker"));
//            moveToCurrentLocation(curitiba.getPosition());
//        }
//        if (champCity == "Manaus" ){
//            Marker manaus = map.addMarker(new MarkerOptions().position(new LatLng(-3.116287, -59.992590)).title("Marker"));
//            moveToCurrentLocation(manaus.getPosition());
//        }
//        if (champCity == "Recife" ){
//            Marker recife = map.addMarker(new MarkerOptions().position(new LatLng(-8.060023, -34.888556)).title("Marker"));
//            moveToCurrentLocation(recife.getPosition());
//        }
//        if (champCity == "Belem" ){
//           Marker belem = map.addMarker(new MarkerOptions().position(new LatLng(-1.468236, -48.473668)).title("Marker"));
//            moveToCurrentLocation(belem.getPosition());
//        }


    }


    public void pullsearch() {


            String searchName = "championshipName";
            Query queryRef = firebaseRef.orderByChild(searchName).equalTo(newName);




            queryRef.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot snapshot, String previousChild) {
                    Championship champ = snapshot.getValue(Championship.class);

                    // Map<String, String> value = (Map<String, String>)snapshot.getValue();
                    champName.setText(champ.getChampionshipName());
                    //champCreator.setText(champ.getChampionshipCreator());
                    champLocation.setText(champ.getChampionshipLocation());
                    champDate.setText(champ.getChampionshipDate());
                    champTime.setText(champ.getChampionshipTime());
                    champType.setText(champ.getChampionshipType() + " Championship");
                    champDesc.setText(champ.getChampionshipDesc());
                    champiCity.setText(champ.getChampionshipCity() + ", Brazil");

                   // int numberPlayers = champ.getNumberPlayers();
                    //numberPlayers+=1;
                    //This gets the first index, I dont know how to choose which one to grab
                    //Maybe I have to change String previousCHild to the index string?'
                    //snapshot.getRef().child("numberPlayers").setValue(1);

                }

                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onChildRemoved(DataSnapshot dataSnapshot) {

                }

                @Override
                public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
                // ...
            });
        }

    }


