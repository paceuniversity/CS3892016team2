package com.vinacovre.myapplication;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.firebase.client.Query;

public class ChampionshipAdapter extends FirebaseListAdapter<Championship> {

    String championshipName;

    public ChampionshipAdapter(Query ref, Activity activity, int layout)
    {
        super(ref, Championship.class, layout, activity);
    }

    @Override
    protected void populateView(View v, Championship championship) {

         championshipName = championship.getChampionshipName();
        String championshipLocation = championship.getChampionshipLocation();
        String championshipTime = championship.getChampionshipTime();
        String championshipDate = championship.getChampionshipDate();
        String championshipType = championship.getChampionshipType();
        String championshipCity = championship.getChampionshipCity();


        TextView championshipNameText = (TextView) v.findViewById(R.id.championshipName);
        TextView championshipLocationText = (TextView) v.findViewById(R.id.championshipLocation);
        TextView championshipTimeText = (TextView) v.findViewById(R.id.championshipTime);
        TextView championshipDateText = (TextView) v.findViewById(R.id.championshipDate);
        ImageView championshipTypeImage = (ImageView) v.findViewById(R.id.championshipType);

        championshipNameText.setText(championshipName);
        championshipLocationText.setText(championshipLocation);
        championshipTimeText.setText(championshipTime);
        championshipDateText.setText(championshipDate);

        if (championshipType == "Friendly") {
            championshipTypeImage.setImageResource(R.mipmap.friendly_64x64);
        } else if (championshipType == "Normal")  { //Currently doesn't update correctly
            championshipTypeImage.setImageResource(R.mipmap.normal_64x64);
        }
    }

    public String getName(){
        return championshipName;

    }

}