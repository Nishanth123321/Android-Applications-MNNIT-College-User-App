package com.nishanth.formnnitiansbymnnitian.ui.gallery;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.nishanth.formnnitiansbymnnitian.R;

import java.util.ArrayList;
import java.util.List;


public class GalleryFragment extends Fragment {



    private RecyclerView convorecycler, independencerecycler, othersrecycler;

    private GalleryAdapter adapter;
    private DatabaseReference reference, dbRef;
    private List<String> list1, list2, list3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_gallery, container, false);

        convorecycler=view.findViewById(R.id.convorecycler);
        independencerecycler=view.findViewById(R.id.independencerecycler);
        othersrecycler=view.findViewById(R.id.othersrecycler);
           reference= FirebaseDatabase.getInstance().getReference().child("Gallery");
           fillConvocation();
           fillindependence();
           fillOthers();

        return view;
    }

    private void fillOthers() {

        reference.child("Other Events").addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                list3=new ArrayList<>();
                for(DataSnapshot dataSnapshot : snapshot.getChildren())
                {
                    String data=(String)dataSnapshot.getValue().toString();
                    list3.add(data);

                }

                othersrecycler.setHasFixedSize(true);
                othersrecycler.setLayoutManager(new GridLayoutManager(getContext(), 3));
                adapter=new GalleryAdapter(getContext(), list3);


                othersrecycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void fillindependence() {


        reference.child("Independence day").addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list2=new ArrayList<>();

                for(DataSnapshot dataSnapshot : snapshot.getChildren())
                {
                    String data=dataSnapshot.getValue().toString();
                    list2.add(data);
                }
                independencerecycler.setHasFixedSize(true);
                independencerecycler.setLayoutManager(new GridLayoutManager(getContext(), 3));
                adapter=new GalleryAdapter(getContext(), list2);


                independencerecycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void fillConvocation() {



        reference.child("Convocation").addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list1=new ArrayList<>();

                for(DataSnapshot dataSnapshot : snapshot.getChildren())
                {
                    String data=dataSnapshot.getValue().toString();
                    list1.add(data);
                    //Toast.makeText(getContext(), data, Toast.LENGTH_SHORT).show();
                }

               convorecycler.setHasFixedSize(true);
                convorecycler.setLayoutManager(new GridLayoutManager(getContext(), 3));
                adapter=new GalleryAdapter(getContext(), list1);


                convorecycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}