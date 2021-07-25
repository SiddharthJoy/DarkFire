package com.example.darkfire;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class signin extends AppCompatActivity implements View.OnClickListener{

    private EditText EMAIL;
    private EditText PASSWORD;
    private Button LOGIN;

    private FirebaseAuth Auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        TextView reg = (TextView)findViewById(R.id.rgstr);
        EMAIL = (EditText)findViewById(R.id.mailadd);
        PASSWORD = (EditText)findViewById(R.id.Pass);
        LOGIN = (Button)findViewById(R.id.signin);
        LOGIN.setOnClickListener(this);
        reg.setOnClickListener(this);

        Auth = FirebaseAuth.getInstance();

    }



    @Override
    public void onClick(View v){
        switch (v.getId()) {
            case R.id.signin:
                userlogin();
                break;
            case R.id.rgstr:
                openreg();
                break;
        }
    }

    void openreg()
    {
        Intent intnt = new Intent(this, Register.class);
        startActivity(intnt);
    }

    private void userlogin() {
        String em = EMAIL.getText().toString().trim();
        String pswrd = PASSWORD.getText().toString().trim();

        if(em.isEmpty()){
            EMAIL.setError("Email is required");
            EMAIL.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(em).matches()){
            EMAIL.setError("Please provide valid email.");
            EMAIL.requestFocus();
            return;
        }

        if(pswrd.isEmpty()){
            PASSWORD.setError("Password is required");
            PASSWORD.requestFocus();
            return;
        }



        Auth.signInWithEmailAndPassword(em,pswrd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    startActivity(new Intent (signin.this,MainActivity.class));
                    finish();
                }
                else{
                    Toast.makeText(signin.this,"Login Failed,Try Again.",Toast.LENGTH_LONG).show();
                }
            }
        });


    }
}