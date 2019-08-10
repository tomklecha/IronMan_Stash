package com.tkdev.ironmanstash.infinity_stones.details;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.tkdev.ironmanstash.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class SingleStoneCV extends Fragment {

    private Button confirmButton;
    private EditText passwordText;
    private String passwordInput;
    private String passwordExpected = "pass";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_stone_detail, container, false);


        confirmButton = view.findViewById(R.id.confirm_button);
        passwordText = view.findViewById(R.id.password_imput);


        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                passwordInput = passwordText.getText().toString();

                if (passwordInput.equals(passwordExpected)) {
                    Toast.makeText(getContext(), passwordInput, Toast.LENGTH_SHORT).show();
                    getFragmentManager().popBackStack();


                }
                Toast.makeText(getContext(), passwordInput + " expected : " + passwordExpected  , Toast.LENGTH_SHORT).show();
            }
        });


    }
}

