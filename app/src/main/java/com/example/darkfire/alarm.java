package com.example.darkfire;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class alarm extends AppCompatActivity {
    private static final int REQUEST_CALL = 1;
    public MediaPlayer firealarm;
    public TextView area;
    public TextView tmp;

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Timer timerr = new Timer();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);

        firealarm = MediaPlayer.create(this,R.raw.alarm);
        area = findViewById(R.id.textView);
        tmp = findViewById(R.id.textView2);
        String areaname =  getIntent().getStringExtra("area");
        String temperature = getIntent().getStringExtra("tmp");
        firealarm.start();
        area.setText(areaname);
        tmp.setText(temperature + " C");
        ObjectAnimator animator = ObjectAnimator.ofInt(tmp, "textColor", Color.RED, Color.WHITE);
        animator.setDuration(500);
        animator.setEvaluator(new ArgbEvaluator());
        animator.setRepeatMode(Animation.REVERSE);
        animator.setRepeatCount(Animation.INFINITE);
        animator.start();
        Button btn = findViewById(R.id.stopbtn);
        Button callbtn = findViewById(R.id.calling);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firealarm.stop();
            }
        });

        callbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(alarm.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(alarm.this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
                } else {
                    String dial = "tel:01521415213";
                    startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
                }
            }
        });


        timerr.schedule(new TimerTask() {
            @Override
            public void run() {
                finish();
            }
        },11000);



    }
}