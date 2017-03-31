package com.example.nani.firebaseyyp;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class products extends AppCompatActivity {
EditText name;
    Button b;
    private ProgressDialog progressDialog;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);
        name=(EditText)findViewById(R.id.pro);
        b=(Button)findViewById(R.id.ok);
        progressDialog = new ProgressDialog(this);
        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReferenceFromUrl("https://fir-yamyah-project.firebaseio.com/products");
    }


    public void upload(View v)
    {

        DatabaseReference id = databaseReference .push();
        id.child("name").setValue(name.getText().toString());

        Toast.makeText(this, "ok", Toast.LENGTH_SHORT).show();
    }
}
