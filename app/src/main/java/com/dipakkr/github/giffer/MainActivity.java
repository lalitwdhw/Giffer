package com.dipakkr.github.giffer;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.dipakkr.github.giffer.activity.GifActivity;
import com.dipakkr.github.giffer.adapter.SimpleAdapter;
import com.dipakkr.github.giffer.helper.FontOverride;

import java.lang.reflect.Field;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    DrawerLayout drawerLayout;
    SearchView searchView;
    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FontOverride.setDefaultFont(this, "MONOSPACE", "my_font.ttf");
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        viewPager = (ViewPager)findViewById(R.id.viewpager);
        tabLayout = (TabLayout)findViewById(R.id.tabs);
        SimpleAdapter adapter = new SimpleAdapter(getApplicationContext(),getSupportFragmentManager());
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        viewPager.setAdapter(adapter);


        drawerLayout = (DrawerLayout)findViewById(R.id.drawer);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView)findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {


        int id = item.getItemId();
        drawerLayout = (DrawerLayout)findViewById(R.id.drawer);

        switch (id){

            case R.id.nav_wallpaper :

                Intent intent = new Intent(MainActivity.this, GifActivity.class);
                startActivity(intent);
                break;

            case R.id.nav_gif :


            case R.id.nav_fav:
                break;

            case R.id.nav_tags :
                break;

            case R.id.nav_send :
                break;

            case  R.id.nav_setting :
                return true;

            case R.id.nav_about :
                break;
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_action,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.movie_search){

        }

        return super.onOptionsItemSelected(item);
    }

}
