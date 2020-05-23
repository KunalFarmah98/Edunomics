package com.apps.kunalfarmah.edunomics.Chat;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.apps.kunalfarmah.edunomics.R;
import com.bumptech.glide.Glide;

import java.util.List;

public class MessageAdapter extends ArrayAdapter<FriendlyMessage> {
    public MessageAdapter(Context context, int resource, List<FriendlyMessage> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = ((Activity) getContext()).getLayoutInflater().inflate(R.layout.item_message, parent, false);
        }

        ImageView photoImageView = convertView.findViewById(R.id.photoImageView);
        TextView um = convertView.findViewById(R.id.messageUser);
        TextView bm = convertView.findViewById(R.id.messageBearer);
        TextView userTextView = convertView.findViewById(R.id.usernameTextView);
        TextView bearerTextView = convertView.findViewById(R.id.bearernameTextView);

        FriendlyMessage message = getItem(position);

        boolean isPhoto = message.getPhotoUrl() != null;
        if (isPhoto) {
            um.setVisibility(View.GONE);
            bm.setVisibility(View.GONE);
            photoImageView.setVisibility(View.VISIBLE);
            Glide.with(photoImageView.getContext())
                    .load(message.getPhotoUrl())
                    .into(photoImageView);
        } else {
            if (message.getName().equals(ChatActivity.mFirebaseAuth.getCurrentUser().getDisplayName())) {
                um.setVisibility(View.VISIBLE);
                userTextView.setVisibility(View.VISIBLE);
                photoImageView.setVisibility(View.GONE);
                bm.setVisibility(View.GONE);
                bearerTextView.setVisibility(View.GONE);
                um.setText(message.getText());
                userTextView.setText(message.getName());
            } else {
                bm.setVisibility(View.VISIBLE);
                bearerTextView.setVisibility(View.VISIBLE);
                photoImageView.setVisibility(View.GONE);
                um.setVisibility(View.GONE);
                userTextView.setVisibility(View.GONE);
                bm.setText(message.getText());
                bearerTextView.setText(message.getName());
            }
        }


        return convertView;
    }
}
