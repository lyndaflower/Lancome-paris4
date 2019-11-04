package com.example.androidproject.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.androidproject.R;
import com.google.firebase.database.DatabaseReference;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AppActivity extends AppCompatActivity {
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;
    private DatabaseReference mSearchedLocationReference;

    @BindView(R.id.makeChoice) ImageButton mMakeChoice;
    @BindView(R.id.text3) EditText mText3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);

        ButterKnife.bind(this);

        mMakeChoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String location = mText3.getText().toString();

                Intent choice = new Intent(AppActivity.this, FinalActivity.class);
                choice.putExtra("location", location);
                startActivity(choice);
            }
        });

    }
    private void addToSharedPreferences(String location){
        mEditor.putString(Holder.PREFERENCES_LOCATION_KEY, location).apply();
    }
}