package com.example.abdohero.gestion;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

/**
 * Created by abdohero on 11/19/17.
 */

class CallSms extends AppCompatActivity implements View.OnClickListener{
    private EditText  message;
    private TextView num;
    private Button[] mesbuttons=new Button[12];
    private ImageView call ,sms , clear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_callsms);

        num=(TextView)findViewById(R.id.num);
        message=(EditText)findViewById(R.id.messageSMS);

        mesbuttons[0]=(Button)findViewById(R.id.b0);
        mesbuttons[1]=(Button)findViewById(R.id.b1);
        mesbuttons[2]=(Button)findViewById(R.id.b2);
        mesbuttons[3]=(Button)findViewById(R.id.b3);
        mesbuttons[4]=(Button)findViewById(R.id.b4);
        mesbuttons[5]=(Button)findViewById(R.id.b5);
        mesbuttons[6]=(Button)findViewById(R.id.b6);
        mesbuttons[7]=(Button)findViewById(R.id.b7);
        mesbuttons[8]=(Button)findViewById(R.id.b8);
        mesbuttons[9]=(Button)findViewById(R.id.b9);
        mesbuttons[10]=(Button)findViewById(R.id.bEtoile);
        mesbuttons[11]=(Button)findViewById(R.id.bDie);

        clear =(ImageView) findViewById(R.id.bclear);
        call = (ImageView) findViewById(R.id.call);
        sms = (ImageView) findViewById(R.id.sms);

        for(Button mesbutton : mesbuttons){
            mesbutton.setOnClickListener(this);
        }
        clear.setOnClickListener(this);
        call.setOnClickListener(this);
        sms.setOnClickListener(this);


        if(ContextCompat.checkSelfPermission(CallSms.this, Manifest.permission.SEND_SMS)!=
                PackageManager.PERMISSION_GRANTED){
            if(ActivityCompat.shouldShowRequestPermissionRationale(CallSms.this,
                    Manifest.permission.SEND_SMS)){
                ActivityCompat.requestPermissions(CallSms.this,new String[]{Manifest.permission.SEND_SMS},1);
            }else {
                ActivityCompat.requestPermissions(CallSms.this,new String[]{Manifest.permission.SEND_SMS},1);
            }
        }else {
            // do nothing
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case 1: {
                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    if(ContextCompat.checkSelfPermission(CallSms.this,
                            Manifest.permission.SEND_SMS)==PackageManager.PERMISSION_GRANTED){
                        Toast.makeText(this,"Permission granted ! ",Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(this,"No Permission granted ! ",Toast.LENGTH_SHORT).show();
                }
                return;
            }
        }
    }

    public void display(String text) {
        num.append(text);
    }
    private Boolean checkCellPermission() {
        String permission="android.permission.CALL_PHONE";
        int res=getApplicationContext().checkCallingOrSelfPermission(permission);
        return (res== PackageManager.PERMISSION_GRANTED);
    }
    public void clear(){
        num.setText("");
        message.setText("");
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.b0:
                display("0");
                break;
            case R.id.b1:
                display("1");
                break;
            case R.id.b2:
                display("2");
                break;
            case R.id.b3:
                display("3");
                break;
            case R.id.b4:
                display("4");
                break;
            case R.id.b5:
                display("5");
                break;
            case R.id.b6:
                display("6");
                break;
            case R.id.b7:
                display("7");
                break;
            case R.id.b8:
                display("8");
                break;
            case R.id.b9:
                display("9");
                break;
            case R.id.bDie:
                display("#");
                break;
            case R.id.bEtoile:
                display("*");
                break;
        }
        if(view.getId()==sms.getId()){
            String number=num.getText().toString();
            String sms=message.getText().toString();
            try {
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(number,null,sms,null,null);
                Toast.makeText(this, "Send !", Toast.LENGTH_LONG).show();

            }catch (Exception e){
                Toast.makeText(this, "Failed !", Toast.LENGTH_LONG).show();
            }
        }
        if(view.getId()==clear.getId()){clear();}
        if(view.getId()==call.getId()){
            if (num.getText().toString().isEmpty()) {
                Toast.makeText(this, "Message", Toast.LENGTH_LONG).show();
            } else
                if(checkCellPermission())
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + num.getText())));
        }


    }
}
