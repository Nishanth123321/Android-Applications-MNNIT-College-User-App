package com.nishanth.formnnitiansbymnnitian.ui.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.android.material.slider.Slider;
import com.nishanth.formnnitiansbymnnitian.R;
import com.smarteist.autoimageslider.DefaultSliderView;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderLayout;


public class HomeFragment extends Fragment {


    private SliderLayout sliderLayout;
    private ImageView mnnitgooglemap;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_home, container, false);
         mnnitgooglemap=view.findViewById(R.id.mnnitgooglemap);
        sliderLayout=view.findViewById(R.id.slider);
        sliderLayout.setIndicatorAnimation(IndicatorAnimations.FILL);
        sliderLayout.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderLayout.setScrollTimeInSec(1);

        setSliderImages();

        mnnitgooglemap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    openMap();
            }
        });

                return view;
    }

    private void openMap() {

        Uri uri=Uri.parse("geo:25.4920, 81.8639");
        Intent intent=new Intent(Intent.ACTION_VIEW, uri);

        intent.setPackage("com.google.android.apps.maps");


            startActivity(intent);


    }

    private void setSliderImages() {
        for(int i=0;i<=5;i++)
        {
            DefaultSliderView sliderView= new DefaultSliderView(getContext());
            switch(i)
            {
                case 0: sliderView.setImageDrawable(R.drawable.mnnit0);
                       break;
                case 1: sliderView.setImageDrawable(R.drawable.mnnit1);
                    break;
                case 2: sliderView.setImageDrawable(R.drawable.mnnit2);
                    break;
                case 3: sliderView.setImageDrawable(R.drawable.mnnit3);
                    break;
                case 4: sliderView.setImageDrawable(R.drawable.mnnit4);
                    break;
                case 5: sliderView.setImageDrawable(R.drawable.mnnit5);
            }
            sliderView.setImageScaleType(ImageView.ScaleType.CENTER_CROP);
            sliderLayout.addSliderView(sliderView);
        }
    }
}