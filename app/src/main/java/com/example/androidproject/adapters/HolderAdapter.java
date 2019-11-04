package com.example.androidproject.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidproject.R;
import com.example.androidproject.activities.Detail_activity;
import com.example.androidproject.models.Business;
import com.example.androidproject.models.Perfume;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HolderAdapter extends RecyclerView.Adapter<HolderAdapter.PerfumeViewHolder>{
    private List<Perfume> mSpray;
    private Context mContext;

    public HolderAdapter(Context context, List<Perfume> perfumes) {
        mContext = context;
        mSpray = perfumes;
    }

    @Override
    public HolderAdapter.PerfumeViewHolder onCreateViewHolder(ViewGroup parent , int ViewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_list_final_,parent, false);
        HolderAdapter.PerfumeViewHolder viewHolder = new HolderAdapter.PerfumeViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(HolderAdapter.PerfumeViewHolder holder, int position ) {
        holder.bindPerfume(mSpray.get(position));
    }

    @Override
    public int getItemCount() {
        return mSpray.size();
    }

    public class PerfumeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.imageView)
        ImageView mImageView;
        @BindView(R.id.perfumNameView)
        TextView mPerfumeView;
        @BindView(R.id.anotherView) TextView mView;
//     @BindView(R.id.ratingView) TextView mRating;

        private Context mContext;

        public PerfumeViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
            itemView.setOnClickListener(this);

        }
        public void bindPerfume(Perfume perfume) {
            mPerfumeView.setText(perfume.getName());
            mView.setText(perfume.getCategories().get(0));
            Picasso.get().load(perfume.getImageUrl()).into(mImageView);
        }

        @Override
        public void onClick(View v) {
            int itemPosition = getLayoutPosition();
            Intent intent = new Intent(mContext, Detail_activity.class);
            intent.putExtra("position", itemPosition);
            intent.putExtra("perfumes", Parcels.wrap(mSpray));
            mContext.startActivity(intent);
        }
    }
}
