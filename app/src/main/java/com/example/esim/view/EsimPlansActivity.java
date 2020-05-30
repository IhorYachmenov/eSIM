package com.example.esim.view;

import android.os.Build;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;

import com.example.esim.R;
import com.example.esim.databinding.ActivityMainScreenBinding;
import com.example.esim.viewmodel.EsimPlansViewModel;

public class EsimPlansActivity extends AppCompatActivity {

    // Plan Switcher

    TextView eSIMButton;
    TextView eSIMLabel;
    TextView virtualNumbersButton;
    TextView virtualNumbersLabel;

    LinearLayout eSimSwitcherPlan;
    ConstraintLayout eSimPlans;
    ConstraintLayout virtualNumbersPlan;


    EsimPlansViewModel viewModel = new EsimPlansViewModel();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainScreenBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main_screen);
        binding.setViewModel(viewModel);
        viewModel.onCreate();
        planSwitcher();

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


    public void planSwitcher() {

        eSimSwitcherPlan = findViewById(R.id.block_plan_switcher);
        eSimPlans = findViewById(R.id.block_esim_plans);
        virtualNumbersPlan = findViewById(R.id.block_virtual_numbers_plans);

        eSIMButton = findViewById(R.id.esim_button);
        virtualNumbersButton = findViewById(R.id.virtual_numbers_button);
        eSIMLabel = findViewById(R.id.esim);
        virtualNumbersLabel = findViewById(R.id.virtual_numbers);

        virtualNumbersLabel.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                if (virtualNumbersLabel.isPressed() == true){
                    TransitionManager.beginDelayedTransition(eSimSwitcherPlan, new AutoTransition());

                    virtualNumbersButton.setVisibility(View.VISIBLE);
                    eSIMButton.setVisibility(View.GONE);

                    virtualNumbersPlan.setVisibility(View.VISIBLE);
                    eSimPlans.setVisibility(View.GONE);


                }
            }
        });

        eSIMLabel.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                if (eSIMLabel.isPressed() == true) {
                    TransitionManager.beginDelayedTransition(eSimSwitcherPlan, new AutoTransition());
                    virtualNumbersButton.setVisibility(View.GONE);
                    eSIMButton.setVisibility(View.VISIBLE);

                    virtualNumbersPlan.setVisibility(View.GONE);
                    eSimPlans.setVisibility(View.VISIBLE);

                }
            }
        });

    }


}
