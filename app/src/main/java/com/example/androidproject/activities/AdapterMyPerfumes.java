package com.example.androidproject.activities;

import android.content.Context;
import android.widget.ArrayAdapter;

public class AdapterMyPerfumes extends ArrayAdapter {
    private Context mContext;
    private String[] mSpray;
    private String[] mCategories;
    public AdapterMyPerfumes(Context context, int resource, String[] spray, String[] myCategories) {
        super(context,resource);
        this.mSpray = spray;
        this.mCategories = myCategories;


    }
    @Override
    public Object getItem(int position) {
        String bodySprays = mSpray[position];
        String category = mCategories[position];
        return String.format("%S \nfind the key : %S",bodySprays,category);
    }
    @Override
    public int getCount(){
        return mSpray.length;
    }
}
