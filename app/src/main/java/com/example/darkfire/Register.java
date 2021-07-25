package com.example.darkfire;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity implements View.OnClickListener{

    private EditText name;
    private EditText email;
    private EditText pswrd;
    private Button btn_reg;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mAuth = FirebaseAuth.getInstance();
        name = (EditText) findViewById(R.id.Name);
        email = (EditText) findViewById(R.id.Email);
        pswrd = (EditText) findViewById(R.id.Password);
        btn_reg = (Button) findViewById(R.id.register);

        btn_reg.setOnClickListener(Register.this);

    }

    @Override
    public void onClick(View v){
        switch(v.getId()){
            case R.id.register:
                registerUser();
                break;
        }
    }

    private void registerUser() {
        String em = email.getText().toString().trim();
        String nm = name.getText().toString().trim();
        String pass = pswrd.getText().toString().trim();

        if(nm.isEmpty()){
            name.setError("Name is required");
            name.requestFocus();
            return;
        }

        if(em.isEmpty()){
            email.setError("Email is required");
            email.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(em).matches()){
            email.setError("Please provide valid email.");
            email.requestFocus();
            return;
        }

        if(pass.isEmpty()){
            pswrd.setError("Password is required");
            pswrd.requestFocus();
            return;
        }

        mAuth.createUserWithEmailAndPassword(em,pass)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            User user = new User(nm,em,pass);
                            FirebaseDatabase.getInstance().getReference("Users")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if(task.isSuccessful()){
                                        Toast.makeText(Register.this,"Registered Successfully",Toast.LENGTH_LONG).show();
                                        Intent intent = new Intent(Register.this, signin.class);
                                        startActivity(intent);
                                    }
                                    else{
                                        Toast.makeText(Register.this,"Registration Failed,Try Again.",Toast.LENGTH_LONG).show();
                                    }
                                }
                            });
                        }
                        else{
                            Toast.makeText(Register.this,"Registration Failed,Try Again.",Toast.LENGTH_LONG).show();
                        }
                    }
                });


    }



}