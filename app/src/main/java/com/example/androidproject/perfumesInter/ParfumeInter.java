package com.example.androidproject.perfumesInter;

import com.example.androidproject.models.YelpPurabella;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ParfumeInter {
    @GET("businesses/search")
    Call<YelpPurabella> getParfumes(
            @Query("location") String location,
            @Query("term") String term
    );
}
