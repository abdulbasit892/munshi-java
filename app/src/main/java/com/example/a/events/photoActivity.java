package com.example.a.events;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class photoActivity extends AppCompatActivity {


    GridView Grid;
    GRIDAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photos);

        final Integer[] image = new Integer[]{R.drawable.album1, R.drawable.album2, R.drawable.album3,
                R.drawable.album4, R.drawable.album5, R.drawable.album6,
                R.drawable.album7, R.drawable.album8};

        Grid = (GridView)findViewById(R.id.MyGrid);
        adapter = new GRIDAdapter(getApplicationContext(), R.layout.grid_item, image);

        Grid.setAdapter(adapter);

    }


    public class GRIDAdapter extends ArrayAdapter {
        private Integer[] Image;
        private int resource;
        private LayoutInflater inflater;

        public GRIDAdapter(Context context, int resource, Integer[] image) {
            super(context, resource, image);
            Image = image;
            this.resource = resource;
            inflater = (LayoutInflater)photoActivity.this.getSystemService(LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            ViewHolder Holder = null;

            if (convertView == null) {
                Holder = new ViewHolder();
                convertView = inflater.inflate(resource, null);
                Holder.IMAGE = (ImageView) convertView.findViewById(R.id.imageID);
                convertView.setTag(Holder);
            } else {
                Holder = (ViewHolder)convertView.getTag();
            }
            Holder.IMAGE.setImageResource(Image[position]);
            Holder.IMAGE.setScaleType(ImageView.ScaleType.CENTER_CROP);

            return convertView;
        }

        class ViewHolder {
            private ImageView IMAGE;
        }
    }

}
