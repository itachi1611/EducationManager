package com.fox.namntph06792_mob201_assignment.activity;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.fox.namntph06792_mob201_assignment.R;
import com.fox.namntph06792_mob201_assignment.base.BaseActivity;

public class MainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    private TextView tvEdu;
    private TextView tvMap;
    private TextView tvNew;
    private TextView tvSocial;
    private Toolbar toolbar;
    private DrawerLayout drawer;
    private NavigationView navigationView;
    private ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar(toolbar);
        initViews();

        toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        tvEdu.setOnClickListener(this);
        tvMap.setOnClickListener(this);
        tvNew.setOnClickListener(this);
        tvSocial.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        switch (id) {
            case R.id.nav_home:
                break;
            case R.id.nav_about:
                navigateActivity(AboutActivity.class);
                break;
            case R.id.nav_setting:
                navigateActivity(SettingActivity.class);
                break;
            case R.id.nav_feedback:
                navigateActivity(FeedbackActivity.class);
                break;
            case R.id.nav_help:
                navigateActivity(HelpActivity.class);
                break;
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.tvEdu:
                navigateActivity(CourseActivity.class);
                break;
            case R.id.tvMap:
                navigateActivity(MapsActivity.class);
                break;
            case R.id.tvNew:
                navigateActivity(NewsActivity.class);
                break;
            case R.id.tvSocial:
                navigateActivity(SocialActivity.class);
                break;
        }
    }

    private void initViews(){
        tvEdu = findViewById(R.id.tvEdu);
        tvMap = findViewById(R.id.tvMap);
        tvNew = findViewById(R.id.tvNew);
        tvSocial = findViewById(R.id.tvSocial);
        toolbar = findViewById(R.id.toolbar);
        drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
    }
}
