package com.example.aiju_chunghin_comp304_lab6;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;

public class MusicService extends Service {
    public MusicService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        //TODO: write code to play a music/sound
        return startId; // scratch return
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        //TODO: write code if needed
    }
}