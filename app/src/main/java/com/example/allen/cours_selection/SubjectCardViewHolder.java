package com.example.allen.cours_selection;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;


public class SubjectCardViewHolder extends RecyclerView.ViewHolder {

    public NetworkImageView subjectImage;
    public TextView subjectTitle;
    public TextView subjectDetail;

    public SubjectCardViewHolder(@NonNull View itemView) {
        super(itemView);
        subjectImage = itemView.findViewById(R.id.subject_image);
        subjectTitle = itemView.findViewById(R.id.subject_title);
        subjectDetail = itemView.findViewById(R.id.subject_detail);
    }
}