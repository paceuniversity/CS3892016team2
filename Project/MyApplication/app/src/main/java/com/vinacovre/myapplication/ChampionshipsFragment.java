package com.vinacovre.myapplication;


//import android.location.Location;
//
//import android.content.IntentSender;
//import android.util.Log;
//
//import com.google.android.gms.common.ConnectionResult;
//import com.google.android.gms.common.api.GoogleApiClient;
//import com.google.android.gms.location.LocationListener;
//import com.google.android.gms.location.LocationRequest;
//import com.google.android.gms.location.LocationServices;
//import com.google.android.gms.maps.CameraUpdateFactory;

import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.firebase.client.Firebase;
import com.firebase.client.ValueEventListener;
import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.*;

import java.io.Serializable;

// GoogleApiClient.ConnectionCallbacks,GoogleApiClient.OnConnectionFailedListener, LocationListener

public class ChampionshipsFragment extends Fragment implements OnMapReadyCallback  {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    public static final String TAG = ChampionshipsFragment.class.getSimpleName();
    private final static int CONNECTION_FAILURE_RESOLUTION_REQUEST = 9000;
    private GoogleMap mMap; // Might be null if Google Play services APK is not available.
//    private GoogleApiClient mGoogleApiClient;
//    private LocationRequest mLocationRequest;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;



    private Firebase firebaseRef;

    private String FIREBASE_URL = "https://meupipaapplication.firebaseio.com";
    private ValueEventListener mConnectedListener;
    private ChampionshipAdapter ChampionshipListAdapter;



    public ChampionshipsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ChampionshipsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ChampionshipsFragment newInstance(String param1, String param2) {
        ChampionshipsFragment fragment = new ChampionshipsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);


        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);




//            mGoogleApiClient = new GoogleApiClient.Builder(getActivity())
//                    .addConnectionCallbacks(this)
//                    .addOnConnectionFailedListener(this)
//                    .addApi(LocationServices.API)
//                    .build();
//
//            // Create the LocationRequest object
//            mLocationRequest = LocationRequest.create()
//                    .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY)
//                    .setInterval(10 * 1000)        // 10 seconds, in milliseconds
//                    .setFastestInterval(1 * 1000); // 1 second, in milliseconds

        }

        firebaseRef = new Firebase(FIREBASE_URL).child("championships");


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        FloatingActionButton fab = (FloatingActionButton) getView().findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), AddChampionshipActivity.class);
                startActivity(intent);
            }
        });

        Button searchButton = (Button) getView().findViewById(R.id.Search);
        EditText search = (EditText) getView().findViewById(R.id.searchText);
        //String champCity = getActivity().getIntent().getExtras().getString("city");






    }
//
//    @Override
//    public void onResume() {
//        super.onResume();
//        mGoogleApiClient.connect();
//    }

    @Override
    public void onMapReady(GoogleMap map) {
//
//        if (champCity == "Sao Paolo" ){
//            map.addMarker(new MarkerOptions().position(new LatLng(-23.576016, -46.628434)).title("Marker"));
//        }
//        if (champCity == "Rio de Janeiro" ){
//            map.addMarker(new MarkerOptions().position(new LatLng(-22.908458, -43.191578)).title("Marker"));
//        }
//        if (champCity == "Salvador" ){
//            map.addMarker(new MarkerOptions().position(new LatLng(-12.972584, -38.492443)).title("Marker"));
//        }
//        if (champCity == "Fortaleza" ){
//            map.addMarker(new MarkerOptions().position(new LatLng(-3.732107, -38.525680)).title("Marker"));
//        }
//        if (champCity == "Belo Horizonte" ){
//            map.addMarker(new MarkerOptions().position(new LatLng(-19.916525, -43.923245)).title("Marker"));
//        }
//        if (champCity == "Brasilia" ){
//            map.addMarker(new MarkerOptions().position(new LatLng(-15.792428, -47.866838)).title("Marker"));
//        }
//        if (champCity == "Curitiba" ){
//            map.addMarker(new MarkerOptions().position(new LatLng(-25.429371, -49.265442)).title("Marker"));
//        }
//        if (champCity == "Manaus" ){
//            map.addMarker(new MarkerOptions().position(new LatLng(-3.116287, -59.992590)).title("Marker"));
//        }
//        if (champCity == "Recife" ){
//            map.addMarker(new MarkerOptions().position(new LatLng(-8.060023, -34.888556)).title("Marker"));
//        }
//        if (champCity == "Belem" ){
//            map.addMarker(new MarkerOptions().position(new LatLng(-1.468236, -48.473668)).title("Marker"));
//        }

        map.addMarker(new MarkerOptions().position(new LatLng(-3.732107, -38.525680)).title("Fortaleza Pipa"));
        map.addMarker(new MarkerOptions().position(new LatLng(-12.972584, -38.492443)).title("Kite Fight"));
        map.addMarker(new MarkerOptions().position(new LatLng(-22.908458, -43.191578)).title("Our friendly meet"));
        map.addMarker(new MarkerOptions().position(new LatLng(-15.792428, -47.866838)).title("Brasilia Kite"));
        map.addMarker(new MarkerOptions().position(new LatLng(-19.916525, -43.923245)).title("grajau combate"));
        map.addMarker(new MarkerOptions().position(new LatLng(-25.429371, -49.265442)).title("combate no morro alemon"));



    }

//    @Override
//    public void onPause() {
//        super.onPause();
//
//        if (mGoogleApiClient.isConnected()) {
//            LocationServices.FusedLocationApi.removeLocationUpdates(mGoogleApiClient, this);
//            mGoogleApiClient.disconnect();
//        }}

//
//    private void handleNewLocation(Location location) {
//        Log.d(TAG, location.toString());
//
//        double currentLatitude = location.getLatitude();
//        double currentLongitude = location.getLongitude();
//
//        LatLng latLng = new LatLng(currentLatitude, currentLongitude);
//
//        //mMap.addMarker(new MarkerOptions().position(new LatLng(currentLatitude, currentLongitude)).title("Current Location"));
//        MarkerOptions options = new MarkerOptions()
//                .position(latLng)
//                .title("I am here!");
//        mMap.addMarker(options);
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
//    }
//
//
//    @Override
//    public void onConnected(Bundle bundle) {
//        try {
//        Location location = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);if (location == null) {
//                LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, this);
//            }
//            else {
//                handleNewLocation(location);
//            }}
//        catch (SecurityException e) {
//
//        }
//
//
//
//    }
//
//    @Override
//    public void onConnectionSuspended(int i) {
//
//    }
//
//    @Override
//    public void onConnectionFailed(ConnectionResult connectionResult) {
//    /*
//     * Google Play services can resolve some errors it detects.
//     * If the error has a resolution, try sending an Intent to
//     * start a Google Play services activity that can resolve
//     * error.
//     */
//        if (connectionResult.hasResolution()) {
//            try {
//                // Start an Activity that tries to resolve the error
//                connectionResult.startResolutionForResult(getActivity(), CONNECTION_FAILURE_RESOLUTION_REQUEST);
//            /*
//             * Thrown if Google Play services canceled the original
//             * PendingIntent
//             */
//            } catch (IntentSender.SendIntentException e) {
//                // Log the error
//                e.printStackTrace();
//            }
//        } else {
//        /*
//         * If no resolution is available, display a dialog to the
//         * user with the error.
//         */
//            Log.i(TAG, "Location services connection failed with code " + connectionResult.getErrorCode());
//        }
//    }
//
//    @Override
//    public void onLocationChanged(Location location) {
//        handleNewLocation(location);
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_championships, container, false);

        final ListView listView =(ListView) view.findViewById(R.id.championshipListView);

        ChampionshipListAdapter = new ChampionshipAdapter(firebaseRef,this.getActivity(), R.layout.list_view_layout);
        listView.setAdapter(ChampionshipListAdapter);
        ChampionshipListAdapter.registerDataSetObserver( new DataSetObserver() {
            @Override
            public void onChanged() {
                super.onChanged();
                listView.setSelection(ChampionshipListAdapter.getCount() - 1);


            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Championship championship = (Championship) listView.getAdapter().getItem(position);
                String name = championship.getChampionshipName();

                System.out.println(championship.getChampionshipName());
                Intent intent = new Intent(getActivity(), NormalChampionshipActivity.class);
               //intent.putExtra("Name", (Parcelable) championship);
               intent.putExtra("name", name);
                startActivity(intent);

            }
        });


        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map_fragment);
        mapFragment.getMapAsync(this);

        // Inflate the layout for this fragment
        return view;
    }

}
