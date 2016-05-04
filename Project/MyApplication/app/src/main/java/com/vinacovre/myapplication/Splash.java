package com.vinacovre.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

/**
 * Created by vinacovre on 4/22/16.
 */
public class Splash extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

//        final ImageView iv = (ImageView) findViewById(R.id.splash_icon);
//        finish();
//
//        Intent i = new Intent(this, MainActivity.class);
//        startActivity(i);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                Intent i = new Intent(Splash.this,MainActivity.class);
                Splash.this.startActivity(i);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                Splash.this.finish();
            }
        }, 3000);
    }
}
