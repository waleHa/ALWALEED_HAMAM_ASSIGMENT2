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
import com.wa7a.assignment2.databinding.ModelCustomItemBinding;

import java.util.ArrayList;

public class RecycleViewMiddleAdapter extends RecyclerView.Adapter<RecycleViewMiddleAdapter.ModelViewHolder>{
    ArrayList<Model> models;
    OnModelListener onModelListener;//**OnModelListener
    public RecycleViewMiddleAdapter(ArrayList<Model> models, OnModelListener onModelListener) {
        this.models = models;
        this.onModelListener = onModelListener;//**OnModelListener
    }

    @NonNull
    @Override
    public ModelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ModelCustomItemBinding itemBinding = ModelCustomItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false); //**binding
        return new ModelViewHolder(itemBinding,onModelListener);//**OnModelListener //**binding

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
        OnModelListener onModelListener;//**OnModelListener


        public ModelViewHolder(ModelCustomItemBinding itemBinding,OnModelListener onModelListener) {//**OnModelListener //**binding
            super(itemBinding.getRoot());//**binding
            textViewName = itemBinding.customTextviewModel;//**binding
            imageView = itemBinding.customImageviewImg;//**binding
            textViewPrice = itemBinding.customTextviewPrice;//**binding
            this.onModelListener = onModelListener;//**OnModelListener
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onModelListener.onModelClick(getAdapterPosition());
        }
    }
    public interface OnModelListener{//**OnModelListener
        void onModelClick(int position);
    }
}
