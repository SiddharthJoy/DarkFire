package com.example.darkfire;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn,btnexit,prof;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button)findViewById(R.id.btn_stat);
        btnexit = (Button)findViewById(R.id.btn_exit);
        prof = (Button)findViewById(R.id.btn_prfl);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openstatus();
            }
        });

        btnexit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intnt = new Intent(MainActivity.this, install.class);
                startActivity(intnt);
            }
        });

        prof.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){ openprofile(); }
        });
    }

    private void openprofile() {
        Intent intnt = new Intent(this, profile.class);
        startActivity(intnt);
    }

    void openstatus()
    {
        Intent intnt = new Intent(this, status.class);
        startActivity(intnt);
    }
}