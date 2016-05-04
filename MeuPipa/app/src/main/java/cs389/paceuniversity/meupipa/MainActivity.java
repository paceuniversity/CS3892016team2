package cs389.paceuniversity.meupipa;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button createChampionship = (Button) findViewById(R.id.createChampionship);
        createChampionship.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CreateChampionship.class);
                startActivity(intent);
            }
        });

    }

    public void createChampionshipClicked(View v) {
        int id = v.getId();

        if (id == R.id.createChampionship) {
            Intent i = new Intent(MainActivity.this, CreateChampionship.class);
            startActivity(i);
        }
    }

}
