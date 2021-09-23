package com.hp.major.FindUrWay;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;

public class AutoFareFragment extends Fragment {

    public AutoFareFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_auto_fare, container, false);
        TableLayout tl = (TableLayout) view.findViewById(R.id.tt1);
        return view;


    }

}