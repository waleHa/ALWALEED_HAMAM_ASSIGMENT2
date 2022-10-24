package com.wa7a.assignment2.UI.Middle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.wa7a.assignment2.Model.Model;
import com.wa7a.assignment2.R;

import java.util.ArrayList;

public class RecycleViewMiddleAdapter extends RecyclerView.Adapter<RecycleViewMiddleAdapter.ModelViewHolder>{
    ArrayList<Model> models;
    OnModelListener onModelListener;
    public RecycleViewMiddleAdapter(ArrayList<Model> models, OnModelListener onModelListener) {
        this.models = models;
        this.onModelListener = onModelListener;
    }

    @NonNull
    @Override
    public ModelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.model_custom_item,parent,false);
        ModelViewHolder viewHolder = new ModelViewHolder(view,onModelListener);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull ModelViewHolder holder, int position) {
        Model model = models.get(position);
        holder.imageView.setImageResource(model.getImg());
        holder.textViewName.setText(model.getModelName());
        holder.textViewPrice.setText(model.getPrice()+ " $");
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    class ModelViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView textViewName, textViewPrice;
        ImageView imageView;
        OnModelListener onModelListener;
        public ModelViewHolder(@NonNull View itemView, OnModelListener onModelListener) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.custom_textview_model);
            imageView = itemView.findViewById(R.id.custom_imageview_img);
            textViewPrice = itemView.findViewById(R.id.custom_textview_price);
            this.onModelListener = onModelListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onModelListener.onModelClick(getAdapterPosition());
        }
    }
    public interface OnModelListener{
        void onModelClick(int position);
    }
}
