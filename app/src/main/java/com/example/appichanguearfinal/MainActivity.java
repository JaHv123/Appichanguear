package com.example.appichanguearfinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    EditText mEdtName, mEdtEmail, mEdtPassword;
    private Button mButtonRegister, mBtnSendToLogin;

    //VARIABLES DE LOS DATOS QUE VAMOS A REGISTRA
    String name = "";
    String email = "";
    String password = "";

    FirebaseAuth mAuth;
    DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEdtName = findViewById(R.id.edtName);
        mEdtEmail = findViewById(R.id.edtEmail);
        mEdtPassword = findViewById(R.id.edtPassword);
        mButtonRegister = findViewById(R.id.btnRegistrar);
        mBtnSendToLogin = findViewById(R.id.btnSendToLogin);

        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();

        mButtonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = mEdtName.getText().toString();
                email = mEdtEmail.getText().toString();
                password = mEdtPassword.getText().toString();

                if(!name.isEmpty() && !email.isEmpty() && !password.isEmpty()){

                    if (password.length() >= 6){
                        registerUser();
                    }else {
                        Toast.makeText(MainActivity.this,"El password debe tener al menos 6 caracteres", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(MainActivity.this,"Debe completar los campos", Toast.LENGTH_SHORT).show();
                }
            }
        });

        mBtnSendToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
                //finish();
            }
        });

    }

    private void registerUser(){
        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Map<String,Object> map = new HashMap<>();
                    map.put("name", name);
                    map.put("email", email);
                    map.put("password", password);


                    String id = mAuth.getCurrentUser().getUid();
                    mDatabase.child("Users").child(id).setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task2) {

                            if (task2.isSuccessful()){
                                startActivity(new Intent(MainActivity.this, ProfileActivity.class));
                                finish();
                            }
                        }
                    });
                }else {
                    Toast.makeText(MainActivity.this,"No se pudo regisrar este usuario", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        if (mAuth.getCurrentUser() != null){
            startActivity(new Intent(MainActivity.this, ProfileActivity.class));
            finish();
        }

    }
}
