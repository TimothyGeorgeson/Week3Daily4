package com.example.consultants.week3daily4.UI.main;

import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.consultants.week3daily4.R;
import com.example.consultants.week3daily4.receiver.NotificationReceiver;
import com.example.consultants.week3daily4.service.MusicService;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    private MainPresenter presenter;
    private NotificationReceiver notificationReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainPresenter();
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.attachView(this);
        notificationReceiver = new NotificationReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(MusicService.NOTIFY_PLAY);
        intentFilter.addAction(MusicService.NOTIFY_PAUSE);
        intentFilter.addAction(MusicService.NOTIFY_STOP);
        registerReceiver(notificationReceiver, intentFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.detachView();
        unregisterReceiver(notificationReceiver);
    }

    @Override
    public void showError(String error) {
        Toast.makeText(this,error,Toast.LENGTH_SHORT).show();
    }

    public void clickMusic(View view) {
        presenter.setContext(getApplicationContext());
        switch (view.getId())
        {
            case R.id.btnStart:
                presenter.playMusic();
                break;
            case R.id.btnPause:
                presenter.pauseMusic();
                break;
            case R.id.btnStop:
                presenter.stopMusic();
                break;
        }
    }
}
