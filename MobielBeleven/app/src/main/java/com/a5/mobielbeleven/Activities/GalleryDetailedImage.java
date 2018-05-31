package com.a5.mobielbeleven.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.a5.mobielbeleven.R;

public class GalleryDetailedImage extends AppCompatActivity
{


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery_detailed_image);

        TextView titleBar = (TextView) findViewById(R.id.titlebar_txt_1_id);
        titleBar.setText(getApplicationContext().getString(R.string.photo_titlebar_text));

        Intent intent = getIntent();
        String pictureID = (String) intent.getSerializableExtra("PHOTO_OBJECT");

        ImageView image = (ImageView) findViewById(R.id.photo_detailed_image_id);

        int resID = this.getResources().getIdentifier(
                pictureID, "drawable", this.getPackageName()
        );

        image.setImageResource(resID);
    }
}
