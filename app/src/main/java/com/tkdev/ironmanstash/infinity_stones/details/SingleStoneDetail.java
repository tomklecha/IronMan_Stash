package com.tkdev.ironmanstash.infinity_stones.details;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.tkdev.ironmanstash.R;
import com.tkdev.ironmanstash.infinity_stones.stones.InfinityFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class SingleStoneDetail extends Fragment {

    public static final String NAME = "name";

    private Button confirmButton;
    private EditText passwordText;
    private TextView textView;

    private String name;
    private String passwordInput;
    private String passwordExpected = "pass";

    public static SingleStoneDetail newInstance(String name) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(NAME, name);


        SingleStoneDetail fragment = new SingleStoneDetail();
        fragment.setArguments(bundle);

        return fragment;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        name = (String) getArguments().getSerializable(NAME);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_stone_detail, container, false);
//        view.setBackgroundColor;

        textView = view.findViewById(R.id.stone_name_view);
        confirmButton = view.findViewById(R.id.confirm_button);
        passwordText = view.findViewById(R.id.password_imput);

        textView.setText(name);


        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        textView.setText(name);

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                passwordInput = passwordText.getText().toString();

                if (passwordInput.equals(passwordExpected)) {

                    int i = getFragmentManager().getBackStackEntryCount();
                    Toast.makeText(getContext(), Integer.toString(i), Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(getContext(), passwordInput + " expected : " + passwordExpected, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}