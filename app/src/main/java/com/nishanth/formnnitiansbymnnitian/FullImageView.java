package com.nishanth.formnnitiansbymnnitian;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.github.chrisbanes.photoview.PhotoView;
import com.squareup.picasso.Picasso;

public class FullImageView extends AppCompatActivity {

    private PhotoView fullimage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_image_view);
        fullimage=findViewById(R.id.fullimage);
        String imageurl=getIntent().getStringExtra("imageurl");

        try {
        Picasso.get().load(imageurl).into(fullimage);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}