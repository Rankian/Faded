package com.sanjie.faded.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.sanjie.faded.R;
import com.sanjie.faded.ui.sliding.SlidingMenuActivity;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by LangSanJie on 2016/9/21.
 */

public class LaunchActivity extends AppCompatActivity {

    private static final String TAG = "LaunchActivity";

    private Timer timer;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        initView();
    }

    private void initView() {

        TimerTask task = null;
        task = new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(LaunchActivity.this, SlidingMenuActivity.class);
                startActivity(intent);
                finish();
            }
        };
        timer = new Timer();
        timer.schedule(task, 2000);
    }
}
