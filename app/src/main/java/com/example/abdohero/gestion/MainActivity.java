package com.example.abdohero.gestion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button gestion, callsms, camera;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gestion = (Button) findViewById(R.id.gestion);
        callsms = (Button) findViewById(R.id.callsms);
        camera = (Button) findViewById(R.id.camera);


        gestion.setOnClickListener(this);
        callsms.setOnClickListener(this);
        camera.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.gestion:
                Intent Gestion =new Intent(MainActivity.this,GestionContact.class);
                startActivity(Gestion);
                break;
            case R.id.callsms:
                Intent callsms=new Intent(MainActivity.this,CallSms.class);
                startActivity(callsms);
                break;
            case R.id.camera:
                Intent Camera=new Intent(MainActivity.this,CameraGestion.class);
                startActivity(Camera);
                break;

        }
    }
}