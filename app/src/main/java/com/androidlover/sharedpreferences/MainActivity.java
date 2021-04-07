package com.androidlover.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText LUser,LPass;
    Button LLog,LSign;

    private final String SHARED_PREF="our_shared_pref";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LUser=(EditText)findViewById(R.id.LUsername);
        LPass=(EditText)findViewById(R.id.LPassword);
        LLog=(Button)findViewById(R.id.LLogin);
        LSign=(Button)findViewById(R.id.LSignUp);

        LSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,SignUp.class);
                startActivity(intent);
            }
        });

        LLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String luser=LUser.getText().toString();
                String lpass=LPass.getText().toString();

                SharedPreferences sharedPreferences=getSharedPreferences(SHARED_PREF, Context.MODE_PRIVATE);
                String finaluser = sharedPreferences.getString("Username",null);
                String finalpass = sharedPreferences.getString("Password",null);

                if(luser!=null && finaluser!=null && luser.equalsIgnoreCase(finaluser))
                {
                    if(lpass!=null && finalpass!=null && lpass.equalsIgnoreCase(finalpass))
                    {
                        Toast.makeText(MainActivity.this,"Login Successsful",Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this,"Login Failed",Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    Toast.makeText(MainActivity.this,"Login Failed",Toast.LENGTH_SHORT).show();
                }

            }
        });


    }
}