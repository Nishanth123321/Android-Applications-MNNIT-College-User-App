package com.nishanth.formnnitiansbymnnitian.ui.faculty;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.nishanth.formnnitiansbymnnitian.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class TeacherAdapter extends RecyclerView.Adapter<TeacherAdapter.TeacherViewAdapter>{
    private List<TeacherData> list;
    private Context context;
    private String department;

    public TeacherAdapter(List<TeacherData> teacherdata, Context context, String department) {
        this.list = teacherdata;
        this.context = context;
        this.department=department;
    }

    @NonNull
    @Override
    public TeacherViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.faculty_item_layout, parent, false);

        return new TeacherViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final TeacherViewAdapter holder, int position) {

        final TeacherData item=list.get(position);
        holder.name.setText(item.getName());
        holder.post.setText(item.getPost());
        holder.email.setText(item.getEmail());

        try {
            Picasso.get().load(item.getImageUrl()).placeholder(R.drawable.avatar_profile).into(holder.imageView);
        }catch (Exception e)
        {
         e.printStackTrace();
        }




    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class TeacherViewAdapter extends RecyclerView.ViewHolder {

        private TextView name, email, post;
        private Button updateinfo;
        private ImageView imageView;
        public TeacherViewAdapter(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.teacherName);
            email=itemView.findViewById(R.id.teacherEmail);
            post=itemView.findViewById(R.id.teacherPost);

            imageView=itemView.findViewById(R.id.teacherImage);



        }
    }
}
