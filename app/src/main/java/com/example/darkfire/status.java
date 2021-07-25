package com.example.darkfire;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class status extends AppCompatActivity {
    private ListView lst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);

        Timer timer = new Timer();
        lst = findViewById(R.id.list);


        ArrayList<String> arrlst = new ArrayList<>();
        ArrayAdapter adapter = new ArrayAdapter<String>(this,R.layout.list_item,arrlst);
        lst.setAdapter(adapter);

        FirebaseAuth auth;
        auth = FirebaseAuth.getInstance();

        String id = (auth.getCurrentUser().getUid()).toString().trim();

        auth = FirebaseAuth.getInstance();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("Temparature").child(id);
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                arrlst.clear();
                for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                    arrlst.add(snapshot.getValue().toString());
//                    String str = String.valueOf(snapshot.getValue().toString());
                    String s = String.valueOf(snapshot.getValue().toString());

                    String name = String.valueOf(s.replaceAll("[\\d.]+|\\.(?!\\d)", "")).trim();
                    float f = Float.valueOf(s.replaceAll("[^\\d.]+|\\.(?!\\d)", ""));

                    if(f > 30.00) {
                        timer.schedule(new TimerTask() {
                            @Override
                            public void run() {
                                Intent intent = new Intent(status.this, alarm.class);
                                intent.putExtra("area",name);
                                intent.putExtra("tmp",Float.toString(f));
                                startActivity(intent);
                            }
                        },11000);
                    }
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}