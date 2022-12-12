package com.example.aiju_chunghin_comp304_lab6;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MusicService extends Service {
    MediaPlayer mediaPlayer;

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
        //TODO: write code to play a music/sound
        mediaPlayer.start();
        Toast.makeText(getApplicationContext(), "Playing in the Background", Toast.LENGTH_SHORT).show();
        return startId; // scratch return
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        mediaPlayer.stop();
        mediaPlayer.release();
    }

    @Override
    public void onLowMemory() {
    }
}