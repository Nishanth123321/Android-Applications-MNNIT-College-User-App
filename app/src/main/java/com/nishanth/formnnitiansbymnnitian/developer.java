package com.nishanth.formnnitiansbymnnitian;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;



public class developer extends AppCompatActivity {


    private LinearLayout facebook, instagram, linkedin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developer);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Nishanth-MNNITian");
        facebook=findViewById(R.id.facebook);
        instagram=findViewById(R.id.instagram);
        linkedin=findViewById(R.id.linkedin);
        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                try {
                    getPackageManager().getPackageInfo("com.facebook.katana", 0);
                    String url = "https://www.facebook.com/nishanth.mekala.7";
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://facewebmodal/f?href="+url));
                    startActivity(intent);
                   }

                catch (Exception e) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/nishanth.mekala.7"));
                    startActivity(intent);
                    e.printStackTrace();
                }


            }
        });

        instagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Uri uri = Uri.parse("http://instagram.com/n_i_s_hanth/");
                Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);

                likeIng.setPackage("com.instagram.android");

                try {
                    startActivity(likeIng);
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://instagram.com/n_i_s_hanth/")));
                }



            }
        });
        linkedin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String profile_url = "https://www.linkedin.com/in/nishanth-mekala-6a1a52179/";
                try {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(profile_url));
                    intent.setPackage("com.linkedin.android");
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                } catch (Exception e) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(profile_url)));
                }


            }
        });
    }

    public static boolean isPackageInstalled(Context c, String targetPackage) {
        PackageManager pm = c.getPackageManager();
        try {
            PackageInfo info = pm.getPackageInfo(targetPackage, PackageManager.GET_META_DATA);
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
        return true;
    }
}