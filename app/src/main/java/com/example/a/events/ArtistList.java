package com.example.a.events;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ArtistList extends ArrayAdapter<Artist> {

    private Activity context;
    private List<Artist> artistList;


    public ArtistList(Activity context , List<Artist> artistList){


        super(context , R.layout.list_layout , artistList);
        this.context = context;
        this.artistList = artistList;

    }




    @Override
    public View getView(int position,View convertView,ViewGroup parent) {


        LayoutInflater inflater = context.getLayoutInflater();

        View listviewitem   = inflater.inflate(R.layout.list_layout,null, true);
        TextView textViewname = (TextView) listviewitem .findViewById(R.id.name);
        TextView textViewpassword = (TextView) listviewitem .findViewById(R.id.password);

        Artist artist = artistList.get(position);
        textViewname.setText(artist.getArtistName());
        textViewpassword.setText(artist.getArtistGenre());

        return listviewitem ;



    }
}

