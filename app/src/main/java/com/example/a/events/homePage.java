package com.example.a.events;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class homePage extends AppCompatActivity {

    DatabaseReference databaseusername ;
    ListView listViewArtists ;
    List<Artist> artistList;
    CardView cardView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        databaseusername = FirebaseDatabase.getInstance().getReference("artists");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        listViewArtists = (ListView) findViewById(R.id.listViewArtists);
        cardView = (CardView)findViewById(R.id.card);

        artistList = new ArrayList<>();


        }

    @Override
    protected void onStart() {

        super.onStart();

        databaseusername.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                artistList.clear();
                for(DataSnapshot artistSnapshot : dataSnapshot.getChildren()){
                    Artist artist = artistSnapshot.getValue(Artist.class);

                    artistList.add(artist);


                }
                ArtistList adapter  = new ArtistList(homePage.this , artistList);
                listViewArtists.setAdapter(adapter);



            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }

        });

        listViewArtists.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(homePage.this,EventPage.class);
                startActivity(intent);
            }
        });







    }






}
