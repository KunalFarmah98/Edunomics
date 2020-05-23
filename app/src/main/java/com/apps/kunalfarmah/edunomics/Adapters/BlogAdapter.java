package com.apps.kunalfarmah.edunomics.Adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.apps.kunalfarmah.edunomics.Models.BlogModel;
import com.apps.kunalfarmah.edunomics.R;

import java.util.ArrayList;

public class BlogAdapter extends RecyclerView.Adapter<BlogAdapter.BlogViewHolder> {

    Context mcontext;
    ArrayList<BlogModel> data;
    String type;

    public BlogAdapter(Context mcontext, ArrayList<BlogModel> list, String type) {
        this.mcontext = mcontext;
        this.data = list;
        this.type = type;
    }

    @NonNull
    @Override
    public BlogViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.blog_item, parent, false);
        return new BlogViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final BlogViewHolder holder, int position) {
        BlogModel item = data.get(position);
        if (item.getVidlinks().isEmpty()) {
            holder.vids.setVisibility(View.GONE);
        } else
            holder.vids.setVisibility(View.VISIBLE);

        holder.img.setImageDrawable(item.getImg());
        holder.title.setText(item.getTitle());
        holder.info.setText(item.getInfo());
        holder.date.setText(item.getDate());
        holder.stitle.setText(item.getStitle());
        ArrayList<String> links = item.getVidlinks();
        if (links.size() == 1) holder.ib2.setVisibility(View.GONE);
        final String l1 = links.get(0);
        final String l2 = links.get(1);

        holder.ib1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse(l1);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                mcontext.startActivity(intent);
            }
        });

        holder.ib2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse(l2);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                mcontext.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class BlogViewHolder extends RecyclerView.ViewHolder {
        TextView title, info, stitle, date;
        ImageView img;
        LinearLayout vids;
        ImageButton ib1, ib2;

        public BlogViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.head);
            info = itemView.findViewById(R.id.blog);
            img = itemView.findViewById(R.id.img);
            stitle = itemView.findViewById(R.id.shead);
            date = itemView.findViewById(R.id.date);
            vids = itemView.findViewById(R.id.vids);
            ib1 = itemView.findViewById(R.id.ib1);
            ib2 = itemView.findViewById(R.id.ib2);
        }
    }
}
