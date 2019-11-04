package com.example.androidproject.adapters;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;

import com.example.androidproject.activities.Perfume_Fragment;
import com.example.androidproject.models.Business;

import java.util.List;

public class AdapterPager extends FragmentPagerAdapter {

    private List<Business> mSpray;

//    public AdapterPager(FragmentManager fm,  List<Business> spray) {
//        super(fm );
//        mSpray = spray;
//    }

    public AdapterPager(FragmentManager supportFragmentManager, int fragmentPagerAdapter, List<Business> perfumes) {
        super(supportFragmentManager);
        mSpray = perfumes;
    }

    @Override
    public Fragment getItem(int position){
        return Perfume_Fragment.newInstance(mSpray.get(position));
    }
    @Override
    public int getCount(){
        return mSpray.size();
    }
    @Override
    public CharSequence getPageTitle(int position) {
        return mSpray.get(position).getName();
    }
}

