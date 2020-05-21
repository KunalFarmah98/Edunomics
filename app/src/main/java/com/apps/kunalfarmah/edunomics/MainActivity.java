package com.apps.kunalfarmah.edunomics;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private AppBarConfiguration mAppBarConfiguration;
    DrawerLayout drawer;

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        androidx.appcompat.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayOptions(actionBar.getDisplayOptions()
                | ActionBar.DISPLAY_SHOW_CUSTOM);
        ImageView imageView = new ImageView(actionBar.getThemedContext());
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setImageResource(R.drawable.logo);
        ActionBar.LayoutParams layoutParams = new ActionBar.LayoutParams(
                ActionBar.LayoutParams.WRAP_CONTENT,
                ActionBar.LayoutParams.WRAP_CONTENT, Gravity.RIGHT
                | Gravity.CENTER_VERTICAL);
        layoutParams.rightMargin = 40;
        imageView.setLayoutParams(layoutParams);
        actionBar.setCustomView(imageView);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        BottomNavigationView bottomNavView=findViewById(R.id.bottom_nav);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_initiatives, R.id.nav_impact, R.id.nav_opportunities)
                .setDrawerLayout(drawer)
                .build();

        NavController navController = Navigation.findNavController(this, R.id.nav_host);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        //NavigationUI.setupWithNavController(navigationView, navController);
        NavigationUI.setupWithNavController(bottomNavView, navController);

        navigationView.setNavigationItemSelectedListener(this);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if(drawer.isDrawerOpen(GravityCompat.START))
            drawer.closeDrawer(GravityCompat.START);

        switch (item.getItemId()){
            case R.id.nav_about:
                Toast.makeText(this,"About",Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_FAQs:
                Toast.makeText(this,"FAQ",Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_Blog:
                Toast.makeText(this,"Blog",Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_Wenestor:
                Toast.makeText(this,"Wenester",Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

//    @Override
//    public boolean onSupportNavigateUp() {
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
//        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
//                || super.onSupportNavigateUp();
//    }
}
