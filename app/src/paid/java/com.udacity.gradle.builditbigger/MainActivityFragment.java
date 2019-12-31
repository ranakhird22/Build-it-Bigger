package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.example.androidlib.MainJoke;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import androidx.fragment.app.Fragment;




/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }
    ProgressBar progressBar = null;
    public String loadedJoke = null;
    public boolean testFlag = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);




        Button button = (Button) root.findViewById(R.id.joke_btn);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                getJoke();
            }
        });

        progressBar = (ProgressBar) root.findViewById(R.id.joke_progressbar);
        progressBar.setVisibility(View.GONE);
        return root;
    }


    public void getJoke(){
        new EndpointsAsyncTask().execute(this);
    }

    public void launchDisplayJokeActivity(){
        if(!testFlag){
        Context context = getActivity();
        Intent intent = new Intent(context, android.example.androidlib.MainJoke.class);

        intent.putExtra("jokes", loadedJoke);

        context.startActivity(intent);

        progressBar.setVisibility(View.GONE);}
    }
}
