package com.example.esim.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;

import com.example.esim.R;

public class DialogFragmentSupportedDevices extends DialogFragment {

    private ConstraintLayout closeDialog;

    View view;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.dialog_fragment_supported_devices, container, false);

        closeDialog = view.findViewById(R.id.close_dialog_supported_devices);
        closeDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().dismiss();
            }
        });

        openAppleSupportedDevices();

        return view;
    }

    private void openAppleSupportedDevices() {
        final ImageView appleListOfDevices = view.findViewById(R.id.arrow_apple);
        final ConstraintLayout appleDevices = view.findViewById(R.id.apple_devices);

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


    }
}
