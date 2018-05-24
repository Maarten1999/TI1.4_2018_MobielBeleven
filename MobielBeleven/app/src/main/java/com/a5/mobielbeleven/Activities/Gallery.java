package com.a5.mobielbeleven.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.a5.mobielbeleven.Adapters.ImageAdapter;
import com.a5.mobielbeleven.R;

import java.util.ArrayList;

public class Gallery extends AppCompatActivity
{

    ArrayList<String> picturesIDs;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        TextView titleBar = (TextView) findViewById(R.id.titlebar_txt_1_id);
        titleBar.setText(getApplicationContext().getString(R.string.gallery_button));

        picturesIDs = new ArrayList<>();
        initPictures();

        GridView grid = (GridView) findViewById(R.id.gallery_grid_1_id);
        grid.setAdapter(new ImageAdapter(this,picturesIDs));
        Log.i("","adapter gezet \n Finally");

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                Toast.makeText(Gallery.this,"" + i,
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initPictures()
    {
        picturesIDs.add("picture1");
        picturesIDs.add("picture2");
        picturesIDs.add("picture3");
        picturesIDs.add("picture4");
        picturesIDs.add("picture5");
        Log.i("","arralist gevuld \n Finally");
    }
}
