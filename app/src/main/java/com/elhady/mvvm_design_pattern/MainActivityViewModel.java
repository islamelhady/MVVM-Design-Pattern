package com.elhady.mvvm_design_pattern;

import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

public class MainActivityViewModel extends ViewModel {
    private MediatorLiveData<ApiResponse> mApiResponse;
    private ApiRepo mApiRepo;

    public MainActivityViewModel() {
        mApiResponse = new MediatorLiveData<>();
        mApiRepo = new ApiRepo();
    }

    public LiveData<ApiResponse> getData() {
        mApiResponse.addSource(mApiRepo.getPosts(), new Observer<ApiResponse>() {
            @Override
            public void onChanged(@Nullable ApiResponse apiResponse)            {
                mApiResponse.setValue(apiResponse);
            }
        });
        return mApiResponse;
    }
}
