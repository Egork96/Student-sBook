package ru.nextgenstudio.studentsbook.fragments.firststart;

import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;

import ru.nextgenstudio.studentsbook.R;
import ru.nextgenstudio.studentsbook.interfaces.FragmentCallback;

/**
 * Created by egor on 04.10.15.
 */
public class WelcomeFragment extends Fragment{

    FragmentCallback callback;
    Bundle args;
    View v;

    Animation move_alpha;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        args = getArguments();
        callback = (FragmentCallback) getActivity();

        move_alpha = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.move_alpha);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                callback.ended(args.getInt("which"));
            }
        }, 3000);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fragment_welcome, null, false);
        RelativeLayout layout = (RelativeLayout) v.findViewById(R.id.welcome_layout);
        layout.startAnimation(move_alpha);

        return v;
    }


}
