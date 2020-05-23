package com.apps.kunalfarmah.edunomics.Chat;


import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.apps.kunalfarmah.edunomics.R;
import com.bumptech.glide.Glide;

import java.util.ArrayList;


public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageViewHolder> {
    private Context mContext;
    public ArrayList<FriendlyMessage> list;

    public MessageAdapter(Context context, ArrayList<FriendlyMessage> objects) {
        mContext = context;
        list = objects;
    }

    @NonNull
    @Override
    public MessageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_message, parent, false);
        return new MessageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MessageViewHolder holder, int position) {
        FriendlyMessage message = list.get(position);
        holder.um.setVisibility(View.GONE);
        holder.bm.setVisibility(View.GONE);
        holder.bearerTextView.setVisibility(View.GONE);
        holder.userTextView.setVisibility(View.GONE);
        boolean isPhoto = message.getPhotoUrl() != null;
        if (isPhoto) {
            if (message.getName() .equals(ChatActivity.mFirebaseAuth.getCurrentUser().getDisplayName())){
                holder.userTextView.setText(message.getName());
                holder.userTextView.setVisibility(View.VISIBLE);
                holder.userTextView.setGravity(Gravity.END);
                holder.bearerTextView.setVisibility(View.GONE);
            } else {
                holder.bearerTextView.setText(message.getName());
                holder.bearerTextView.setVisibility(View.VISIBLE);
                holder.bearerTextView.setGravity(Gravity.START);
                holder.userTextView.setVisibility(View.GONE);
            }
            holder.photoImageView.setVisibility(View.VISIBLE);
            Glide.with(mContext)
                    .load(message.getPhotoUrl())
                    .into(holder.photoImageView);
        } else {
            if (message.getName().equals(ChatActivity.mFirebaseAuth.getCurrentUser().getDisplayName())) {
                holder.um.setText(message.getText());
                holder.um.setVisibility(View.VISIBLE);
                holder.um.setGravity(Gravity.END);
                holder.userTextView.setText(message.getName());
                holder.userTextView.setVisibility(View.VISIBLE);
                holder.userTextView.setGravity(Gravity.END);

                holder.photoImageView.setVisibility(View.GONE);
                holder.bm.setVisibility(View.GONE);
                holder.bearerTextView.setVisibility(View.GONE);

            } else {
                holder.bm.setText(message.getText());
                holder.bm.setVisibility(View.VISIBLE);
                holder.bm.setGravity(Gravity.START);
                holder.bearerTextView.setText(message.getName());
                holder.bearerTextView.setVisibility(View.VISIBLE);
                holder.bearerTextView.setGravity(Gravity.START);

                holder.photoImageView.setVisibility(View.GONE);
                holder.um.setVisibility(View.GONE);
                holder.userTextView.setVisibility(View.GONE);

            }
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MessageViewHolder extends RecyclerView.ViewHolder {
        ImageView photoImageView;
        TextView um;
        TextView bm;
        TextView userTextView;
        TextView bearerTextView;

        public MessageViewHolder(@NonNull View itemView) {
            super(itemView);
            photoImageView = itemView.findViewById(R.id.photoImageView);
            um = itemView.findViewById(R.id.messageUser);
            bm = itemView.findViewById(R.id.messageBearer);
            userTextView = itemView.findViewById(R.id.usernameTextView);
            bearerTextView = itemView.findViewById(R.id.bearernameTextView);
        }
    }
}
