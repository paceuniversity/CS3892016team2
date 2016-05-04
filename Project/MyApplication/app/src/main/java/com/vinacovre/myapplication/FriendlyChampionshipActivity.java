package com.vinacovre.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class FriendlyChampionshipActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friendly_championship);
        getSupportActionBar().setTitle("New Friendly Championship");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
