package com.elhady.mvvm_design_pattern;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiRepo {
    public ApiEndpoints endpoints;

    public ApiRepo() {
        endpoints = ApiService.getService();
    }


    public LiveData<ApiResponse> getPosts() {
        final MutableLiveData<ApiResponse> apiResponse = new MutableLiveData<>();
        Call<List<Post>> call = endpoints.getDataFromApi();
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(@NonNull Call<List<Post>> call, @NonNull Response<List<Post>> response) {
                if (response.isSuccessful()) {
                    apiResponse.postValue(new ApiResponse(response.body()));
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Post>> call, @NonNull Throwable t) {
                apiResponse.postValue(new ApiResponse(t));
            }
        });

        return apiResponse;
    }
}
