package com.example.androidproject.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import com.example.androidproject.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PhotoActivity extends AppCompatActivity {
    @BindView(R.id.getGrid) TextView mTextView;
    @BindView(R.id.shop) Button mFill;

    GridView gridView;
   private int [] picture = { R.drawable.image4,
                              R.drawable.image8,
                              R.drawable.image7,
                              R.drawable.image3,
                              R.drawable.iiiii,
                              R.drawable.image5,
                              R.drawable.image2,
                              R.drawable.back,
                              R.drawable.pic3,
                              R.drawable.pic4

   };
   private  String []  prices =new String[] {
           "Narciso rodriguez: $67.2", "Shay & Blue:$ 23.4", "Pure poison dior:$ 73.6", "Bal d'afrique:$ 65.4", "Jimmy choo:$ 560.00", "Boss :$ 562.76"
   };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);
        ButterKnife.bind(this);

        gridView = (GridView) findViewById(R.id.myGrid);
        gridView.setAdapter(new ParfumAdapter(this, picture));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

        mFill.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent fill = new Intent(PhotoActivity.this, AppActivity.class);
                startActivity(fill);
            }
        });

    }
}
