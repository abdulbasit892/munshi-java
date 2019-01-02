package com.example.a.events;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp extends AppCompatActivity {

    EditText username ,password;
    Button btn ;
    DatabaseReference databaseusername ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        databaseusername = FirebaseDatabase.getInstance().getReference("artists");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        username = (EditText) findViewById(R.id.ed1);
        password = (EditText) findViewById(R.id.ed2);
        btn = (Button) findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                buttonCLicked();
            }
        });
    }
    public void buttonCLicked(){

        String name = username.getText().toString().trim();
        String number = password.getText().toString().trim();

        String  key =databaseusername.push().getKey();
        Artist artist = new Artist(key , name ,number);
        databaseusername.child(key).setValue(artist);

        Intent in = new Intent(this , HOMEPAGE.class);
        startActivity(in);

    }

}

