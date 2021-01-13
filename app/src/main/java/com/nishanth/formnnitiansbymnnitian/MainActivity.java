package com.nishanth.formnnitiansbymnnitian;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.navigation.NavigationView;
import com.nishanth.formnnitiansbymnnitian.ebooks.ebooks;

import java.util.Objects;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    private BottomNavigationView bottomNavigationView;
    private NavController navController;
    private DrawerLayout drawerlayout;
    private ActionBarDrawerToggle toggle;
    private NavigationView navigationview;

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private int checkedItem;
    private String selected;
    private final String CHECKEDITEM ="checked_item";
    private LinearLayout deptsdisplay;



    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView=findViewById(R.id.bottomNavigationView);
        deptsdisplay=findViewById(R.id.deptsdisplay);
        navController= Navigation.findNavController(this, R.id.frame_layout);
        sharedPreferences=this.getSharedPreferences("themes", Context.MODE_PRIVATE);
        editor=sharedPreferences.edit();

        switch(getcheckedItem())
        {
            case 0:
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
                break;
            case 1:
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                break;
            case 2:
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                break;
        }

        drawerlayout=findViewById(R.id.drawerlayout);
        navigationview=findViewById(R.id.navigation_view);
        toggle=new ActionBarDrawerToggle(this, drawerlayout, R.string.start, R.string.close);
        drawerlayout.addDrawerListener(toggle);
        toggle.syncState();
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        navigationview.setNavigationItemSelectedListener(this);

        NavigationUI.setupWithNavController(bottomNavigationView, navController);


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

       if(toggle.onOptionsItemSelected(item))
       {
           return true;
       }
     return true;

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch(item.getItemId())
        {
            case  R.id.navigation_developer:
                Intent developerintent=new Intent(this, developer.class);
                startActivity(developerintent);
                break;

            case  R.id.navigation_video:
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/channel/UCqoX_aJS-33d15ypYZLXraA"));
                intent.setPackage("com.google.android.youtube");

                startActivity(intent);
                break;

            case  R.id.navigation_ebook:
                startActivity(new Intent(this, ebooks.class ));
                break;

            case  R.id.navigation_rate:
               Intent rateintent =new Intent(MainActivity.this, feedbackactivity.class);
               startActivity(rateintent);

                break;

            case  R.id.navigation_share:
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBody = "An app that displays basic info about MNNIT and this application link is avaliable at : "+"https://1drv.ms/u/s!AtYv-8jaxllSgroQuUUngagras83ig?e=Rkvk0J";
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "MNNIT-User App");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(sharingIntent, "Share via"));
                break;

            case  R.id.navigation_theme:
                showDialog();
                break;

            case  R.id.navigation_website:
                Intent websiteintent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.mnnit.ac.in/"));


                startActivity(websiteintent);
                break;




        }
        return true;

    }

    private void showDialog() {

        final String[] themes=this.getResources().getStringArray(R.array.theme);
        MaterialAlertDialogBuilder builder=new MaterialAlertDialogBuilder(this);
        builder.setTitle("Select Theme");
        builder.setSingleChoiceItems(R.array.theme, getcheckedItem(), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                    checkedItem=which;
                    selected=themes[which];

            }
        });
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(selected==null)
                {
                    selected=themes[which];
                    checkedItem=which;
                }

                switch(selected)
                {
                    case "System Default":
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
                        break;
                    case "Dark":
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                        break;
                    case "Light":
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                        break;
                }
                setcheckedItem(checkedItem);
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                     dialog.dismiss();
            }
        });

        AlertDialog dialog=builder.create();
        dialog.show();
    }

    private int getcheckedItem()
    {


    return sharedPreferences.getInt(CHECKEDITEM, 0);
    }
    private void setcheckedItem(int i)
    {

        editor.putInt(CHECKEDITEM, i);

        editor.apply();
    }

    @Override
    public void onBackPressed() {

        if(drawerlayout.isDrawerOpen(GravityCompat.START))
        {
            drawerlayout.closeDrawer(GravityCompat.START);
        }
        else
        super.onBackPressed();
    }
}