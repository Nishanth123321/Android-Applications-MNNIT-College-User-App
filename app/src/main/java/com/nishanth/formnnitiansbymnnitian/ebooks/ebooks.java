package com.nishanth.formnnitiansbymnnitian.ebooks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.nishanth.formnnitiansbymnnitian.R;

import java.util.ArrayList;
import java.util.List;

public class ebooks extends AppCompatActivity {


    private RecyclerView ebookrecycler;
    private DatabaseReference reference;
    private List<EbookData> list;
    private EbookAdapter adapter;
    private ShimmerFrameLayout container;
    private LinearLayout shimmer_layout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ebooks);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Ebooks");
        ebookrecycler=findViewById(R.id.ebookrecycler);
        container=(ShimmerFrameLayout) findViewById(R.id.shimmer_view_container);
        shimmer_layout=findViewById(R.id.shimmer_layout);
        //container.startShimmer();
        filllist();


    }

    private void filllist() {

        reference= FirebaseDatabase.getInstance().getReference().child("pdf");
        reference.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list=new ArrayList<>();
                for(DataSnapshot dataSnapshot : snapshot.getChildren())
                {
                     EbookData data=dataSnapshot.getValue(EbookData.class);
                     list.add(data);
                }
                ebookrecycler.setHasFixedSize(true);
                ebookrecycler.setLayoutManager(new LinearLayoutManager(ebooks.this));
                adapter=new EbookAdapter(ebooks.this, list);
                ebookrecycler.setAdapter(adapter);
                container.stopShimmer();
                shimmer_layout.setVisibility(View.GONE);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(ebooks.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onPause() {
        container.stopShimmer();
        super.onPause();
    }

    @Override
    protected void onResume() {
        container.startShimmer();
        super.onResume();
    }
}