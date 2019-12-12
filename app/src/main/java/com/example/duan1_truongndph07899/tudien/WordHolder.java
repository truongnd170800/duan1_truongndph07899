package com.example.duan1_truongndph07899.tudien;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duan1_truongndph07899.R;

public class WordHolder extends RecyclerView.ViewHolder {

    public final TextView tvWord;

    public WordHolder(@NonNull View itemView) {
        super(itemView);

        tvWord = itemView.findViewById(R.id.tvText);
    }
}