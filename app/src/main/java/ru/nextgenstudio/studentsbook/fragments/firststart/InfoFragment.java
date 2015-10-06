package ru.nextgenstudio.studentsbook.fragments.firststart;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.nextgenstudio.studentsbook.R;

/**
 * Created by egor on 05.10.15.
 */
public class InfoFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_input_info, null, false);

        return v;
    }
}
