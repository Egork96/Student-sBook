package ru.nextgenstudio.studentsbook;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import ru.nextgenstudio.studentsbook.fragments.firststart.InfoFragment;
import ru.nextgenstudio.studentsbook.fragments.firststart.ThemesFragment;
import ru.nextgenstudio.studentsbook.fragments.firststart.WelcomeFragment;
import ru.nextgenstudio.studentsbook.interfaces.FragmentCallback;

public class FirstStartActivity extends AppCompatActivity implements FragmentCallback{

    private static final int WELCOME_FRAGMENT = 0;
    private static final int THEMES_FRAGMENT = 1;
    private static final int INFO_FRAGMENT = 2;

    WelcomeFragment welcomeFragment;
    ThemesFragment themesFragment;
    InfoFragment infoFragment;

    FragmentManager fm;

    Bundle welcomeArgs, themesArgs, infoArgs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_start);

        welcomeArgs = new Bundle();
        welcomeArgs.putInt("which", WELCOME_FRAGMENT);
        themesArgs = new Bundle();
        themesArgs.putInt("which", THEMES_FRAGMENT);
        infoArgs = new Bundle();
        infoArgs.putInt("which", INFO_FRAGMENT);

        welcomeFragment = new WelcomeFragment();
        themesFragment = new ThemesFragment();
        infoFragment = new InfoFragment();

        welcomeFragment.setArguments(welcomeArgs);
        themesFragment.setArguments(themesArgs);
        infoFragment.setArguments(infoArgs);

        fm = getFragmentManager();
        fm.beginTransaction().add(R.id.container, welcomeFragment).commit();

    }

    @Override
    public void onBackPressed() {

    }

    @Override
    public void ended(int which) {
        if (which == WELCOME_FRAGMENT){
            fm.beginTransaction().replace(R.id.container, themesFragment).commit();
        }else if(which == THEMES_FRAGMENT){
            fm.beginTransaction().replace(R.id.container, infoFragment).commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_first_start, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
