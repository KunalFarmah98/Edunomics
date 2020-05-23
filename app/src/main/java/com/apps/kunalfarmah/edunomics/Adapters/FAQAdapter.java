package com.apps.kunalfarmah.edunomics.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.util.Pair;
import androidx.recyclerview.widget.RecyclerView;

import com.apps.kunalfarmah.edunomics.R;
import com.apps.kunalfarmah.edunomics.ui.FAQActivity;

import java.util.ArrayList;

public class FAQAdapter extends RecyclerView.Adapter<FAQAdapter.FAQViewHolder> {

    ArrayList<Pair<String, String>> data;
    Context mContext;

    public FAQAdapter(Context context, ArrayList<Pair<String, String>> list) {
        mContext = context;
        data = list;
    }

    @NonNull
    @Override
    public FAQViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.faq_list_item, parent, false);
        return new FAQViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final FAQViewHolder holder, int position) {
        String title = data.get(position).first;
        String info = data.get(position).second;
        holder.title.setText(title);
        holder.expanded.setText(info);
        holder.expanded.setVisibility(View.GONE);

        // animating expansion and collapse of textview
        holder.ly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (holder.expanded.getVisibility() == View.GONE) {
                    FAQActivity.expand(holder.expanded);
                } else {
                    FAQActivity.collapse(holder.expanded);
                }
            }
        });
        holder.expand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (holder.expanded.getVisibility() == View.GONE)
                    holder.expanded.setVisibility(View.VISIBLE);
                else holder.expanded.setVisibility(View.GONE);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class FAQViewHolder extends RecyclerView.ViewHolder {
        TextView title, expanded;
        ImageButton expand;
        LinearLayout ly;

        public FAQViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            expanded = itemView.findViewById(R.id.expanded);
            expand = itemView.findViewById(R.id.expand);
            ly = itemView.findViewById(R.id.ques);
        }
    }
}
