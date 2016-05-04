package cs389.paceuniversity.meupipa;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class CreateChampionship extends AppCompatActivity {
    EditText ChampionshipName;
    EditText ChampionshipLocation; //These three are just my edit text boxes started with just them
    EditText ChampionshipTime;
    EditText ChampionshipDate;
    RadioButton ChampionshipFriendlyType;
    RadioButton ChampionshipTournamentType;
    private final static String FIREBASE_URL = "https://meu-pipa1.firebaseio.com/"; //Create a string to store the database url
    private Firebase FirebaseRef; //Creates a reference connection to the firebase database
    Championships champion = new Championships();

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_championship); //sets the layout of the class to the create championship xml class
        Firebase.setAndroidContext(this); //This is setting the firebase context to this class, meanining that the infomration
        //generate and manipulated is done by this class
        FirebaseRef = new Firebase(FIREBASE_URL); //connects local firebase client to the firebase database

    }

    protected void onStart()
    {
        super.onStart();
        ChampionshipName = (EditText)findViewById(R.id.ChampionshipName);
        ChampionshipLocation = (EditText)findViewById(R.id.ChampionshipLocation);
        ChampionshipTime = (EditText)findViewById(R.id.ChampionshipTime);  //Listeners for the text files


        //Listeners for the edit texts and for the create championship button
        //returns false on all listeners besides the create championship button because we don't want
        //to consume the object until the button is clicked
        ChampionshipName.setOnEditorActionListener(new TextView.OnEditorActionListener(){
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event)
            {
                sendMessage();
                return false;
            }


        });

        ChampionshipLocation.setOnEditorActionListener(new TextView.OnEditorActionListener(){
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event)
            {
                sendMessage();
                return false;
            }


        });

        ChampionshipTime.setOnEditorActionListener(new TextView.OnEditorActionListener(){
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event)
            {
                sendMessage();
                return false;
            }


        });

        ChampionshipDate.setOnEditorActionListener(new TextView.OnEditorActionListener(){
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event)
            {
                sendMessage();
                return false;
            }


        });

        ChampionshipFriendlyType.setOnEditorActionListener(new TextView.OnEditorActionListener(){
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event)
            {
                sendMessage();
                return false;
            }


        });

        ChampionshipTournamentType.setOnEditorActionListener(new TextView.OnEditorActionListener(){
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event)
            {
                sendMessage();
                return false;
            }


        });



        findViewById(R.id.CreateChampionship).setOnClickListener(new View.OnClickListener()
        {
           public void onClick(View v)
           {
               sendMessage();
           }
        });
    }



    public void sendMessage()
    {

        //This is used to handle messages of our forum and to send the appropriate data to our classes
        //If the return isnt false then the information is sent to the database
        //If statements checks to see that the appropriate text field is not blank
        //Will eventually have it so that it links to the page of un editable text boxes**** TO DO

        EditText textChampNameInput = (EditText) (findViewById(R.id.ChampionshipName));
        String ChampName = textChampNameInput.getText().toString();


        EditText textChampLocationInput = (EditText) (findViewById(R.id.ChampionshipLocation));
        String ChampLocation = textChampLocationInput.getText().toString();

        EditText textChampDateInput = (EditText) (findViewById(R.id.ChampionshipDate));
        String ChampDate = textChampDateInput.getText().toString();

        EditText textChampTimeInput = (EditText) (findViewById(R.id.ChampionshipTime));
        String ChampTime = textChampTimeInput.getText().toString();

        String ChampType = "";

        RadioButton radChampFriendlyTypeInput = (RadioButton) (findViewById(R.id.ChampionshipFriendlyType));
       if(radChampFriendlyTypeInput.isChecked())
        {
            ChampType = "Friendly";
        }


        RadioButton racChampTournamentTypeInput = (RadioButton) (findViewById(R.id.ChampionshipTounramentType));
        if(racChampTournamentTypeInput.isChecked())
        {
            ChampType = "Tournament";
        }



        if(!ChampName.equals(""))
        {
            champion.setChampionshipName(ChampName);
            champion.setChampionshipCreator("Admin");

            if(!ChampLocation.equals(""))
            {
                champion.setChampionshipLocation(ChampLocation);

                if(!ChampDate.equals(""))
                {
                    champion.setChampionshipDate(ChampDate);
                    if(!ChampTime.equals(""))
                    {
                        champion.setChampionshipTime(ChampTime);

                        if(!ChampType.equals(""))
                        {
                            if(ChampType.equals("Friendly"))
                            {
                                champion.setChampionshipType(ChampType);
                            }else if(ChampType.equals("Tournament"))
                            {
                                champion.setChampionshipType(ChampType);

                            }


                            FirebaseRef.push().setValue(champion);
                            textChampNameInput.setText("");
                            textChampLocationInput.setText("");
                            textChampDateInput.setText("");
                            textChampTimeInput.setText("");

                            //This may have to get moved outside of this if statement
                            

                        }

                    }
                }
            }



        }
    }
        /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_championship);

        RadioButton friendlyMeetup = (RadioButton) findViewById(R.id.FriendlyMeetup);
        friendlyMeetup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        Button championshipNext = (Button) findViewById(R.id.ChampionshipNext);
        championshipNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CreateChampionship.this, FinishChampionship.class);
            }
        });
    } */

}
//    public void onRadioButtonClicked(View view) {
//        boolean checked = ((android.widget.RadioButton) view).isChecked();
//
//        // Check which radio button was clicked
//        switch(view.getId()) {
//            case R.id.FriendlyMeetup:
//                if (checked)
//                    //
//                    break;
//            case R.id.NormalTournment:
//                if (checked)
//                    //
//                    break;
//        }
//    }   ojp