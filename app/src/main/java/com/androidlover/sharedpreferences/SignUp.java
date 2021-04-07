package com.androidlover.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignUp extends AppCompatActivity {

    EditText SUser,SPass,SCPass;
    Button SSign;

    private final String SHARED_PREF="our_shared_pref";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        SUser=(EditText)findViewById(R.id.SUsername);
        SPass=(EditText)findViewById(R.id.SPassword);
        SCPass=(EditText)findViewById(R.id.SCPassword);
        SSign=(Button)findViewById(R.id.SSignUp);


        SSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String suser=SUser.getText().toString();
                String spass=SPass.getText().toString();
                String scpass=SCPass.getText().toString();

                if(spass!=null && scpass!=null && spass.equalsIgnoreCase(scpass))
                {
                    SharedPreferences sharedPreferences=getSharedPreferences(SHARED_PREF, Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor=sharedPreferences.edit();
                    editor.putString("Username",suser);
                    editor.putString("Password",spass);
                    editor.commit();

                    SignUp.this.finish();
                }
            }
        });

    }
}