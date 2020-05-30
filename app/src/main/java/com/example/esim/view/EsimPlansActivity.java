package com.example.esim.view;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.esim.R;
import com.example.esim.databinding.ActivityMainScreenBinding;
import com.example.esim.viewmodel.EsimPlansViewModel;

public class EsimPlansActivity extends AppCompatActivity {

    EsimPlansViewModel viewModel = new EsimPlansViewModel();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainScreenBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main_screen);
        binding.setViewModel(viewModel);
        viewModel.onCreate();

    }

    @Override
    protected void onPause() {
        super.onPause();
        viewModel.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        viewModel.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        viewModel.onDestroy();
    }


}
