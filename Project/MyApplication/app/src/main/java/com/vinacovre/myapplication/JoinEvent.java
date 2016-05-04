package com.vinacovre.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

/**
 * Created by Ryan Faranda on 4/29/2016.
 */
//Grab the information from the text fields and push to firebase database under respective child,
    //when butotn is clicked the method to send is called, then should be linked back to normal championship
    //when linked to normal championship populate list view
public class JoinEvent extends AppCompatActivity {
    EditText playerName;
    EditText playerSkill;
    EditText playerAdress;
    EditText playerAge;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.join_event);


    }









}
