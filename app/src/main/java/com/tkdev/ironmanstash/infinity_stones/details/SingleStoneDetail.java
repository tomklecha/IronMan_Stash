package com.tkdev.ironmanstash.infinity_stones.details;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.tkdev.ironmanstash.R;
import com.tkdev.ironmanstash.infinity_stones.database.StonesDbHelper;
import com.tkdev.ironmanstash.infinity_stones.stones.InfinityFragment;

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

    private StonesDbHelper dbHelper;
    private SQLiteDatabase database;
    private Cursor cursor;

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

//                if (passwordInput.equals(passwordExpected)) {

//                    closeKeyboard();
                ((AppCompatActivity)getContext()).getSupportFragmentManager().popBackStack("frag3", FragmentManager.POP_BACK_STACK_INCLUSIVE);

                    getActivity().getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.activity_container, InfinityFragment.newInstance(name))
                            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                            .commit();

                String entryCount = String.valueOf(getActivity().getSupportFragmentManager().getBackStackEntryCount());
                Toast.makeText(getContext(), "Backstack entry count : " + entryCount  , Toast.LENGTH_SHORT).show();

                    Toast.makeText(getContext(), "Password correct, unlocked " + name + " in SSdetail", Toast.LENGTH_SHORT).show();
//                }

            }
        });
    }

    private void closeKeyboard() {
        InputMethodManager inputManager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        inputManager.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);
    }
}