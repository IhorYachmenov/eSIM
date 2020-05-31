package com.example.esim.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;

import com.example.esim.R;

public class DialogFragmentUSANetwork extends DialogFragment {

    private ConstraintLayout closeDialog;
    private ConstraintLayout parentView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.dialog_fragment_usa_networks, container, false );

        setStyle(STYLE_NO_FRAME, R.style.FullScreenDialogStyle);

        closeDialog = view.findViewById(R.id.close_dialog_usa);
        //parentView = view.findViewById(R.id.parent_view_dialog_usa);


        closeDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().dismiss();

            }
        });

        return view;
    }

}
