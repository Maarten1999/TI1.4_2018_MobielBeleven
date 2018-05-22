package com.a5.mobielbeleven.Adapters;

import android.content.Context;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.a5.mobielbeleven.R;

import java.util.ArrayList;

public class ImageAdapter extends BaseAdapter
{
    private Context context;
    private ArrayList<String> pictureIDs;

    public ImageAdapter(Context context, ArrayList<String> pictureIDs)
    {
        this.context = context;
        this.pictureIDs = pictureIDs;
    }

    @Override
    public int getCount()
    {
        return pictureIDs.size();
    }

    @Override
    public Object getItem(int i)
    {
        return null;
    }

    @Override
    public long getItemId(int i)
    {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        LayoutInflater inflater = (LayoutInflater) context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View gridView;

        if(view == null) {
            gridView = inflater.inflate(R.layout.gallery_item, null);

            ImageView imageView = (ImageView) gridView.findViewById(R.id.gallery_item_image_id);

            int resId = viewGroup.getResources().getIdentifier(
                    pictureIDs.get(i),
                    "drawable",
                    context.getPackageName()
            );
            imageView.setImageResource(resId);
        } else{
            gridView = view;
        }
        return gridView;
    }
}
