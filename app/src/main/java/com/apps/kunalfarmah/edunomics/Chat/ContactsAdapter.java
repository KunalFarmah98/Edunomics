package com.apps.kunalfarmah.edunomics.Chat;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.apps.kunalfarmah.edunomics.R;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ContactsViewHolder> {

    ArrayList<Contact> data;
    Context mcontext;


    public ContactsAdapter(Context context, ArrayList<Contact> users) {
        mcontext = context;
        data = users;
    }

    @NonNull
    @Override
    public ContactsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_item, parent, false);
        return new ContactsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactsViewHolder holder, int position) {
        final Contact user = data.get(position);
        holder.name.setText(user.getName());
        if (user.getImageUri() != null) {
            Glide.with(mcontext).load(user.getImageUri()).into(holder.img);
        }
        holder.contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mcontext,ChatActivity.class);
                intent.putExtra("Name",user.getName());
                mcontext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ContactsViewHolder extends RecyclerView.ViewHolder {
        CircleImageView img;
        TextView name;
        LinearLayout contact;

        public ContactsViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            name = itemView.findViewById(R.id.name);
            contact = itemView.findViewById(R.id.contact);
        }
    }
}
