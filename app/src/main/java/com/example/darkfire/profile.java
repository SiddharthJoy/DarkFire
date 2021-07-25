package com.example.darkfire;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class profile extends AppCompatActivity {
    private ListView lst;
    private FirebaseAuth Aauth;
    private Button out;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        lst = findViewById(R.id.list);


        ArrayList<String> arrlst = new ArrayList<>();
        ArrayAdapter adapter = new ArrayAdapter<String>(this,R.layout.list_item,arrlst);
        lst.setAdapter(adapter);


        Aauth = FirebaseAuth.getInstance();

        String id = (Aauth.getCurrentUser().getUid()).toString().trim();

        Aauth = FirebaseAuth.getInstance();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("Users").child(id);
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                arrlst.clear();
                int cnt = 0;
                for(DataSnapshot snapshot : dataSnapshot.getChildren()){

                    cnt++;
                    String s = String.valueOf("");

                    if(cnt == 1) s = "Email : ";
                    else if(cnt == 2) s = "Name : ";
                    else s = "User Id:\n\n";

                    if(cnt < 3) s += String.valueOf(snapshot.getValue().toString().trim());
                    else s += id + "\n\n(It must be provided to the arduino code of NodeMCU)";

                    arrlst.add(s);
                }
                adapter.notifyDataSetChanged();
            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }


        });

        out = findViewById(R.id.btn_log);

        out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Aauth.signOut();
                Intent intnt = new Intent(profile.this, signin.class);
                startActivity(intnt);
            }
        });

        
    }
}