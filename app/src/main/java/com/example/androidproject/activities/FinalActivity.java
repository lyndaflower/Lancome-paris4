package com.example.androidproject.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.androidproject.adapters.listAdapter;
import com.example.androidproject.models.Business;
import com.example.androidproject.perfumesInter.ParfumeInter;
import com.example.androidproject.perfumesInter.PerfumeRetro;
import com.example.androidproject.R;
import com.example.androidproject.models.YelpPurabella;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FinalActivity extends AppCompatActivity {
    
    @BindView(R.id.recyclerView) RecyclerView mRecycle;
    @BindView(R.id.progressBar) ProgressBar mProgressText;
    @BindView(R.id.errorView) TextView mErrorView;

    private listAdapter mAdapter;
    private List<Business> mSpray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        ButterKnife.bind(this);


        Intent choice = getIntent();
        String location = choice.getStringExtra("location");
        getParfumes(location);
        

        ParfumeInter client = PerfumeRetro.getClient();

        Call<YelpPurabella> call = client.getParfumes(location, "perfumes");
        call.enqueue(new Callback<YelpPurabella>() {
            @Override
            public void onResponse(Call<YelpPurabella> call, Response<YelpPurabella> response) {

                hideProgressBar();

                if (response.isSuccessful()) {
                    mSpray = response.body().getBusinesses();
                    mAdapter = new listAdapter(FinalActivity.this, mSpray);
                    mRecycle.setAdapter(mAdapter);
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(FinalActivity.this);
                    mRecycle.setLayoutManager(layoutManager);
                    mRecycle.setHasFixedSize(true);

                    showBodySpray();
                } else {
                    showUnsuccessfulMessage();
                }
            }



            @Override
            public void onFailure(Call<YelpPurabella> call, Throwable t) {
                hideProgressBar();
                showUnsuccessfulMessage();

            }
            private void showUnsuccessfulMessage(){
                mErrorView.setText("Something went wrong. Please try again later");
                mErrorView.setVisibility(View.VISIBLE);
            }
            private void showFailureMessage(){
                mErrorView.setText("Something went wrong. Please check your Internet connection and try again later");
                mErrorView.setVisibility(View.VISIBLE);
            }
            private void showBodySpray(){
                mRecycle.setVisibility(View.VISIBLE);
            }

            private void hideProgressBar(){
                mProgressText.setVisibility(View.GONE);
            }
        });
    }

    private void getParfumes(String location) {
    }

}
