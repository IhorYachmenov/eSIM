package com.example.esim.view;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;

import com.example.esim.R;
import com.example.esim.databinding.ActivityMainScreenBinding;
import com.example.esim.viewmodel.EsimPlansViewModel;

public class EsimPlansActivity extends AppCompatActivity {

    // Plan Switcher eSIM/Virtual Numbers

    TextView eSIMButton;
    TextView eSIMLabel;
    TextView virtualNumbersButton;
    TextView virtualNumbersLabel;

    LinearLayout eSimSwitcherPlan;
    ConstraintLayout eSimPlansTourist;
    ConstraintLayout eSimPlansPremium;
    ConstraintLayout eSimPlansBusiness;
    ConstraintLayout virtualNumbersPlan;

    // Tourist CardView

    ImageView arrowBtnTourist;
    ImageView infoMain;
    ConstraintLayout paymentPlan;
    CardView cardViewTourist;
    ConstraintLayout expandedMenuTouristMonthly;
    ConstraintLayout expandedMenuTouristOnetime;

    // Tourist payment switcher

    SwitchCompat paymentSwitchTourist;
    TextView oneTimeTextTouristPayment;
    ImageView oneTimeImageTouristPayment;
    TextView monthlyTextTouristPayment;
    ImageView monthlyImageTouristPayment;

    // Premium CardView

    ImageView arrowBtnPremium;
    ImageView infoMainPremium;
    ConstraintLayout paymentPlanPremium;
    CardView cardViewPremium;
    ConstraintLayout expandedMenuPremiumMonthly;
    ConstraintLayout expandedMenuPremiumOnetime;

    // Premium payment switcher

    SwitchCompat paymentSwitchPremium;
    TextView oneTimeTextPremiumPayment;
    ImageView oneTimeImagePremiumPayment;
    TextView monthlyTextPremiumPayment;
    ImageView monthlyImagePremiumPayment;

    // USA supported networks

    ConstraintLayout usaSupportedNetworkDialog;




    EsimPlansViewModel viewModel = new EsimPlansViewModel();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainScreenBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main_screen);
        binding.setViewModel(viewModel);
        viewModel.onCreate();
        planSwitcher();
        expandPlanTourist();
        expandPlanPremium();
        planPaymentSwitcherTourist();
        planPaymentSwitcherPremium();
        openUsaSupportedNetworkDialog();

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
        eSimPlansTourist = findViewById(R.id.block_esim_plan_tourist);
        eSimPlansPremium = findViewById(R.id.block_esim_plan_premium);
        eSimPlansBusiness = findViewById(R.id.block_esim_plan_business);
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
                    eSimPlansTourist.setVisibility(View.GONE);
                    eSimPlansPremium.setVisibility(View.GONE);
                    eSimPlansBusiness.setVisibility(View.GONE);


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
                    eSimPlansTourist.setVisibility(View.VISIBLE);
                    eSimPlansPremium.setVisibility(View.VISIBLE);
                    eSimPlansBusiness.setVisibility(View.VISIBLE);

                }
            }
        });

    }

    public void expandPlanTourist() {
        arrowBtnTourist = findViewById(R.id.vector);
        infoMain = findViewById(R.id.question);
        paymentPlan = findViewById(R.id.payment_plan_tourist);
        cardViewTourist = findViewById(R.id.card_view_tourist);
        expandedMenuTouristMonthly = findViewById(R.id.expanded_menu_monthly_tourist);
        expandedMenuTouristOnetime = findViewById(R.id.expanded_menu_onetime_tourist);

        arrowBtnTourist.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                if (paymentPlan.getVisibility() == View.GONE && expandedMenuTouristMonthly.getVisibility() == View.GONE) {
                    TransitionManager.beginDelayedTransition(cardViewTourist, new AutoTransition());
                    paymentPlan.setVisibility(View.VISIBLE);
                    expandedMenuTouristMonthly.setVisibility(View.VISIBLE);
                    infoMain.setVisibility(View.VISIBLE);
                    arrowBtnTourist.setImageResource(R.drawable.ic_vector_expand);
                } else {
                    TransitionManager.beginDelayedTransition(cardViewTourist, new AutoTransition());
                    paymentPlan.setVisibility(View.GONE);
                    expandedMenuTouristMonthly.setVisibility(View.GONE);
                    infoMain.setVisibility(View.GONE);
                    arrowBtnTourist.setImageResource(R.drawable.ic_vector_not);
                }
            }
        });
    }

    public void expandPlanPremium() {
        arrowBtnPremium = findViewById(R.id.vector_premium);
        infoMainPremium = findViewById(R.id.question_premium);
        paymentPlanPremium = findViewById(R.id.payment_plan_premium);
        cardViewPremium = findViewById(R.id.card_view_premium);
        expandedMenuPremiumMonthly = findViewById(R.id.expanded_menu_monthly_premium);
        expandedMenuPremiumOnetime = findViewById(R.id.expanded_menu_onetime_premium);

        arrowBtnPremium.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                if (paymentPlanPremium.getVisibility() == View.GONE && expandedMenuPremiumMonthly.getVisibility() == View.GONE) {
                    TransitionManager.beginDelayedTransition(cardViewPremium, new AutoTransition());
                    paymentPlanPremium.setVisibility(View.VISIBLE);
                    expandedMenuPremiumMonthly.setVisibility(View.VISIBLE);
                    infoMainPremium.setVisibility(View.VISIBLE);
                    arrowBtnPremium.setImageResource(R.drawable.ic_vector_expand);
                } else {
                    TransitionManager.beginDelayedTransition(cardViewPremium, new AutoTransition());
                    paymentPlanPremium.setVisibility(View.GONE);
                    expandedMenuPremiumMonthly.setVisibility(View.GONE);
                    infoMainPremium.setVisibility(View.GONE);
                    arrowBtnPremium.setImageResource(R.drawable.ic_vector_not);
                }
            }
        });
    }

    public void planPaymentSwitcherTourist() {

        paymentSwitchTourist = findViewById(R.id.switch_plan_tourist);
        oneTimeTextTouristPayment = findViewById(R.id.one_time_tourist);
        oneTimeImageTouristPayment = findViewById(R.id.one_time_info_tourist);
        monthlyTextTouristPayment = findViewById(R.id.monthly_tourist);
        monthlyImageTouristPayment = findViewById(R.id.monthly_info_tourist);

        paymentSwitchTourist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (paymentSwitchTourist.isChecked()) {
                    monthlyTextTouristPayment.setTextColor(Color.WHITE);
                    monthlyImageTouristPayment.setColorFilter(Color.WHITE);

                    oneTimeTextTouristPayment.setTextColor(Color.parseColor("#640E0D0D"));
                    oneTimeImageTouristPayment.setColorFilter(Color.parseColor("#640E0D0D"));

                    expandedMenuTouristMonthly.setVisibility(View.VISIBLE);
                    expandedMenuTouristOnetime.setVisibility(View.GONE);

                } else {

                    monthlyTextTouristPayment.setTextColor(Color.parseColor("#640E0D0D"));
                    monthlyImageTouristPayment.setColorFilter(Color.parseColor("#640E0D0D"));

                    oneTimeTextTouristPayment.setTextColor(Color.WHITE);
                    oneTimeImageTouristPayment.setColorFilter(Color.WHITE);

                    expandedMenuTouristMonthly.setVisibility(View.GONE);
                    expandedMenuTouristOnetime.setVisibility(View.VISIBLE);

                }
            }
        });

    }

    public void planPaymentSwitcherPremium() {

        paymentSwitchPremium = findViewById(R.id.switch_plan_premium);
        oneTimeTextPremiumPayment = findViewById(R.id.one_time_premium);
        oneTimeImagePremiumPayment = findViewById(R.id.one_time_info_premium);
        monthlyTextPremiumPayment = findViewById(R.id.monthly_premium);
        monthlyImagePremiumPayment = findViewById(R.id.monthly_info_premium);

        paymentSwitchPremium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (paymentSwitchPremium.isChecked()) {
                    monthlyTextPremiumPayment.setTextColor(Color.WHITE);
                    monthlyImagePremiumPayment.setColorFilter(Color.WHITE);

                    oneTimeTextPremiumPayment.setTextColor(Color.parseColor("#640E0D0D"));
                    oneTimeImagePremiumPayment.setColorFilter(Color.parseColor("#640E0D0D"));

                    expandedMenuPremiumMonthly.setVisibility(View.VISIBLE);
                    expandedMenuPremiumOnetime.setVisibility(View.GONE);

                } else {

                    monthlyTextPremiumPayment.setTextColor(Color.parseColor("#640E0D0D"));
                    monthlyImagePremiumPayment.setColorFilter(Color.parseColor("#640E0D0D"));

                    oneTimeTextPremiumPayment.setTextColor(Color.WHITE);
                    oneTimeImagePremiumPayment.setColorFilter(Color.WHITE);

                    expandedMenuPremiumMonthly.setVisibility(View.GONE);
                    expandedMenuPremiumOnetime.setVisibility(View.VISIBLE);

                }
            }
        });

    }

    public void openUsaSupportedNetworkDialog() {

        usaSupportedNetworkDialog = findViewById(R.id.block_usa_union);

        usaSupportedNetworkDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Context context = getApplicationContext();
               // Toast.makeText(context, "TEST", Toast.LENGTH_SHORT).show();

                DialogFragmentUSANetwork dialog = new DialogFragmentUSANetwork();
                dialog.show(getSupportFragmentManager(),"Open USA Supported Network");

            }
        });

    }


}
