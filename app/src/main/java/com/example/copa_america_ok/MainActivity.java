package com.example.copa_america_ok;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.copa_america_ok.PrincipalActivity;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        final Button btn1= (Button) findViewById(R.id.button);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String us= ((EditText)findViewById(R.id.usuario)).getText().toString();
                String ct= ((EditText)findViewById(R.id.contraseña)).getText().toString();
                if(us.equals("admin") && ct.equals("1234"))
                {
                    Intent form = new Intent(MainActivity.this, PrincipalActivity.class);
                    startActivity(form);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Datos Incorrectos",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}