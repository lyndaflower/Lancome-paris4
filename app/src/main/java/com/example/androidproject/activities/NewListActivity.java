package com.example.androidproject.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidproject.R;
import com.example.androidproject.adapters.listAdapter;
import com.example.androidproject.models.Business;
import com.example.androidproject.models.Perfume;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewListActivity extends AppCompatActivity {
    private SharedPreferences sharedpref;
    private String mAdresses;

    private RecyclerView mRecycle;
    private ProgressBar mProgressText;
    private TextView mErrorView;

    private listAdapter mAdapter;
    private List<Perfume> mSpray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        mRecycle = (RecyclerView) findViewById(R.id.recyclerView);
        mProgressText = (ProgressBar) findViewById(R.id.progressBar);
        mErrorView = (TextView) findViewById(R.id.errorView);


        Intent choice = getIntent();
        String location = choice.getStringExtra("location");
        String type = choice.getStringExtra("type");

        sharedpref = PreferenceManager.getDefaultSharedPreferences(this);
        mAdresses = sharedpref.getString(Holder.PREFERENCES_LOCATION_KEY,null);

        if (mAdresses != null) {
            getPerfume(mAdresses);
        }
    }

    private void getPerfume(String location) {
    }
}
