package com.example.darkfire;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Timer;
import java.util.TimerTask;

public class launcher extends AppCompatActivity {
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Timer timer = new Timer();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {

                firebaseAuth = FirebaseAuth.getInstance();
                FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
                Intent intent = new Intent(launcher.this, signin.class);
                Intent iii = new Intent(launcher.this, MainActivity.class);
                if(firebaseUser != null) startActivity(iii);
                else startActivity(intent);
                finish();
            }
        },2000);
    }
}