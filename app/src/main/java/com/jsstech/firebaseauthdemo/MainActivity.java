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

public class MainActivity extends AppCompatActivity {
    EditText edtEmail,edtPass;
    FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtEmail=findViewById(R.id.et_email);
        edtPass=findViewById(R.id.et_pass);
        firebaseAuth=FirebaseAuth.getInstance();
    }

    public void openLoginPage(View view) {
        Intent intent=new Intent(MainActivity.this,LoginAct.class);
        startActivity(intent);

    }

    public void resisterHere(View view) {

        String EMAIL=edtEmail.getText().toString();
        String PASS=edtPass.getText().toString();

        firebaseAuth.createUserWithEmailAndPassword(EMAIL,PASS).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(MainActivity.this,"User created sucesssFully",Toast.LENGTH_SHORT).show();
                }

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(MainActivity.this," Fail to create user" +e.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });





    }
}