package com.elhady.mvvm_design_pattern;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiEndpoints {

    @GET("/posts")
    Call<List<Post>> getDataFromApi();
}
