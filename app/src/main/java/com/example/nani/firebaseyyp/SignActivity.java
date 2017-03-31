package com.example.nani.firebaseyyp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignActivity extends AppCompatActivity {
private Button buttonSignin;
    private EditText e1;
    private EditText p1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);
        buttonSignin = (Button)findViewById(R.id.buttonSignin);
        e1=(EditText)findViewById(R.id.editTexte1);
        p1=(EditText)findViewById(R.id.editTextp1);


    }

    public void list(View v)
    {
        Intent l = new Intent(getApplicationContext(),list.class);
        startActivity(l);

    }

}
