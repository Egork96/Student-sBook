package ru.nextgenstudio.studentsbook;

import android.app.FragmentManager;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import ru.nextgenstudio.studentsbook.fragments.firststart.InfoFragment;
import ru.nextgenstudio.studentsbook.fragments.firststart.ThemesFragment;
import ru.nextgenstudio.studentsbook.fragments.firststart.WelcomeFragment;
import ru.nextgenstudio.studentsbook.interfaces.FragmentCallback;
import ru.nextgenstudio.studentsbook.interfaces.SupportThemes;

public class FirstStartActivity extends AppCompatActivity implements FragmentCallback, SupportThemes{

    private static final int WELCOME_FRAGMENT = 0;
    private static final int THEMES_FRAGMENT = 1;
    private static final int INFO_FRAGMENT = 2;

    WelcomeFragment welcomeFragment;
    ThemesFragment themesFragment;
    InfoFragment infoFragment;

    FragmentManager fm;

    Bundle welcomeArgs, themesArgs, infoArgs;

    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sp = getSharedPreferences("user_settings", MODE_PRIVATE);
        initTheme(sp);
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

    void initTheme(SharedPreferences sp){
        if (sp.getInt("current_theme", 1) == THEME_RED){
            setTheme(R.style.AppTheme_Red);
        }else if (sp.getInt("current_theme", 1) == THEME_ORANGE){
            setTheme(R.style.AppTheme_Orange);
        }else if (sp.getInt("current_theme", 1) == THEME_AMBER){
            setTheme(R.style.AppTheme_Amber);
        }else if (sp.getInt("current_theme", 1) == THEME_PURPLE){
            setTheme(R.style.AppTheme_Purple);
        }else if (sp.getInt("current_theme", 1) == THEME_INDIGO){
            setTheme(R.style.AppTheme_Indigo);
        }else if (sp.getInt("current_theme", 1) == THEME_BLUE){
            setTheme(R.style.AppTheme_Blue);
        }else if (sp.getInt("current_theme", 1) == THEME_PINK){
            setTheme(R.style.AppTheme_Pink);
        }else if (sp.getInt("current_theme", 1) == THEME_GREEN){
            setTheme(R.style.AppTheme_Green);
        }else if (sp.getInt("current_theme", 1) == THEME_LIME){
            setTheme(R.style.AppTheme_Lime);
        }else if (sp.getInt("current_theme", 1) == THEME_GREY){
            setTheme(R.style.AppTheme_Grey);
        }else if (sp.getInt("current_theme", 1) == THEME_BLUE_GREY){
            setTheme(R.style.AppTheme_BlueGrey);
        }else if (sp.getInt("current_theme", 1) == THEME_CYAN){
            setTheme(R.style.AppTheme_Cyan);
        }
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
