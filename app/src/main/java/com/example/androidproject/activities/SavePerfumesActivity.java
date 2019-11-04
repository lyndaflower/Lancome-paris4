package com.example.androidproject.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.androidproject.adapters.HolderAdapter;
import com.example.androidproject.models.Perfume;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;

public class SavePerfumesActivity extends AppCompatActivity {
    private DatabaseReference PerfumesReference;
    private FirebaseRecyclerAdapter<Perfume, HolderAdapter> mFirebaseAdapter;

    public SavePerfumesActivity(DatabaseReference perfumesReference) {
        PerfumesReference = perfumesReference;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
