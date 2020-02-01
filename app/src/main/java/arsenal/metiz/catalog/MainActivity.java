package arsenal.metiz.catalog;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.Objects;

import arsenal.metiz.catalog.ui.main.SectionsPagerAdapter;

public class MainActivity extends AppCompatActivity {

    final String sPrefName = "My_Pref";
    final String SAVED_STATE = "request_counter";
    final String INITIALISATION = "initialisation";
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme_NoActionBar);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        FloatingActionButton fab = findViewById(R.id.fab);
        FloatingActionButton fabS = findViewById(R.id.fabS);



        sharedPreferences = getSharedPreferences(sPrefName, MODE_PRIVATE);
        String setup = sharedPreferences.getString(INITIALISATION,"");
        if (!Objects.equals(setup, "Initialised")){
            SharedPreferences.Editor edit = sharedPreferences.edit().clear();
            edit.apply();
            SharedPreferences.Editor ed = sharedPreferences.edit();
            ed.putInt(SAVED_STATE,0);
            ed.putString(INITIALISATION,"Initialised");
            ed.apply();
        }


        fab.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, RequestActivity.class);
            intent.putExtra("Title","СВ-");
            startActivity(intent);
        });
        fabS.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, BarcodeScanActivity.class);
            startActivity(intent);
        });
    }
}