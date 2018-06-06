package com.a5.mobielbeleven.Adapters;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.a5.mobielbeleven.Activities.AttractionsOverview;
import com.a5.mobielbeleven.Activities.GalleryDetailedImage;
import com.a5.mobielbeleven.Attraction;
import com.a5.mobielbeleven.R;

import java.util.ArrayList;
import java.util.Locale;

public class AttractionAdapter extends ArrayAdapter<Attraction> {

    private ArrayList<Attraction> attractions = new ArrayList<>();
    public AttractionAdapter(AttractionsOverview context, ArrayList<Attraction> attractions) {
        super(context, 0, attractions);
        this.attractions.addAll(attractions);
    }

    public View getView (int position, View convertView, final ViewGroup parent){
        final Attraction attraction = getItem(position);
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

//        imagerow.setOnClickListener(new View.OnClickListener()
//        {
//            @Override
//            public void onClick(View view)
//            {
//                Intent image = new Intent(parent.getContext(), GalleryDetailedImage.class);
//                image.putExtra("PHOTO_OBJECT", attraction.getImage());
//                parent.getContext().startActivity(image);
//            }
//        });
        return convertView;
    }

    public void filter(String text){
        text = text.toLowerCase(Locale.getDefault());
        clear();
        if(text.length() == 0){
            addAll(attractions);
        }
        else {
            for (Attraction attraction : attractions) {
                if(attraction.getName().toLowerCase(Locale.getDefault()).contains(text))
                    add(attraction);
            }
        }
        notifyDataSetChanged();
    }

}
