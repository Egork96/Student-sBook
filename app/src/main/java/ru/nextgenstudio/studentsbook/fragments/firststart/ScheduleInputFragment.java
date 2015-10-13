package ru.nextgenstudio.studentsbook.fragments.firststart;

import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import ru.nextgenstudio.studentsbook.R;
import ru.nextgenstudio.studentsbook.interfaces.FragmentCallback;

/**
 * Created by egor on 09.10.15.
 */
public class ScheduleInputFragment extends Fragment implements View.OnClickListener{

    FragmentCallback callback;
    SharedPreferences sp;
    Bundle args;
    View v;

    Button btn_ready;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        args = getArguments();
        callback = (FragmentCallback) getActivity();
        sp = getActivity().getSharedPreferences("user_settings", Context.MODE_PRIVATE);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_input_schedule, null, false);

        btn_ready = (Button) v.findViewById(R.id.btn_ready);

        return v;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == btn_ready.getId()){

        }
    }
}
