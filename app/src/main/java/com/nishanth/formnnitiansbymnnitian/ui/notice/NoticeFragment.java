package com.nishanth.formnnitiansbymnnitian.ui.notice;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.nishanth.formnnitiansbymnnitian.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class NoticeFragment extends Fragment {


    private RecyclerView noticerecyclerview;
    private ProgressBar progressBar;
    private List<NoticeData> list;
    private NoticeAdapter adapter;
    private DatabaseReference reference, dbRef;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_notice, container, false);
        noticerecyclerview=view.findViewById(R.id.noticerecyclerview);
        progressBar=view.findViewById(R.id.progressBar);
        noticerecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        noticerecyclerview.setHasFixedSize(true);
        reference= FirebaseDatabase.getInstance().getReference().child("Notice");
        getNotice();

        return view;
    }

    private void getNotice() {



        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list=new ArrayList<>();
                for(DataSnapshot datasnapshot: snapshot.getChildren())
                {
                    NoticeData data=datasnapshot.getValue(NoticeData.class);
                    list.add(0,data);
                }
                if(list.size()==0)
                {
                    progressBar.setVisibility(View.GONE);
                    Toast.makeText(getContext(), "You have no notices to show. Please go back...!", Toast.LENGTH_LONG).show();



                }
                else {
                    adapter = new NoticeAdapter(getContext(), list);
                    adapter.notifyDataSetChanged();
                    progressBar.setVisibility(View.GONE);
                    noticerecyclerview.setAdapter(adapter);
                }
                }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}