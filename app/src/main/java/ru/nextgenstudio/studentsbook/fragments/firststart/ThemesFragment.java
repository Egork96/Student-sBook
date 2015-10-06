package ru.nextgenstudio.studentsbook.fragments.firststart;

import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import ru.nextgenstudio.studentsbook.R;
import ru.nextgenstudio.studentsbook.interfaces.FragmentCallback;

/**
 * Created by egor on 05.10.15.
 */
public class ThemesFragment extends Fragment implements View.OnClickListener{

    FragmentCallback callback;
    SharedPreferences sp;
    Bundle args;
    View v;

    Animation appearance1, appearance2, appearance3, appearance4, appearance5, appearance6;

    Button theme1, theme2, theme3, theme4, theme5, theme6;
    TextView btnNext;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        args = getArguments();
        callback = (FragmentCallback) getActivity();
        sp = getActivity().getSharedPreferences("user_settings", Context.MODE_PRIVATE);

        appearance1 = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.appearance);
        appearance2 = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.appearance);
        appearance3 = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.appearance);
        appearance4 = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.appearance);
        appearance5 = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.appearance);
        appearance6 = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.appearance);
        appearance1.setStartOffset(0);
        appearance2.setStartOffset(100);
        appearance3.setStartOffset(400);
        appearance4.setStartOffset(200);
        appearance5.setStartOffset(300);
        appearance6.setStartOffset(500);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_themes, null, false);

        btnNext = (TextView) v.findViewById(R.id.btn_next);
        btnNext.setOnClickListener(this);

        theme1 = (Button) v.findViewById(R.id.theme1);
        theme2 = (Button) v.findViewById(R.id.theme2);
        theme3 = (Button) v.findViewById(R.id.theme3);
        theme4 = (Button) v.findViewById(R.id.theme4);
        theme5 = (Button) v.findViewById(R.id.theme5);
        theme6 = (Button) v.findViewById(R.id.theme6);

        theme1.setOnClickListener(this);
        theme2.setOnClickListener(this);
        theme3.setOnClickListener(this);
        theme4.setOnClickListener(this);
        theme5.setOnClickListener(this);
        theme6.setOnClickListener(this);

        theme1.setAnimation(appearance1);
        theme2.setAnimation(appearance2);
        theme3.setAnimation(appearance3);
        theme4.setAnimation(appearance4);
        theme5.setAnimation(appearance5);
        theme6.setAnimation(appearance6);

        return v;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.theme1:
                sp.edit().putInt("current_theme", 1).apply();
                Snackbar.make(v, "Выбрана тема 1", Snackbar.LENGTH_SHORT).setAction("Действие", null).show();
                break;
            case R.id.theme2:
                sp.edit().putInt("current_theme", 2).apply();
                Snackbar.make(v, "Выбрана тема 1", Snackbar.LENGTH_SHORT).setAction("Действие", null).show();
                break;
            case R.id.theme3:
                sp.edit().putInt("current_theme", 3).apply();
                Snackbar.make(v, "Выбрана тема 1", Snackbar.LENGTH_SHORT).setAction("Действие", null).show();
                break;
            case R.id.theme4:
                sp.edit().putInt("current_theme", 4).apply();
                Snackbar.make(v, "Выбрана тема 1", Snackbar.LENGTH_SHORT).setAction("Действие", null).show();
                break;
            case R.id.theme5:
                sp.edit().putInt("current_theme", 5).apply();
                Snackbar.make(v, "Выбрана тема 1", Snackbar.LENGTH_SHORT).setAction("Действие", null).show();
                break;
            case R.id.theme6:
                sp.edit().putInt("current_theme", 6).apply();
                Snackbar.make(v, "Выбрана тема 1", Snackbar.LENGTH_SHORT).setAction("Действие", null).show();
                break;
            case R.id.btn_next:
                callback.ended(args.getInt("which"));
                break;
        }
    }
}
