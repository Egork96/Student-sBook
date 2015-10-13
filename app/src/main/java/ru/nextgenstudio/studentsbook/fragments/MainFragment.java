package ru.nextgenstudio.studentsbook.fragments;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import ru.nextgenstudio.studentsbook.R;

/**
 * Created by egor on 28.09.15.
 */
public class MainFragment extends Fragment implements View.OnClickListener{

    View v;
    CoordinatorLayout coordinator;
    Snackbar snackbar;

    ScrollView scrollView;
    LinearLayout eventsLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v =  inflater.inflate(R.layout.fragment_main, null, false);
        coordinator = (CoordinatorLayout) v.findViewById(R.id.coordinator);

        FloatingActionButton fab = (FloatingActionButton) v.findViewById(R.id.fab);
        fab.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.fab) {
            snackbar = Snackbar.make(v, "Floating Action Button", Snackbar.LENGTH_SHORT);
            snackbar.getView().setAlpha(0.5f);
            ((TextView) snackbar.getView().findViewById(android.support.design.R.id.snackbar_text)).setTextColor(Color.WHITE);
            snackbar.show();
        }

    }

}