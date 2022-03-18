package com.example.englishvocabulary.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.englishvocabulary.R;
import com.example.englishvocabulary.domains.Grammar;

import java.util.ArrayList;

public class GrammarAdapter extends RecyclerView.Adapter<GrammarAdapter.GrammarViewHolder> {
    Context context;
    LayoutInflater layoutInflater;
    ArrayList<Grammar> grammars = new ArrayList<>();
    public static String TAG = "GrammarAdapter";

    public GrammarAdapter(Context context, ArrayList<Grammar> grammars) {
        this.context = context;
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.grammars = grammars;
    }

    @Override
    public void onBindViewHolder(@NonNull GrammarViewHolder holder, int position) {
        Grammar grammar = grammars.get(position);
        holder.tvId.setText(grammar.getId());
        holder.tvStructure.setText(grammar.getStructure());
        holder.tvExample.setText(grammar.getExample());
    }

    @NonNull
    @Override
    public GrammarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = layoutInflater.inflate(R.layout.item_grammar, parent, false);
        GrammarViewHolder myViewHolder = new GrammarAdapter.GrammarViewHolder(v);
        return myViewHolder;
    }

    @Override
    public int getItemCount() {
        return this.grammars.size();
    }

    public class GrammarViewHolder extends RecyclerView.ViewHolder {
        TextView tvId;
        TextView tvStructure;
        TextView tvExample;

        public GrammarViewHolder(@NonNull View itemView) {
            super(itemView);
            this.tvId = itemView.findViewById(R.id.tvId);
            this.tvStructure = itemView.findViewById(R.id.tvStructure);
            this.tvExample = itemView.findViewById(R.id.tvExample);
        }
    }
}
