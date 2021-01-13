package com.nishanth.formnnitiansbymnnitian;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class feedbackactivity extends AppCompatActivity {


    private EditText feedbackUserName, feedbackEmailName, feedbackRate, feedbackDesc;

    private Button feedbackBack,feedbackSubmit;
    private ImageView feedbackImage;
    private DrawerLayout drawerlayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedbackactivity);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("You give feedback-We learn");
      drawerlayout=findViewById(R.id.drawerlayout);

        feedbackUserName=findViewById(R.id.feedbackUserName);
        feedbackEmailName=findViewById(R.id.feedbackEmailName);
        feedbackRate=findViewById(R.id.feedbackRate);
        feedbackDesc=findViewById(R.id.feedbackDesc);
        feedbackSubmit=findViewById(R.id.feedbackSubmit);
        feedbackBack=findViewById(R.id.feedbackBack);
        feedbackImage=findViewById(R.id.feedbackImage);
        Picasso.get().load(R.drawable.namaste).into(feedbackImage);

        feedbackBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Intent intent=new Intent(feedbackactivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);

            }
        });

        feedbackSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                checkvalidation();



            }
        });




    }

    private void checkvalidation() {

        String name=feedbackUserName.getText().toString();
        String  email=feedbackEmailName.getText().toString();
        String description=feedbackDesc.getText().toString();
        String rating=feedbackRate.getText().toString();
        if(name.isEmpty())
        {
            feedbackUserName.setError("Can't be empty");
            feedbackUserName.requestFocus();
        }
        else if(email.isEmpty())
        {
            feedbackEmailName.setError("Can't be empty");
            feedbackEmailName.requestFocus();
        }

        else if(description.isEmpty())
        {
            feedbackDesc.setError("Can't be empty");
            feedbackDesc.requestFocus();
        }
        else if(rating.isEmpty())
        {
            feedbackRate.setError("Can't be empty");
            feedbackRate.requestFocus();

        }
        else if(Integer.parseInt(rating)>5 || Integer.parseInt(rating)<0)
        {
            feedbackRate.setError("Not a valid input");
            feedbackRate.requestFocus();
        }
        else
        {
            Toast.makeText(feedbackactivity.this, "Your response has been submitted successfully..!", Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(feedbackactivity.this, MainActivity.class);

            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }


    }
}