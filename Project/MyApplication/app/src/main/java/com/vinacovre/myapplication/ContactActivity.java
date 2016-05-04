package com.vinacovre.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class ContactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView tv1 = (TextView) findViewById(R.id.contact_link_fb_chris);
        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentBrowser = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/iwasonceborn"));
                startActivity(intentBrowser);
            }
        });

        TextView tv2 = (TextView) findViewById(R.id.contact_link_fb_mike);
        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentBrowser = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/1486156362"));
                startActivity(intentBrowser);
            }
        });

        TextView tv3 = (TextView) findViewById(R.id.contact_link_fb_ryan);
        tv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentBrowser = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/ryan.faranda"));
                startActivity(intentBrowser);
            }
        });

        TextView tv4 = (TextView) findViewById(R.id.contact_link_fb_vini);
        tv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentBrowser = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/viniciuscovre"));
                startActivity(intentBrowser);
            }
        });
    }

}
