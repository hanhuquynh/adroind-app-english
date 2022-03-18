package com.example.englishvocabulary.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.englishvocabulary.R;
import com.example.englishvocabulary.domains.Vocabulary;

import java.util.ArrayList;
import java.util.List;

public class VocabularyAdapter extends RecyclerView.Adapter<VocabularyAdapter.VocabularyViewHolder> {
    Context context;
    LayoutInflater layoutInflater;
    ArrayList<Vocabulary> vocabularies = new ArrayList<>();
    public static String TAG = "VocabularyAdapter";

    public VocabularyAdapter(Context context, ArrayList<Vocabulary> vocabularies) {
        this.context = context;
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.vocabularies = vocabularies;
    }

    @Override
    public void onBindViewHolder(@NonNull VocabularyViewHolder holder, int position) {
        Vocabulary vocabulary = vocabularies.get(position);
        holder.tvId.setText(vocabulary.getId());
        holder.tvWord.setText(vocabulary.getWord());
        holder.tvType.setText(vocabulary.getType());
        holder.tvPronounce.setText(vocabulary.getPronounce());
        holder.tvMeaning.setText(vocabulary.getMeaning());
    }

    @NonNull
    @Override
    public VocabularyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = layoutInflater.inflate(R.layout.item_vocabulary, parent, false);
        VocabularyViewHolder myViewHolder = new VocabularyAdapter.VocabularyViewHolder(v);
        return myViewHolder;
    }

    @Override
    public int getItemCount() {
        return this.vocabularies.size();
    }

    public class VocabularyViewHolder extends  RecyclerView.ViewHolder {
        TextView tvId;
        TextView tvWord;
        TextView tvType;
        TextView tvPronounce;
        TextView tvMeaning;
        public VocabularyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.tvId = itemView.findViewById(R.id.tvId);
            this.tvWord = itemView.findViewById(R.id.tvWord);
            this.tvType = itemView.findViewById(R.id.tvType);
            this.tvPronounce = itemView.findViewById(R.id.tvPronounce);
            this.tvMeaning = itemView.findViewById(R.id.tvMeaning);
        }
    }
}
