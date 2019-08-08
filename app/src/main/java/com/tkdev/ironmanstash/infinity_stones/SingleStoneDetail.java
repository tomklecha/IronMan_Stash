package com.tkdev.ironmanstash.infinity_stones;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tkdev.ironmanstash.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SingleStoneDetail extends SingleStoneCV {


    public SingleStoneDetail() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_single_view, container, false);

        return rootView;
    }

}
