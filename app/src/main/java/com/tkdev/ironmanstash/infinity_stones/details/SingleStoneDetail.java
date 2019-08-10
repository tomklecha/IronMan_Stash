package com.tkdev.ironmanstash.infinity_stones.details;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.tkdev.ironmanstash.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SingleStoneDetail extends Fragment {

    public static final String NAME = "name";
    public static final String QUEST = "quest";
    public static final String COLOR = "color";
    public static final String PASSWORD = "password";

    private Button confirmButton;
    private EditText passwordText;
    private TextView textView;
    private TextView questView;

    private String name;
    private int color;
    private String quest;
    private String passwordInput;
    private String passwordExpected;

    public static SingleStoneDetail newInstance(String name, int color, String quest, String password) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(NAME, name);
        bundle.putSerializable(COLOR, color);
        bundle.putSerializable(QUEST, quest);
        bundle.putSerializable(PASSWORD, password);


        SingleStoneDetail fragment = new SingleStoneDetail();
        fragment.setArguments(bundle);

        return fragment;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        name = (String) getArguments().getSerializable(NAME);
        color = (int) getArguments().getSerializable(COLOR);
        quest = (String) getArguments().getSerializable(QUEST);
        passwordExpected = (String) getArguments().getSerializable(PASSWORD);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_stone_detail, container, false);
        view.setBackgroundColor(getResources().getColor(color));

        textView = view.findViewById(R.id.stone_text_view);
        questView = view.findViewById(R.id.quest_text_view);
        confirmButton = view.findViewById(R.id.confirm_button);
        passwordText = view.findViewById(R.id.password_input);

        textView.setText(name);


        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        textView.setText(name);
        questView.setText(quest);

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                passwordInput = passwordText.getText().toString();

                if (passwordInput.equals(passwordExpected)) {

                    Toast.makeText(getContext(), "Brawo me", Toast.LENGTH_SHORT).show();

//                    int i = getFragmentManager().getBackStackEntryCount();
//                    Toast.makeText(getContext(), Integer.toString(i), Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(getContext(), passwordInput + " expected : " + passwordExpected, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}