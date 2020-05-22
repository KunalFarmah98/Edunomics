package com.apps.kunalfarmah.edunomics;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.apps.kunalfarmah.edunomics.ui.KnowMore;

import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.DataViewHolder> {
    Context mcontext;
    ArrayList<DataModel>data;
    String type;
    public DataAdapter(Context mcontext, ArrayList<DataModel> list, String type){
        this.mcontext=mcontext;
        this.data=list;
        this.type=type;
    }

    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);


        return new DataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final DataViewHolder holder, int position) {
        DataModel item = data.get(position);
        if(type=="initiatives"){
            holder.buttons.setVisibility(View.VISIBLE);
            holder.title.setVisibility(View.GONE);
            if(item.getTitle().equals("Wenestor")){
                holder.an.setVisibility(View.GONE);
                holder.km.setText("Wenestor");
            }
        }
        else holder.buttons.setVisibility(View.GONE);

        holder.img.setImageDrawable(item.getImg());
        holder.title.setText(item.getTitle());
        holder.info.setText(item.getInfo());

        holder.km.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(holder.km.getText().toString().equals("Wenestor")){
                    Uri uri = Uri.parse("http://wenestor.herokuapp.com/");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    mcontext.startActivity(intent);
                }
                else{
                    Uri uri = Uri.parse("https://edunomics.in/knowmore");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    mcontext.startActivity(intent);
                }
            }
        });

        holder.an.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://edunomics.in/applynow");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                mcontext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class DataViewHolder extends RecyclerView.ViewHolder {
        TextView title,info;
        ImageView img;
        Button km,an;
        LinearLayout buttons;
        public DataViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            info = itemView.findViewById(R.id.info);
            img = itemView.findViewById(R.id.img);
            an = itemView.findViewById(R.id.applynow);
            km = itemView.findViewById(R.id.knowmore);
            buttons = itemView.findViewById(R.id.buttons);
        }
    }
}
