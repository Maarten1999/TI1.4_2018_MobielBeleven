package com.a5.mobielbeleven.Activities;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.a5.mobielbeleven.Attraction;
import com.a5.mobielbeleven.R;

import org.w3c.dom.Text;

public class AttractionsDetailed extends BaseToolbar {

    ImageView detailimage;
    TextView detailname;
    TextView detailexplanation;
    TextView detailtype;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        Attraction attraction = (Attraction) intent.getSerializableExtra("ATTRACTION_OBJECT");

        setContentView(R.layout.activity_attractions_detailed);
        displayToolbar();
        getSupportActionBar().setTitle(attraction.getName());
        super.onCreate(savedInstanceState);

        detailname = (TextView) findViewById(R.id.attraction_detail_txt_naam_id);
        detailname.setText(attraction.getName());

        detailimage = (ImageView) findViewById(R.id.attraction_detail_image_id);
        int resId = this.getResources().getIdentifier(
                attraction.getImage(),
                "drawable",
                this.getPackageName()
        );
        detailimage.setImageResource(resId);

        detailtype = (TextView)findViewById(R.id.attraction_detail_type_id);
        detailtype.setText(attraction.getType());

        detailexplanation = (TextView) findViewById(R.id.attraction_detail_explanation_id);
        detailexplanation.setText(attraction.getDescription_nl());
    }
}
