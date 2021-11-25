package com.example.api_call_architechturecomponent.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.api_call_architechturecomponent.model.HolidayModel;
import com.example.api_call_architechturecomponent.network.ApiService;
import com.example.api_call_architechturecomponent.network.RetrofitInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HolidayViewModel extends ViewModel {
    private MutableLiveData<List<HolidayModel>> holidayList;

    public HolidayViewModel() {
        holidayList = new MutableLiveData<>();
    }

    public MutableLiveData<List<HolidayModel>> getHolidayListObserver() {
        return holidayList;
    }

    public void makeApiCall() {
        ApiService apiService = RetrofitInstance.getRetrofit().create(ApiService.class);

        Call<List<HolidayModel>> call = apiService.getMovieList();

        call.enqueue(new Callback<List<HolidayModel>>() {
            @Override
            public void onResponse(Call<List<HolidayModel>> call, Response<List<HolidayModel>> response) {
                holidayList.postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<HolidayModel>> call, Throwable t) {
                holidayList.postValue(null);
            }
        });


    }

}
