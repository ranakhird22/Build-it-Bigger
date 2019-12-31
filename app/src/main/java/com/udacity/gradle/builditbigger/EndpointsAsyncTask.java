package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.example.androidlib.MainJoke;
import android.os.AsyncTask;
import android.widget.Toast;

import androidx.core.util.Pair;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;


public class EndpointsAsyncTask extends AsyncTask<com.udacity.gradle.builditbigger.MainActivityFragment, Void, String> {
    private static MyApi myApiService = null;
    private Context context;
    private com.udacity.gradle.builditbigger.MainActivityFragment mainActivityFragment;

    @Override
    protected String doInBackground(com.udacity.gradle.builditbigger.MainActivityFragment... params) {
        mainActivityFragment = params[0];
        context = mainActivityFragment.getActivity();

        if(myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder( AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver

            myApiService = builder.build();
        }



        try {

          return myApiService.getJoke().execute().getData();

        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        mainActivityFragment.loadedJoke = result;
        mainActivityFragment.launchDisplayJokeActivity();


    }
}