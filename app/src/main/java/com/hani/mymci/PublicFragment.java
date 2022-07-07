package com.hani.mymci;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


public class PublicFragment extends Fragment {

    RecyclerView recyclerView;
    TextView textView;
    ArrayList<MessageModel> messageList;

    public PublicFragment(ArrayList<MessageModel> arrayList) {

        messageList = arrayList;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_public, container, false);
        textView = view.findViewById(R.id.txt_empty);
        recyclerView = view.findViewById(R.id.public_recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        if (messageList.isEmpty()) {
            recyclerView.setVisibility(View.GONE);
            textView.setVisibility(View.VISIBLE);
        } else {
            recyclerView.setAdapter(new recyclerAdapter(getContext(), messageList));
        }
        return view;
    }

}