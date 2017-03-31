package com.example.nani.firebaseyyp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;

public class list extends AppCompatActivity {
DatabaseReference dReference;

ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        lv=(ListView)findViewById(R.id.list);
        registerForContextMenu(lv);
        dReference= FirebaseDatabase.getInstance().getReference();
        dReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Map<String,String> data= (Map<String, String>) dataSnapshot.getValue();

                Toast.makeText(getApplicationContext(),"name"+data.get("name"),Toast.LENGTH_LONG).show();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Select any action");
        menu.add(0,v.getId(),0,"DELETE");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getTitle()=="DELETE"){
            Toast.makeText(getApplicationContext(),"Deleted",Toast.LENGTH_LONG).show();
        }
        return true;
    }

}
