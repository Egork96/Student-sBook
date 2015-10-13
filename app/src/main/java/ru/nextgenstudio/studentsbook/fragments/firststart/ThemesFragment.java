package ru.nextgenstudio.studentsbook.fragments.firststart;

import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;

import ru.nextgenstudio.studentsbook.R;
import ru.nextgenstudio.studentsbook.interfaces.FragmentCallback;
import ru.nextgenstudio.studentsbook.interfaces.SupportThemes;

/**
 * Created by egor on 05.10.15.
 */
public class ThemesFragment extends Fragment implements View.OnClickListener, SupportThemes{

    FragmentCallback callback;
    SharedPreferences sp;
    Bundle args;
    View v;

    FrameLayout preFab, preBar;

    Animation preFabAnim, preBarAnim;
    Animation[] appearance = new Animation[THEMES_COUNT];

    Button[] theme = new Button[THEMES_COUNT];
    Button btnNext;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        args = getArguments();
        callback = (FragmentCallback) getActivity();
        sp = getActivity().getSharedPreferences("user_settings", Context.MODE_PRIVATE);

        preFabAnim = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.preview_anim_fab);
        preBarAnim = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.preview_anim_toolbar);

        for (int i = 0; i < THEMES_COUNT; i++){
            appearance[i] = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.appearance);
            appearance[i].setStartOffset(100*i);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_themes, null, false);
        preFab = (FrameLayout) v.findViewById(R.id.pre_fab);
        preBar = (FrameLayout) v.findViewById(R.id.pre_toolbar);

        btnNext = (Button) v.findViewById(R.id.btn_ready);
        btnNext.setOnClickListener(this);

        theme[0] = (Button) v.findViewById(R.id.theme_red);
        theme[1] = (Button) v.findViewById(R.id.theme_orange);
        theme[2] = (Button) v.findViewById(R.id.theme_amber);
        theme[3] = (Button) v.findViewById(R.id.theme_purple);
        theme[4] = (Button) v.findViewById(R.id.theme_indigo);
        theme[5] = (Button) v.findViewById(R.id.theme_blue);
        theme[6] = (Button) v.findViewById(R.id.theme_pink);
        theme[7] = (Button) v.findViewById(R.id.theme_green);
        theme[8] = (Button) v.findViewById(R.id.theme_lime);
        theme[9] = (Button) v.findViewById(R.id.theme_grey);
        theme[10] = (Button) v.findViewById(R.id.theme_blue_grey);
        theme[11] = (Button) v.findViewById(R.id.theme_cyan);

        for (int i = 0; i < THEMES_COUNT; i++){
            theme[i].setOnClickListener(this);
            theme[i].setAnimation(appearance[i]);
        }

        return v;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.theme_red:
                sp.edit().putInt("current_theme", THEME_RED).apply();
                preFab.startAnimation(preFabAnim);
                preBar.startAnimation(preBarAnim);
                break;
            case R.id.theme_orange:
                sp.edit().putInt("current_theme", THEME_ORANGE).apply();
                preFab.startAnimation(preFabAnim);
                preBar.startAnimation(preBarAnim);
                break;
            case R.id.theme_amber:
                sp.edit().putInt("current_theme", THEME_AMBER).apply();
                preFab.startAnimation(preFabAnim);
                preBar.startAnimation(preBarAnim);
                break;
            case R.id.theme_purple:
                sp.edit().putInt("current_theme", THEME_PURPLE).apply();
                preFab.startAnimation(preFabAnim);
                preBar.startAnimation(preBarAnim);
                break;
            case R.id.theme_indigo:
                sp.edit().putInt("current_theme", THEME_INDIGO).apply();
                preFab.startAnimation(preFabAnim);
                preBar.startAnimation(preBarAnim);
                break;
            case R.id.theme_blue:
                sp.edit().putInt("current_theme", THEME_BLUE).apply();
                preFab.startAnimation(preFabAnim);
                preBar.startAnimation(preBarAnim);
                break;
            case R.id.theme_pink:
                sp.edit().putInt("current_theme", THEME_PINK).apply();
                preFab.startAnimation(preFabAnim);
                preBar.startAnimation(preBarAnim);
                break;
            case R.id.theme_green:
                sp.edit().putInt("current_theme", THEME_GREEN).apply();
                preFab.startAnimation(preFabAnim);
                preBar.startAnimation(preBarAnim);
                break;
            case R.id.theme_lime:
                sp.edit().putInt("current_theme", THEME_LIME).apply();
                preFab.startAnimation(preFabAnim);
                preBar.startAnimation(preBarAnim);
                break;
            case R.id.theme_grey:
                sp.edit().putInt("current_theme", THEME_GREY).apply();
                preFab.startAnimation(preFabAnim);
                preBar.startAnimation(preBarAnim);
                break;
            case R.id.theme_blue_grey:
                sp.edit().putInt("current_theme", THEME_BLUE_GREY).apply();
                preFab.startAnimation(preFabAnim);
                preBar.startAnimation(preBarAnim);
                break;
            case R.id.theme_cyan:
                sp.edit().putInt("current_theme", THEME_CYAN).apply();
                preFab.startAnimation(preFabAnim);
                preBar.startAnimation(preBarAnim);
                break;
            case R.id.btn_ready:
                callback.ended(args.getInt("which"));
                break;
        }
    }
}
