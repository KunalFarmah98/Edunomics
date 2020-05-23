package com.apps.kunalfarmah.edunomics.ui;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.apps.kunalfarmah.edunomics.Chat.ChatActivity;
import com.apps.kunalfarmah.edunomics.R;
import com.apps.kunalfarmah.edunomics.ui.AboutUs;
import com.apps.kunalfarmah.edunomics.ui.BlogActivity;
import com.apps.kunalfarmah.edunomics.ui.FAQActivity;
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
        /**
         *  Setting Edunomics Logo in Action Bar
         **/
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
        BottomNavigationView bottomNavView = findViewById(R.id.bottom_nav);

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
        NavigationUI.setupWithNavController(bottomNavView, navController);

        navigationView.setNavigationItemSelectedListener(this);




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if (drawer.isDrawerOpen(GravityCompat.START))
            drawer.closeDrawer(GravityCompat.START);

        switch (item.getItemId()) {
            case R.id.nav_about:
                startActivity(new Intent(this, AboutUs.class));
                break;
            case R.id.nav_FAQs:
                startActivity(new Intent(this, FAQActivity.class));
                break;
            case R.id.nav_Blog:
                startActivity(new Intent(this, BlogActivity.class));
                break;
            case R.id.nav_Wenestor:
                Uri uri = Uri.parse("http://wenestor.herokuapp.com/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                break;
            case R.id.nav_trynalpha:
                uri = Uri.parse("https://edunomics.in/login");
                intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                break;
            case R.id.nav_privacypolicy:
                Toast.makeText(this, "Privacy Policy will appear here (not available on website", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_termsofuse:
                Toast.makeText(this, "Terms of Use will appear here (not available on website", Toast.LENGTH_SHORT).show();

                break;
            case R.id.nav_joinus:
                uri = Uri.parse("https://edunomics.in/applynow");
                intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);

                break;
            case R.id.nav_Tech:
                uri = Uri.parse("http://tech.edunomics.in/");
                intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                break;

            case R.id.nav_chat:
                startActivity(new Intent(this, ChatActivity.class));

        }
        return true;
    }

}
