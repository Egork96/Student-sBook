package ru.nextgenstudio.studentsbook;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;

import ru.nextgenstudio.studentsbook.interfaces.SupportThemes;

public class SplashActivity extends Activity implements SupportThemes{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences sp = getSharedPreferences("user_settings", MODE_PRIVATE);
        initTheme(sp);
        setContentView(R.layout.activity_splash);

        if (sp.getBoolean("firstStart", true)){
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent(getApplicationContext(), FirstStartActivity.class));
                }
            }, 1500);
        }else {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                }
            }, 1500);
        }
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
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
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
