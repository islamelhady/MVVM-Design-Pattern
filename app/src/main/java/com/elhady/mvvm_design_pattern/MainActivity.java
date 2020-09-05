package com.elhady.mvvm_design_pattern;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainActivityViewModel viewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);

        viewModel.getData().observe(this, new Observer<ApiResponse>() {
            @Override
            public void onChanged(ApiResponse apiResponse) {
                if (apiResponse == null) {
                    // handle error here
                    return;
                }
                if (apiResponse.getError() == null) {
                    // call is successful
                    Log.i("TAG", "Data response is " + apiResponse.getPosts());
                } else {
                    // call failed.
                    Throwable e = apiResponse.getError();
                    Toast.makeText(MainActivity.this, "Error is " + e.getMessage(), Toast.LENGTH_SHORT).show();
//                    Log.e("TAG", "Error is " + e.getLocalizedMessage());

                }
            }
        });
    }
}