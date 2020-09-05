package com.elhady.mvvm_design_pattern;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiService {
    private static ApiEndpoints endpoints;

    public static ApiEndpoints getService() {
        if (endpoints == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("https://jsonplaceholder.typicode.com")
                    .build();

            endpoints = retrofit.create(ApiEndpoints.class);
        }

        return endpoints;

    }
}
