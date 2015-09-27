package ru.nextgenstudio.studentsbook;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

public class MainActivity extends AppCompatActivity {

    private final static int DRAWER_ITEM_MAIN = 1;
    private final static int DRAWER_ITEM_CALENDAR = 2;
    private final static int DRAWER_ITEM_SCHEDULE = 3;
    private final static int DRAWER_ITEM_SETTINGS = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null){
            setSupportActionBar(toolbar);
        }

        initializeNavDrawer(toolbar);
    }

    void initializeNavDrawer(Toolbar toolbar){

        new DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)
                .withActionBarDrawerToggleAnimated(true)

                .addDrawerItems(
                        new PrimaryDrawerItem()
                                .withName(R.string.drawer_main)
                                .withIdentifier(DRAWER_ITEM_MAIN),
                        new PrimaryDrawerItem()
                                .withName(R.string.drawer_calendar)
                                .withIdentifier(DRAWER_ITEM_CALENDAR),
                        new PrimaryDrawerItem()
                                .withName(R.string.drawer_schedule)
                                .withIdentifier(DRAWER_ITEM_SCHEDULE),
                        new DividerDrawerItem(),
                        new PrimaryDrawerItem()
                                .withName(R.string.drawer_settings)
                                .withIdentifier(DRAWER_ITEM_SETTINGS)
                )

                .withOnDrawerItemClickListener(drawerItemClickListener)
                .build();
    }

    Drawer.OnDrawerItemClickListener drawerItemClickListener = new Drawer.OnDrawerItemClickListener() {
        @Override
        public boolean onItemClick(View view, int i, IDrawerItem iDrawerItem) {

            switch (iDrawerItem.getIdentifier()){
                case DRAWER_ITEM_MAIN:
                    break;
                case DRAWER_ITEM_CALENDAR:
                    break;
                case DRAWER_ITEM_SCHEDULE:
                    break;
                case DRAWER_ITEM_SETTINGS:
                    startActivity(new Intent(getApplicationContext(), SettingsActivity.class));
                    break;
            }

            return false;
        }
    };

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
