package com.a5.mobielbeleven.Activities;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.a5.mobielbeleven.Attraction;
import com.a5.mobielbeleven.R;

import java.util.ArrayList;

public class AttractionAdapter extends ArrayAdapter<Attraction> {
    public AttractionAdapter(AttractionsOverview context, ArrayList<Attraction> attractions) {
        super(context, 0, attractions);
    }

    public View getView (int position, View convertView, ViewGroup parent){
        Attraction attraction = getItem(position);
        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.attraction_row, parent, false
            );
        }
        TextView name = (TextView) convertView.findViewById(R.id.detail_row_txt_id);
        name.setText(attraction.getName());


        ImageView imagerow = (ImageView) convertView.findViewById(R.id.detail_row_image_id);
        int resId = parent.getResources().getIdentifier(
                attraction.getImage(), "drawable", getContext().getPackageName()
        );
        imagerow.setImageResource(resId);
        return convertView;
    }
}
