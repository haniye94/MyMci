package com.hani.mymci;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class recyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private ArrayList<MessageModel> messageModelArrayList;

    public recyclerAdapter(Context context, ArrayList<MessageModel> movieModelArrayList) {

        this.context = context;
        this.messageModelArrayList = movieModelArrayList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_items, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        MovieViewHolder viewholder = (MovieViewHolder) holder;
        viewholder.onBind();
    }

    @Override
    public int getItemCount() {
        return messageModelArrayList.size();

    }


    public class MovieViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgMessage;
        private TextView txtTitle;
        private TextView txtDescription;
        private boolean unread;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);

            txtTitle = itemView.findViewById(R.id.txt_title);
            txtDescription = itemView.findViewById(R.id.txt_desc);

        }

        public void onBind() {

            txtTitle.setText(messageModelArrayList.get(getAdapterPosition()).getTitle());
            txtDescription.setText(messageModelArrayList.get(getAdapterPosition()).getDescription());
        }
    }
}
