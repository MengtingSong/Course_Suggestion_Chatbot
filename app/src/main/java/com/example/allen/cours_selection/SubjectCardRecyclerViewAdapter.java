package com.example.allen.cours_selection;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.allen.cours_selection.network.ImageRequester;
import com.example.allen.cours_selection.network.SubjectEntry;

import java.util.List;

/**
 * Adapter used to show a simple grid of products.
 */
public class SubjectCardRecyclerViewAdapter extends RecyclerView.Adapter<SubjectCardViewHolder> {

    private List<SubjectEntry> subjectList;
    private ImageRequester imageRequester;

    SubjectCardRecyclerViewAdapter(List<SubjectEntry> subjectList) {
        this.subjectList = subjectList;
        imageRequester = ImageRequester.getInstance();
    }

    @NonNull
    @Override
    public SubjectCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.subject_card, parent, false);
        return new SubjectCardViewHolder(layoutView);
    }

    @Override
    public void onBindViewHolder(@NonNull SubjectCardViewHolder holder, int position) {
        if (subjectList != null && position < subjectList.size()) {
            SubjectEntry subject = subjectList.get(position);
            holder.subjectTitle.setText(subject.title);
            holder.subjectDetail.setText(subject.detail);
            imageRequester.setImageFromUrl(holder.subjectImage, subject.url);
        }
    }

    @Override
    public int getItemCount() {
        return subjectList.size();
    }
}
