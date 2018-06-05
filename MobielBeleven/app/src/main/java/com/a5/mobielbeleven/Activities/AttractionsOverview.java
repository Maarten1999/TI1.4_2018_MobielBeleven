package com.a5.mobielbeleven.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.a5.mobielbeleven.Attraction;
import com.a5.mobielbeleven.AttractionFactory;
import com.a5.mobielbeleven.R;

public class AttractionsOverview extends AppCompatActivity {

    ListView attractionList;
    com.a5.mobielbeleven.Activities.AttractionAdapter attractionAdapter;
    private AttractionFactory af = AttractionFactory.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attractions_overview);

        TextView titleBar = (TextView) findViewById(R.id.toolbar);
        titleBar.setText(getApplicationContext().getString(R.string.attractions_button));

        attractionList = (ListView) findViewById(R.id.attraction_list_1_id);
        attractionAdapter = new com.a5.mobielbeleven.Activities.AttractionAdapter(this, af.getAttractions());
        attractionList.setAdapter(attractionAdapter);

        attractionList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Log.i("ATTRACTION_TAG", ""+position);

                Intent intent = new Intent(getApplicationContext(), com.a5.mobielbeleven.Activities.AttractionsDetailed.class);

                Attraction attraction = af.getAttractions().get(position);
                intent.putExtra("ATTRACTION_OBJECT", attraction);
                startActivity(intent);

            }
        });

    }
}
