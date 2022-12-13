package com.example.aiju_chunghin_comp304_lab6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MusicActivity extends AppCompatActivity {
    private TextView musicDesc, copyright;
    private int musicId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        // Initialize textviews
        musicDesc = findViewById(R.id.musicDesc);
        copyright = findViewById(R.id.copyright);

        // Initialize musicId variable
        musicId = 0;

    }
    /** Activity methods for Music Service **/
    public void startService(View view){
        //start service
        Intent intent = new Intent(getBaseContext(), MusicService.class);
        intent.putExtra("musicId", musicId);
        startService(intent);
    }

    public void stopService(View view) {
        //stop service
        stopService(new Intent(getBaseContext(), MusicService.class));
    }

    // handle radio buttons
    public void onRadioButtonClicked(View view){
        boolean checked = ((RadioButton) view).isChecked();
        // check which radio button have checked
        switch(view.getId()){
            case R.id.radMusic1:
                if (checked) {
                    // put music desc and set music
                    musicDesc.setText(R.string.music1_desc);
                    copyright.setVisibility(View.VISIBLE);
                    musicId = 1;
                }
                break;

            case R.id.radMusic2:
                if (checked) {
                    // put music desc and set music
                    musicDesc.setText(R.string.music2_desc);
                    copyright.setVisibility(View.INVISIBLE);
                    musicId = 2;
                }
                break;
            default:
                musicId = 0;
                break;
        }
    }
}

//DONE: Develop music service code
//DONE: Configure manifest file (innovative point: apply any features). Run the application to play the music
//TODO: Test the application with different types of music/sound files(2-3) sent from the service to the application's activity

/* Innovation
    * Added mp3 audio to Raw Resources and played with MediaPlayer
*/