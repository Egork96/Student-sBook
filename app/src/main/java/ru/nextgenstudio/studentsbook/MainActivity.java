package ru.nextgenstudio.studentsbook;

import android.app.FragmentManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import ru.nextgenstudio.studentsbook.fragments.CalendarFragment;
import ru.nextgenstudio.studentsbook.fragments.MainFragment;
import ru.nextgenstudio.studentsbook.fragments.ScheduleFragment;
import ru.nextgenstudio.studentsbook.interfaces.SupportThemes;

public class MainActivity extends AppCompatActivity implements SupportThemes{

    private final static int DRAWER_ITEM_MAIN = 1;
    private final static int DRAWER_ITEM_CALENDAR = 2;
    private final static int DRAWER_ITEM_SCHEDULE = 3;
    private final static int DRAWER_ITEM_SETTINGS = 4;
    private final static int DRAWER_ITEM_ABOUT = 5;

    FrameLayout cont;
    FragmentManager fm;

    MainFragment mFrag;
    CalendarFragment cFrag;
    ScheduleFragment sFrag;

    Drawer drawer;

    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sp = getSharedPreferences("user_settings", MODE_PRIVATE);
        initTheme(sp);
        setContentView(R.layout.activity_main);

        cont = (FrameLayout) findViewById(R.id.container);
        fm = getFragmentManager();

        mFrag = new MainFragment();
        cFrag = new CalendarFragment();
        sFrag = new ScheduleFragment();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null){
            setSupportActionBar(toolbar);
        }

        initializeNavDrawer(toolbar);
        fm.beginTransaction().add(R.id.container, mFrag).commit();
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


    void initializeNavDrawer(Toolbar toolbar){

        drawer = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)
                .withActionBarDrawerToggleAnimated(true)
                .withDisplayBelowStatusBar(false)
                .withHeader(R.layout.drawer_header)

                .addDrawerItems(
                        new PrimaryDrawerItem()
                                .withName(R.string.drawer_main)
                                .withIdentifier(DRAWER_ITEM_MAIN)
                                .withIcon(R.drawable.ic_event_available_black_36dp),
                        new PrimaryDrawerItem()
                                .withName(R.string.drawer_calendar)
                                .withIdentifier(DRAWER_ITEM_CALENDAR)
                                .withIcon(R.drawable.ic_perm_contact_calendar_black_36dp),
                        new PrimaryDrawerItem()
                                .withName(R.string.drawer_schedule)
                                .withIdentifier(DRAWER_ITEM_SCHEDULE)
                                .withIcon(R.drawable.ic_schedule_black_36dp),
                        new DividerDrawerItem(),
                        new PrimaryDrawerItem()
                                .withName(R.string.drawer_settings)
                                .withIdentifier(DRAWER_ITEM_SETTINGS)
                                .withIcon(R.drawable.ic_settings_black_36dp),
                        new PrimaryDrawerItem()
                                .withName(R.string.drawer_about)
                                .withIdentifier(DRAWER_ITEM_ABOUT)
                                .withIcon(R.drawable.ic_info_black_36dp)
                )

                .withOnDrawerItemClickListener(drawerItemClickListener)
                .build();
    }

    Drawer.OnDrawerItemClickListener drawerItemClickListener = new Drawer.OnDrawerItemClickListener() {
        @Override
        public boolean onItemClick(View view, int i, IDrawerItem iDrawerItem) {

            switch (iDrawerItem.getIdentifier()){
                case DRAWER_ITEM_MAIN:
                    fm.beginTransaction().replace(R.id.container, mFrag).commit();
                    break;
                case DRAWER_ITEM_CALENDAR:
                    fm.beginTransaction().replace(R.id.container, cFrag).commit();
                    break;
                case DRAWER_ITEM_SCHEDULE:
                    fm.beginTransaction().replace(R.id.container, sFrag).commit();
                    break;
                case DRAWER_ITEM_SETTINGS:
                    startActivity(new Intent(getApplicationContext(), SettingsActivity.class));
                    break;
            }

            return false;
        }
    };

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen()){
            drawer.closeDrawer();
        }else{
            return;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
