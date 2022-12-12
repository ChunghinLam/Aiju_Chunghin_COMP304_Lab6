package com.example.aiju_chunghin_comp304_lab6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MusicActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
    }

    /** Activity methods for Music Service **/
    public void startService(View view){
        //TODO: write code to start service
    }

    public void stopService(View view) {
        //TODO: write code to stop service
    }
}

//TODO: Develop music service code
//TODO: Configure manifest file (innovative point: apply any features). Run the application to play the music
//TODO: Test the application with different types of music/sound files(2-3) sent from the service to the application's activity