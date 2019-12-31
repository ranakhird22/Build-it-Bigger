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


        String Joke = null;

        Intent intent = getIntent();
        Joke = intent.getStringExtra("jokes");

        if (Joke != null) {

            Toast.makeText(getApplicationContext(), Joke, Toast.LENGTH_LONG).show();
        } else {

            Toast.makeText(getApplicationContext(), "no joke error ", Toast.LENGTH_LONG).show();
        }

    }


}
