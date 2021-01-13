package com.nishanth.formnnitiansbymnnitian.ebooks;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nishanth.formnnitiansbymnnitian.R;

import java.util.List;

public class EbookAdapter extends RecyclerView.Adapter<EbookAdapter.EbookViewAdapter> {


    private Context context;
    private List<EbookData> list;

    public EbookAdapter(Context context, List<EbookData> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public EbookViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(context).inflate(R.layout.ebook_item_layout, parent, false);
        return new EbookViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EbookViewAdapter holder, final int position) {

        String text=list.get(position).getPdfTitle();

        holder.booktitle.setText(text);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(context, PdfViewer.class);
                intent.putExtra("PdfUrl", list.get(position).getPdfUrl());
                context.startActivity(intent);



            }
        });
        holder.ebookdownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               Intent intent= new Intent (Intent.ACTION_VIEW);
               intent.setData(Uri.parse(list.get(position).getPdfUrl()));
               context.startActivity(intent);



            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class EbookViewAdapter extends RecyclerView.ViewHolder{

         TextView booktitle;
         ImageView ebookdownload;
        public EbookViewAdapter(@NonNull View itemView) {
            super(itemView);
            booktitle=itemView.findViewById(R.id.booktitle);
            ebookdownload=itemView.findViewById(R.id.ebookdownload);


        }
    }
}
