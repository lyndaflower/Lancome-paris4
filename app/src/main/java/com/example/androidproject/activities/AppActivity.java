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
import com.google.firebase.database.FirebaseDatabase;

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

        mSearchedLocationReference = FirebaseDatabase
                .getInstance()
                .getReference()
                .child(Holder.FIREBASE_CHILD_SEARCHED_LOCATION);


        mMakeChoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v == mMakeChoice) {
                    String location = mText3.getText().toString();
                    saveToFirebase(location);

                    Intent choice = new Intent(AppActivity.this, FinalActivity.class);
                    choice.putExtra("location", location);
                    startActivity(choice);
                }
            }
        });

    }

    private void saveToFirebase(String location) {
        mSearchedLocationReference.setValue(location);
    }
}