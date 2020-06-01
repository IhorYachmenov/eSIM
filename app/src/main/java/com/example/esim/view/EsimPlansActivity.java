package com.example.esim.view;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

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

    // Supported devices

    ConstraintLayout supportedDevices;

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

        //openUsaSupportedNetworkDialog();
        test_openUsaSupportedNetworkDialog();

        //openSupportedDevicesDialog();
        test_openSupportedDevicesDialog();




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
                    expandedMenuTouristOnetime.setVisibility(View.GONE);
                    paymentSwitchTourist.setChecked(true);
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
                    expandedMenuPremiumOnetime.setVisibility(View.GONE);
                    paymentSwitchPremium.setChecked(true);
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

                DialogFragmentUSANetwork dialog = new DialogFragmentUSANetwork();
                dialog.show(getSupportFragmentManager(),"Open USA Supported Network");



            }
        });

    }

    public void openSupportedDevicesDialog() {

        supportedDevices = findViewById(R.id.block_supported_divices);

        supportedDevices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragmentSupportedDevices dialog = new DialogFragmentSupportedDevices();
                dialog.show(getSupportFragmentManager(), "Open Supported Devices");




            }
        });

    }

    public void test_openUsaSupportedNetworkDialog() {


        usaSupportedNetworkDialog = findViewById(R.id.block_usa_union);

        usaSupportedNetworkDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Dialog dialog = new Dialog(EsimPlansActivity.this, android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setCancelable(false);
                dialog.setContentView(R.layout.test_dialog_fragment_usa_networks);

                ConstraintLayout dialogButton1 = (ConstraintLayout) dialog.findViewById(R.id.close_dialog_usa);
                dialogButton1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                // Fast blur
                Bitmap map = takeScreenShot(EsimPlansActivity.this);
                Bitmap fast = fastBlur(map, 10);
                final Drawable draw = new BitmapDrawable(getResources(), fast);
                dialog.getWindow().setBackgroundDrawable(draw);

                dialog.show();

            }
        });


    }

    public void test_openSupportedDevicesDialog() {

        supportedDevices = findViewById(R.id.block_supported_divices);

        supportedDevices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Dialog dialog = new Dialog(EsimPlansActivity.this, android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setCancelable(false);
                dialog.setContentView(R.layout.test_dialog_fragment_supported_devices);

                final ImageView appleListOfDevices = (ImageView) dialog.findViewById(R.id.arrow_apple);
                final ConstraintLayout appleDevices = (ConstraintLayout) dialog.findViewById(R.id.apple_devices);

                ConstraintLayout dialogButton1 = (ConstraintLayout) dialog.findViewById(R.id.close_dialog_supported_devices);
                dialogButton1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                appleListOfDevices.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (appleDevices.getVisibility() == View.GONE) {
                            appleListOfDevices.setImageResource(R.drawable.ic_vector_expand);
                            appleDevices.setVisibility(View.VISIBLE);
                        } else {
                            appleListOfDevices.setImageResource(R.drawable.ic_vector_not);
                            appleDevices.setVisibility(View.GONE);
                        }

                    }
                });


                // Fast blur
                Bitmap map = takeScreenShot(EsimPlansActivity.this);
                Bitmap fast = fastBlur(map, 10);
                final Drawable draw = new BitmapDrawable(getResources(), fast);
                dialog.getWindow().setBackgroundDrawable(draw);

                dialog.show();


            }
        });
    }

    // Blurred background when dialog will be open
    public static Bitmap takeScreenShot(Activity activity) {
        View view = activity.getWindow().getDecorView();
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();


        Bitmap b1 = view.getDrawingCache();
        Rect frame = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(frame);
        int statusBarHeight = frame.top;

        Display display = activity.getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;

        Bitmap b = Bitmap.createBitmap(b1, 0, statusBarHeight, width, height - statusBarHeight);
        view.destroyDrawingCache();
        return b;
    }

    public Bitmap fastBlur(Bitmap sentBitmap, int radius) {
        Bitmap bitmap = sentBitmap.copy(sentBitmap.getConfig(), true);
        if (radius < 1) {
            return (null);
        }
        int w = bitmap.getWidth();
        int h = bitmap.getHeight();
        int[] pix = new int[w * h];
        Log.e("pix", w + " " + h + " " + pix.length);
        bitmap.getPixels(pix, 0, w, 0, 0, w, h);
        int wm = w - 1;
        int hm = h - 1;
        int wh = w * h;
        int div = radius + radius + 1;
        int r[] = new int[wh];
        int g[] = new int[wh];
        int b[] = new int[wh];
        int rsum, gsum, bsum, x, y, i, p, yp, yi, yw;
        int vmin[] = new int[Math.max(w, h)];
        int divsum = (div + 1) >> 1;
        divsum *= divsum;
        int dv[] = new int[256 * divsum];
        for (i = 0; i < 256 * divsum; i++) {
            dv[i] = (i / divsum);
        }
        yw = yi = 0;
        int[][] stack = new int[div][3];
        int stackpointer;
        int stackstart;
        int[] sir;
        int rbs;
        int r1 = radius + 1;
        int routsum, goutsum, boutsum;
        int rinsum, ginsum, binsum;
        for (y = 0; y < h; y++) {
            rinsum = ginsum = binsum = routsum = goutsum = boutsum = rsum = gsum = bsum = 0;
            for (i = -radius; i <= radius; i++) {
                p = pix[yi + Math.min(wm, Math.max(i, 0))];
                sir = stack[i + radius];
                sir[0] = (p & 0xff0000) >> 16;
                sir[1] = (p & 0x00ff00) >> 8;
                sir[2] = (p & 0x0000ff);
                rbs = r1 - Math.abs(i);
                rsum += sir[0] * rbs;
                gsum += sir[1] * rbs;
                bsum += sir[2] * rbs;
                if (i > 0) {
                    rinsum += sir[0];
                    ginsum += sir[1];
                    binsum += sir[2];
                } else {
                    routsum += sir[0];
                    goutsum += sir[1];
                    boutsum += sir[2];
                }
            }
            stackpointer = radius;
            for (x = 0; x < w; x++) {
                r[yi] = dv[rsum];
                g[yi] = dv[gsum];
                b[yi] = dv[bsum];
                rsum -= routsum;
                gsum -= goutsum;
                bsum -= boutsum;
                stackstart = stackpointer - radius + div;
                sir = stack[stackstart % div];
                routsum -= sir[0];
                goutsum -= sir[1];
                boutsum -= sir[2];
                if (y == 0) {
                    vmin[x] = Math.min(x + radius + 1, wm);
                }
                p = pix[yw + vmin[x]];
                sir[0] = (p & 0xff0000) >> 16;
                sir[1] = (p & 0x00ff00) >> 8;
                sir[2] = (p & 0x0000ff);
                rinsum += sir[0];
                ginsum += sir[1];
                binsum += sir[2];
                rsum += rinsum;
                gsum += ginsum;
                bsum += binsum;
                stackpointer = (stackpointer + 1) % div;
                sir = stack[(stackpointer) % div];
                routsum += sir[0];
                goutsum += sir[1];
                boutsum += sir[2];
                rinsum -= sir[0];
                ginsum -= sir[1];
                binsum -= sir[2];
                yi++;
            }
            yw += w;
        }
        for (x = 0; x < w; x++) {
            rinsum = ginsum = binsum = routsum = goutsum = boutsum = rsum = gsum = bsum = 0;
            yp = -radius * w;
            for (i = -radius; i <= radius; i++) {
                yi = Math.max(0, yp) + x;
                sir = stack[i + radius];
                sir[0] = r[yi];
                sir[1] = g[yi];
                sir[2] = b[yi];
                rbs = r1 - Math.abs(i);
                rsum += r[yi] * rbs;
                gsum += g[yi] * rbs;
                bsum += b[yi] * rbs;
                if (i > 0) {
                    rinsum += sir[0];
                    ginsum += sir[1];
                    binsum += sir[2];
                } else {
                    routsum += sir[0];
                    goutsum += sir[1];
                    boutsum += sir[2];
                }
                if (i < hm) {
                    yp += w;
                }
            }
            yi = x;
            stackpointer = radius;
            for (y = 0; y < h; y++) {
                // Preserve alpha channel: ( 0xff000000 & pix[yi] )
                pix[yi] = ( 0xff000000 & pix[yi] ) | ( dv[rsum] << 16 ) | ( dv[gsum] << 8 ) | dv[bsum];
                rsum -= routsum;
                gsum -= goutsum;
                bsum -= boutsum;
                stackstart = stackpointer - radius + div;
                sir = stack[stackstart % div];
                routsum -= sir[0];
                goutsum -= sir[1];
                boutsum -= sir[2];
                if (x == 0) {
                    vmin[y] = Math.min(y + r1, hm) * w;
                }
                p = x + vmin[y];
                sir[0] = r[p];
                sir[1] = g[p];
                sir[2] = b[p];
                rinsum += sir[0];
                ginsum += sir[1];
                binsum += sir[2];
                rsum += rinsum;
                gsum += ginsum;
                bsum += binsum;
                stackpointer = (stackpointer + 1) % div;
                sir = stack[stackpointer];
                routsum += sir[0];
                goutsum += sir[1];
                boutsum += sir[2];
                rinsum -= sir[0];
                ginsum -= sir[1];
                binsum -= sir[2];
                yi += w;
            }
        }
        Log.e("pix", w + " " + h + " " + pix.length);
        bitmap.setPixels(pix, 0, w, 0, 0, w, h);
        return (bitmap);
    }


}
