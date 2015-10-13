package ru.nextgenstudio.studentsbook.fragments.firststart;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import ru.nextgenstudio.studentsbook.MainActivity;
import ru.nextgenstudio.studentsbook.R;
import ru.nextgenstudio.studentsbook.interfaces.FragmentCallback;

/**
 * Created by egor on 05.10.15.
 */
public class InfoFragment extends Fragment implements View.OnClickListener{

    FragmentCallback callback;
    SharedPreferences sp;
    Bundle args;
    View v;

    EditText edit_school, edit_group, edit_course;
    Button btn_next;


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
        v = inflater.inflate(R.layout.fragment_input_info, null, false);

        edit_course = (EditText) v.findViewById(R.id.edit_course);
        edit_group = (EditText) v.findViewById(R.id.edit_group);
        edit_school = (EditText) v.findViewById(R.id.edit_high_school);
        btn_next = (Button) v.findViewById(R.id.btn_ready);

        btn_next.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == btn_next.getId()) {
            if (edit_school.getText().length() != 0 && edit_group.getText().length() != 0 && edit_course.getText().length() != 0) {
                sp.edit().putString("high_school", edit_school.getText().toString())
                        .putString("group", edit_course.getText().toString())
                        .putInt("course", Integer.valueOf(edit_course.getText().toString())).apply();
                showSnack("Данные сохранены!", Snackbar.LENGTH_LONG);
                startActivity(new Intent(getActivity().getApplicationContext(), MainActivity.class));
            } else {
                showSnack("Заполните все поля!", Snackbar.LENGTH_LONG);
            }
        }
    }


    void showSnack(String text, int duration){
        Snackbar snackbar = Snackbar.make(v, text, duration);
        ((TextView)snackbar.getView().findViewById(android.support.design.R.id.snackbar_text))
                .setTextColor(getResources().getColor(R.color.indigo_icons));
        snackbar.show();
    }

}
