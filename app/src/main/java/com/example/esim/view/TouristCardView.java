package com.example.esim.view;

import android.os.Build;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.esim.R;

public class TouristCardView extends AppCompatActivity {

    ImageView arrowBtnTourist;
    ImageView infoMain;
    ConstraintLayout paymentPlan;
    CardView cardViewTourist;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cardview_tourist);
        expandPlan();
    }


    public void expandPlan() {
        arrowBtnTourist = findViewById(R.id.vector);
        infoMain = findViewById(R.id.question);
        paymentPlan = findViewById(R.id.payment_plan_tourist);
        cardViewTourist = findViewById(R.id.card_view_tourist);

        arrowBtnTourist.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                if (paymentPlan.getVisibility() == View.GONE) {
                    TransitionManager.beginDelayedTransition(cardViewTourist, new AutoTransition());
                    paymentPlan.setVisibility(View.VISIBLE);
                    infoMain.setVisibility(View.VISIBLE);
                    arrowBtnTourist.setImageResource(R.drawable.ic_vector_expand);
                } else {
                    TransitionManager.beginDelayedTransition(cardViewTourist, new AutoTransition());
                    paymentPlan.setVisibility(View.GONE);
                    infoMain.setVisibility(View.GONE);
                    arrowBtnTourist.setImageResource(R.drawable.ic_vector_not);

                }
            }
        });
    }
}
