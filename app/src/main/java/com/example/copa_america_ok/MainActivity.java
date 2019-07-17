package com.example.copa_america_ok;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.copa_america_ok.PrincipalActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private EditText usuario;
    private EditText contra;
    private Button registrar;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        final Button btn1= (Button) findViewById(R.id.button);

        firebaseAuth = FirebaseAuth.getInstance();
        usuario = (EditText) findViewById(R.id.usuario);
        contra = (EditText) findViewById(R.id.contraseña);
        progressDialog = new ProgressDialog(this);

        /*String us= ((EditText)findViewById(R.id.usuario)).getText().toString();
        String ct= ((EditText)findViewById(R.id.contraseña)).getText().toString();
        if(us.equals("admin") && ct.equals("1234"))
        {
            Intent form = new Intent(MainActivity.this, PrincipalActivity.class);
            startActivity(form);
        }
        else
        {
            Toast.makeText(getApplicationContext(),"Datos Incorrectos",Toast.LENGTH_LONG).show();
        }*/


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registro();
            }
        });

    }


    private void registro()
    {
        String email = usuario.getText().toString().trim();
        String pass = contra.getText().toString().trim();


        if (TextUtils.isEmpty(email))
        {
            Toast.makeText(this,"debe ingresar un email",Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(pass))
        {
            Toast.makeText(this,"debe ingresar un password",Toast.LENGTH_SHORT).show();
            return;
        }

        progressDialog.setMessage("Registrando en linea");
        progressDialog.show();


        firebaseAuth.createUserWithEmailAndPassword(email,pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(MainActivity.this,"Se a registrado el email",Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(MainActivity.this,"no se a podido registrar  el usuario",Toast.LENGTH_SHORT).show();
                        }
                        progressDialog.dismiss();
                    }
                });


    }



}