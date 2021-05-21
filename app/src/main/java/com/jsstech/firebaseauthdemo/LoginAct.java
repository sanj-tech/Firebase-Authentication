package com.jsstech.firebaseauthdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginAct extends AppCompatActivity {

    EditText edt_loginEmail,edt_loginPass;
    FirebaseAuth firebaseAuth;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edt_loginEmail=findViewById(R.id.etLogin_email);
        edt_loginPass=findViewById(R.id.etLogin_pass);


        firebaseAuth=FirebaseAuth.getInstance();

    }

    public void login(View view) {
        String EmailLogin=edt_loginEmail.getText().toString();
        String EmailLoginPass=edt_loginPass.getText().toString();


        firebaseAuth.signInWithEmailAndPassword(EmailLogin,EmailLoginPass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(LoginAct.this,"Login Sucessfull" +EmailLogin,Toast.LENGTH_SHORT).show();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(LoginAct.this,"Unsucessful login" +e.getMessage(),Toast.LENGTH_SHORT).show();

            }
        });

    }

    public void callMain(View view) {
        Intent intent=new Intent(LoginAct.this,MainActivity.class);
        startActivity(intent);
    }
}