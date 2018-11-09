package com.example.consultants.week3daily4.UI.main;

import android.content.Context;
import android.content.Intent;

import com.example.consultants.week3daily4.service.MusicService;

public class MainPresenter implements MainContract.Presenter {
    MainContract.View view;
    Context context;

    public void setContext(Context context)
    {
        this.context = context;
    }

    @Override
    public void playMusic() {
        Intent intent = new Intent(context, MusicService.class);
        intent.setAction(MusicService.NOTIFY_PLAY);
        context.startService(intent);
    }

    @Override
    public void pauseMusic() {
        Intent intent = new Intent(context, MusicService.class);
        intent.setAction(MusicService.NOTIFY_PAUSE);
        context.startService(intent);
    }

    @Override
    public void stopMusic() {
        Intent intent = new Intent(context, MusicService.class);
        intent.setAction(MusicService.NOTIFY_STOP);
        context.startService(intent);
    }

    @Override
    public void attachView(MainContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }
}
