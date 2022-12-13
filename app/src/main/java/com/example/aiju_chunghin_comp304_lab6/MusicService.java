package com.example.aiju_chunghin_comp304_lab6;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.MediaStore;
import android.provider.Settings;
import android.widget.RadioButton;

import androidx.annotation.Nullable;

public class MusicService extends Service {
    private MediaPlayer player;
    private RadioButton radMusic1, radMusic2;
    public MusicService() {

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mediaPlayer = MediaPlayer.create(this, R.raw.sound1);
        mediaPlayer = MediaPlayer.create(this, R.raw.sound2);
        mediaPlayer.setLooping(true); // Set looping
        mediaPlayer.setVolume(100, 100);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        // Initialize player
        player = new MediaPlayer();

        // set music
        int musicId = intent.getIntExtra("musicId", 0);
        if (musicId == 1)
            player = MediaPlayer.create(this, R.raw.aoharu);
        else if (musicId == 2)
            player = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI);

        //play a music/sound if it's set
        try {
            player.setLooping(true);
            player.start();
//        Toast.makeText(this, "Service Started", Toast.LENGTH_LONG).show(); // DEBUG USE
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
        // Keep running until stop
        return START_STICKY;
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        player.stop();
//        Toast.makeText(this, "Service Destroyed", Toast.LENGTH_LONG).show(); // DEBUG USE
    }
}