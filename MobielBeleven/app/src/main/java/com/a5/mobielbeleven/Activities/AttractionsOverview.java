package com.a5.mobielbeleven.Activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import com.a5.mobielbeleven.Adapters.AttractionAdapter;
import com.a5.mobielbeleven.Attraction;
import com.a5.mobielbeleven.AttractionFactory;
import com.a5.mobielbeleven.R;

public class AttractionsOverview extends BaseToolbar implements SearchView.OnQueryTextListener
{

    ListView attractionList;
    AttractionAdapter attractionAdapter;
    SearchView searchView;
    private AttractionFactory af = AttractionFactory.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_attractions_overview);
        displayToolbar();
        getSupportActionBar().setTitle(R.string.attractions_button);
        super.onCreate(savedInstanceState);

        attractionList = (ListView) findViewById(R.id.attraction_list_1_id);
        attractionAdapter = new AttractionAdapter(this, af.getAttractions());
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

        searchView = findViewById(R.id.attraction_search_1_id);
        searchView.setOnQueryTextListener(this);


    }

    @Override
    public boolean onQueryTextSubmit(String s)
    {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s)
    {
        attractionAdapter.filter(s);
        return false;
    }
}
