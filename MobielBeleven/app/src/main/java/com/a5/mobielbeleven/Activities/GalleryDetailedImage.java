package com.a5.mobielbeleven.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.a5.mobielbeleven.R;

public class GalleryDetailedImage extends BaseToolbar
{


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        setContentView(R.layout.activity_gallery_detailed_image);
        displayToolbar();
        getSupportActionBar().setTitle(R.string.photo_titlebar_text);
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        String pictureID = (String) intent.getSerializableExtra("PHOTO_OBJECT");

        ImageView image = (ImageView) findViewById(R.id.photo_detailed_image_id);

        int resID = this.getResources().getIdentifier(
                pictureID, "drawable", this.getPackageName()
        );

        image.setImageResource(resID);
    }
}
