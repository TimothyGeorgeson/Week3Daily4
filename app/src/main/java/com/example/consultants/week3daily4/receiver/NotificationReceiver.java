package com.example.consultants.week3daily4.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.example.consultants.week3daily4.service.MusicService;

public class NotificationReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent returnIntent = new Intent(context, MusicService.class);
        switch (intent.getAction())
        {
            case MusicService.NOTIFY_PLAY:
                returnIntent.setAction(MusicService.NOTIFY_PLAY);
                context.startService(returnIntent);
                break;
            case MusicService.NOTIFY_PAUSE:
                returnIntent.setAction(MusicService.NOTIFY_PAUSE);
                context.startService(returnIntent);
                break;
            case MusicService.NOTIFY_STOP:
                returnIntent.setAction(MusicService.NOTIFY_STOP);
                context.startService(returnIntent);
                break;
        }

    }
}
