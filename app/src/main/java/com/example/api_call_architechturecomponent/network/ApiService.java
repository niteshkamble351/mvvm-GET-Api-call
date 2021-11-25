package com.example.api_call_architechturecomponent.network;

import com.example.api_call_architechturecomponent.model.HolidayModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("publicholidays/2021/AT")
    Call<List<HolidayModel>> getMovieList();

}
