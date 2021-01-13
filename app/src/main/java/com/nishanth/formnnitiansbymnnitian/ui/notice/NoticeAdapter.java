package com.nishanth.formnnitiansbymnnitian.ui.notice;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;

import com.nishanth.formnnitiansbymnnitian.FullImageView;
import com.nishanth.formnnitiansbymnnitian.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class NoticeAdapter extends RecyclerView.Adapter<NoticeAdapter.NoticeViewAdapter> {

    private Context context;
    private List<NoticeData> list;
    private String key;

    public NoticeAdapter(Context context, List<NoticeData> noticeData) {
        this.context = context;
        this.list = noticeData;


    }

    @NonNull
    @Override
    public NoticeViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.newsfeed_item_layout, parent, false);
        return new NoticeViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoticeViewAdapter holder, final int position) {
        final NoticeData ndata = list.get(position);
        try {
            if (!ndata.getImage().isEmpty())
                Picasso.get().load(ndata.getImage()).into(holder.noticeimagepreview);
        } catch (Exception e) {
            e.printStackTrace();
        }
        key = ndata.getKey();
        holder.noticetitle.setText(ndata.getTitle());
        holder.time.setText(ndata.getTime());
        holder.date.setText(ndata.getDate());

        holder.noticeimagepreview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(context, FullImageView.class);
                intent.putExtra("imageurl", ndata.getImage());
                context.startActivity(intent);

            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class NoticeViewAdapter extends RecyclerView.ViewHolder {
        private ImageView noticeimage, noticeimagepreview;
        private TextView noticetitle, time, date;


        public NoticeViewAdapter(@NonNull View itemView) {
            super(itemView);

            noticetitle = itemView.findViewById(R.id.noticetitle);

            noticeimage = itemView.findViewById(R.id.noticeimage);
            time=itemView.findViewById(R.id.time);
            date=itemView.findViewById(R.id.date);
            noticeimagepreview = itemView.findViewById(R.id.noticeimagepreview);

        }
    }
}
