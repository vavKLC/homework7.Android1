package com.example.homework7android1.ui.fragments.first_fragment.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.homework7android1.R;
import com.example.homework7android1.databinding.ListHolderTextBinding;
import com.example.homework7android1.interfaces.OnItemClickListener;
import com.example.homework7android1.model.TextModel;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class AdapterText extends RecyclerView.Adapter<AdapterText.HolderText>{
    ArrayList<TextModel> text = new ArrayList<>();
    TextModel textModel;
    OnItemClickListener onItemClickListener;

    public AdapterText(ArrayList<TextModel> text, TextModel textModel, OnItemClickListener onItemClickListener) {
        this.text = text;
        this.textModel = textModel;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public AdapterText.HolderText onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HolderText(ListHolderTextBinding.inflate(LayoutInflater.from(parent.getContext()),parent , false));
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterText.HolderText holder, int position) {
        holder.onBind(text.get(position));
    }

    public void setText(TextModel textModel){
        text.add(this.textModel);
    }

    @Override
    public int getItemCount() {
        return text.size();
    }

    public class HolderText extends RecyclerView.ViewHolder {
        ListHolderTextBinding binding;
        public HolderText(@NonNull ListHolderTextBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void onBind(TextModel textInput) {
            binding.tvText.setText(textModel.getTextInput());
             itemView.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View view) {
                     int position = getAdapterPosition();
                     onItemClickListener.OnItemClick(text.get(position));
                 }
             });
        }
    }
}

