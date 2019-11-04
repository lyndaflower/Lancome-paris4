package com.example.androidproject.activities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.androidproject.R;

public class ParfumAdapter extends BaseAdapter {
    private Context mParfumes;
    private int[] mPictures;

    public ParfumAdapter(Context mParfumes, int[] mPictures) {
        this.mParfumes = mParfumes;
        this.mPictures = mPictures;
    }


    public int getCount() {
        return mPictures.length;
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mParfumes
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View gridView = convertView;
        if (convertView == null) {

            gridView = inflater.inflate(R.layout.grid_items, null);

        }
        ImageView pictureView = (ImageView)gridView.findViewById(R.id.grid_item_image);
        pictureView.setImageResource(mPictures[position]);
        return pictureView;

    }
}

