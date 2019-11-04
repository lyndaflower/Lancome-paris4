package com.example.androidproject.activities;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Parcel;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.androidproject.R;
import com.example.androidproject.models.Business;
import com.example.androidproject.models.Category;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class Perfume_Fragment extends Fragment implements View.OnClickListener {

    @BindView(R.id.fragmentView) ImageView mImage;
    @BindView(R.id.perfumName) TextView mText;
    @BindView(R.id.ratingText) TextView mRatingText;
    @BindView(R.id.location) TextView mLocation;
    @BindView(R.id.phoneText) TextView mPhone;
    @BindView(R.id.addressText) TextView textadress;

    private Business mSpray;

    public Perfume_Fragment() {

    }

    public static Perfume_Fragment newInstance(Business perfume) {
        Perfume_Fragment bodySpray = new Perfume_Fragment();
        Bundle args = new Bundle();
        args.putParcelable("perfumes", Parcels.wrap(perfume));
        bodySpray.setArguments(args);
        return bodySpray;
    }

    @Override
    public void onCreate(Bundle savedInstance) {

        super.onCreate(savedInstance);
        mSpray = Parcels.unwrap(getArguments().getParcelable("perfumes"));
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_perfume_, container, false);
        ButterKnife.bind(this, view);

        Picasso.get().load(mSpray.getImageUrl()).into(mImage);

        List<String> more = new ArrayList<>();


        for (Category category : mSpray.getCategories()) {
            more.add(category.getTitle());
        }
        mText.setText(mSpray.getName());
        mLocation.setText(android.text.TextUtils.join(" , ", more));
        mPhone.setText(mSpray.getPhone());
        textadress.setText(mSpray.getLocation().toString());

        mPhone.setOnClickListener(this);
        textadress.setOnClickListener(this);


        return view;
    }

    @Override
    public void onClick(View v) {
        if (v == mPhone) {
            Intent phoneIntent = new Intent(Intent.ACTION_DIAL,
                    Uri.parse("tel:" + mSpray.getPhone()));
            startActivity(phoneIntent);
        }
        if (v == textadress) {
            Intent mapIntent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("geo:" + mSpray.getCoordinates().getLatitude()
                            + "," + mSpray.getCoordinates().getLongitude()
                            + "?q=(" + mSpray.getName() + ")"));
            startActivity(mapIntent);
        }
    }
}