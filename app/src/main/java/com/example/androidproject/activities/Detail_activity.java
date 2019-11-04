package com.example.androidproject.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.androidproject.R;
import com.example.androidproject.adapters.AdapterPager;
import com.example.androidproject.models.Business;

import org.parceler.Parcels;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Detail_activity extends AppCompatActivity {
    @BindView(R.id.viewPager) ViewPager mPager;

    private AdapterPager viewAdapter;

    List<Business> mSpray;
    private int  FragmentPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_activity);
        ButterKnife.bind(this);

        mSpray = Parcels.unwrap(getIntent().getParcelableExtra("perfumes"));
        int  startingPosition = getIntent().getIntExtra("position",0);

        viewAdapter =new AdapterPager(getSupportFragmentManager(), FragmentPagerAdapter,mSpray);
        mPager.setAdapter(viewAdapter);
        mPager.setCurrentItem(startingPosition);
    }
}
