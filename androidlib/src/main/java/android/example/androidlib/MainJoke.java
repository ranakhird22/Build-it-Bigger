package android.example.androidlib;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainJoke  extends AppCompatActivity {

    String joke;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main_androidlib );

        //String joke =getIntent().getStringExtra( "JOKE" );
       /* Toast.makeText(getApplicationContext(), "hvhvhjhjhh", Toast.LENGTH_LONG).show();
        Intent intent = getIntent();
        //intent.hasExtra( "movie" )

        if (intent.hasExtra( "JOKE" ))
            //String joke =getIntent().getStringExtra( "JOKE" );
            joke =intent.getStringExtra("JOKE");
        Toast.makeText(getApplicationContext(), joke, Toast.LENGTH_LONG).show();*/


        String JokeResult = null;
        //the Intent that started us
        Intent intent = getIntent();
        JokeResult = intent.getStringExtra("jokes");

        if (JokeResult != null) {
          //  textview.setText(JokeResult);
            Toast.makeText(getApplicationContext(), JokeResult, Toast.LENGTH_LONG).show();
        } else {
            //textview.setText("Dig deeper, we gotta find the joke!");
            Toast.makeText(getApplicationContext(), "no joke ", Toast.LENGTH_LONG).show();
        }

    }
//String Joke =getIntent()

}
