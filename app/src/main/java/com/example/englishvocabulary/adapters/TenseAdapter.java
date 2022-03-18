package com.example.englishvocabulary.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.englishvocabulary.R;
import com.example.englishvocabulary.domains.Tense;

import java.util.ArrayList;

public class TenseAdapter extends RecyclerView.Adapter<TenseAdapter.TenseViewHolder>{
    Context context;
    LayoutInflater layoutInflater;
    ArrayList<Tense> tenses = new ArrayList<>();
    public static String TAG = "TenseAdapter";

    public TenseAdapter(Context context, ArrayList<Tense> tenses) {
        this.context = context;
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.tenses = tenses;
    }

    @Override
    public void onBindViewHolder(@NonNull TenseViewHolder holder, int position) {
        Tense tense = tenses.get(position);
        holder.tvId.setText(tense.getId());
        holder.tvTenThi.setText(tense.getTenThi());
        holder.tvCongThuc.setText(tense.getCongThuc());
        holder.tvCachSuDung.setText(tense.getCachSuDung());
        holder.tvDauHieu.setText(tense.getDauHieu());
        holder.tvViDu.setText(tense.getViDu());
    }

    @NonNull
    @Override
    public TenseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = layoutInflater.inflate(R.layout.item_tense, parent, false);
        TenseViewHolder myViewHolder = new TenseAdapter.TenseViewHolder(v);
        return myViewHolder;
    }

    @Override
    public int getItemCount() {
        return this.tenses.size();
    }

    public class TenseViewHolder extends RecyclerView.ViewHolder {
        TextView tvId;
        TextView tvTenThi;
        TextView tvCongThuc;
        TextView tvCachSuDung;
        TextView tvDauHieu;
        TextView tvViDu;

        public TenseViewHolder(@NonNull View itemView) {
            super(itemView);
            this.tvId = itemView.findViewById(R.id.tvId);
            this.tvTenThi = itemView.findViewById(R.id.tvTenThi);
            this.tvCongThuc = itemView.findViewById(R.id.tvCongThuc);
            this.tvCachSuDung = itemView.findViewById(R.id.tvCachSuDung);
            this.tvDauHieu = itemView.findViewById(R.id.tvDauHieu);
            this.tvViDu = itemView.findViewById(R.id.tvViDu);
        }
    }
}
