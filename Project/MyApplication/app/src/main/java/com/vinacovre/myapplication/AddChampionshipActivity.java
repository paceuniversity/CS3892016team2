package com.vinacovre.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import java.util.ArrayList;
import java.util.List;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;



import com.firebase.client.Firebase;
import com.firebase.client.ValueEventListener;
import com.google.android.gms.common.api.GoogleApiClient;

import java.io.Serializable;
//TODO, reimplement add championship activity with my new Firebase List adapter, this will make it alot smoother
// and i feel like it may give me the ability to do it in a json format, with a key and such
//because of the fact that the firebase adapter uses .key method many a time

public class AddChampionshipActivity extends AppCompatActivity {

    EditText ChampionshipName;
    EditText ChampionshipLocation;
    Spinner ChampionshipCity;
    EditText ChampionshipTime;
    EditText  ChampionshipDescription;
    EditText ChampionshipDate;
    RadioButton FriendlyType;
    RadioButton TorunyType;
    Button addChampionship;

    private final static String FIREBASE_URL = "https://meupipaapplication.firebaseio.com";
    public Firebase firebaseRef;
    private ValueEventListener mConnectedListener;
    private Spinner cityList;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;



    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_championship);
        setTitle("Creating a Championship");
        Firebase.setAndroidContext(this);
        firebaseRef = new Firebase(FIREBASE_URL).child("championships");

        ChampionshipCity = ((Spinner)findViewById(R.id.spinner));

        addChampionship = (Button) findViewById(R.id.ChampionshipNext);
        ChampionshipName = (EditText) findViewById(R.id.ChampionshipName);
        ChampionshipLocation = (EditText)findViewById(R.id.ChampionshipLocation);
        ChampionshipTime = (EditText) findViewById(R.id.ChampionshipTime);
        ChampionshipDate = (EditText) findViewById(R.id.ChampionshipDate);
        FriendlyType = (RadioButton) findViewById(R.id.radio_championship_friendly);
        TorunyType = (RadioButton) findViewById(R.id.radio_championship_normal);
        ChampionshipDescription = (EditText) findViewById(R.id. ChampionshipDescription);


        addListenerOnSpinnerItemSelection();
        addChampionship.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                sendMessage();
            }
        });



    }


   public void addListenerOnSpinnerItemSelection() {
        cityList = (Spinner) findViewById(R.id.spinner);
      cityList.setOnItemSelectedListener(new CustomOnItemSelectedListener());
    }
    public void sendMessage() {


        String ChampName = ChampionshipName.getText().toString();
        String ChampTime = ChampionshipTime.getText().toString();
        String ChampDate = ChampionshipDate.getText().toString();
        String ChampLocation = ChampionshipLocation.getText().toString();
        String ChampType;
        String ChampCity = ChampionshipCity.getSelectedItem().toString();
        String ChampDesc = ChampionshipDescription.getText().toString();

        if (FriendlyType.isChecked() == true) {
            ChampType = "Friendly";
        } else {
            ChampType = "Competitive";
        }

        if (!ChampName.equals("")) {
            if (!ChampTime.equals("")) {
                if (!ChampDate.equals("")) {
                    if (!ChampLocation.equals("")) {
                        if (!ChampType.equals("")) {
                            Championship champions = new Championship(ChampName, "Admin", ChampLocation, ChampDate, ChampTime, ChampType, ChampCity, ChampDesc);

                            Intent intent = new Intent(this, NormalChampionshipActivity.class);
                            intent.putExtra("name", ChampionshipName.getText().toString());
                            intent.putExtra("city",ChampionshipCity.getSelectedItem().toString() );
                           // intent.putExtra("Name", (Serializable) champions);
                            firebaseRef.push().setValue(champions);
                            ChampionshipName.setText("");
                            startActivity(intent);

                        }
                    }
                }
            }
        }



    }
}




/*


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_championship);
        Firebase.setAndroidContext(this);
        firebaseRef = new Firebase(FIREBASE_URL).push();


        ChampionshipName.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEND) {
                    sendMessage();
                }
                return true;
            }
        });





        findViewById(R.id.ChampionshipNext).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage();

            }
        });
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }


 protected void onStart() {
        super.onStart();
        Button championshipNext = (Button)findViewById(R.id.ChampionshipNext);
        championshipNext.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                sendMessage();
               // Intent intent = new Intent(AddChampionshipActivity.this, ChampionshipsFragment.class);
                //startActivity(intent);
            }
        });

        findViewById(R.id.ChampionshipNext).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                sendMessage();
            }
        });
    }*/





   /* @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "AddChampionship Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.vinacovre.myapplication/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "AddChampionship Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.vinacovre.myapplication/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}

  //  getSupportActionBar().setTitle("New Championship");
    //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    /*protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_championship);
        Button next = (Button) findViewById(R.id.ChampionshipNext);*/

        /*next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioGroup radioGroup = (RadioGroup) findViewById(R.id.RadioGroupChampionship);
                switch (radioGroup.getCheckedRadioButtonId()) {
                    case R.id.radio_championship_friendly:
                        Intent intent1 = new Intent(v.getContext(), FriendlyChampionshipActivity.class);
                        startActivity(intent1);
                        break;
                    case R.id.radio_championship_normal:
                        Intent intent2 = new Intent(v.getContext(), NormalChampionshipActivity.class);
                        startActivity(intent2);
                        break;
                }
            }
        });*/


//    public void onRadioButtonClicked(View view) {
//        // Is the button now checked?
//        boolean checked = ((RadioButton) view).isChecked();
//
//        // Check which radio button was clicked
//        switch(view.getId()) {
//            case R.id.radio_championship_friendly:
//                if (checked)
//
//                    break;
//            case R.id.radio_championship_normal:
//                if (checked)
//                    break;
//        }
//    }*/

