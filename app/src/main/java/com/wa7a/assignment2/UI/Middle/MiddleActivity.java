package com.wa7a.assignment2.UI.Middle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.wa7a.assignment2.Model.Model;
import com.wa7a.assignment2.UI.PhoneSelection.PhoneSelectionActivity;
import com.wa7a.assignment2.databinding.ActivityMiddleBinding;

import java.util.ArrayList;

public class MiddleActivity extends AppCompatActivity implements RecycleViewMiddleAdapter.OnModelListener {
    ActivityMiddleBinding binding;
    RecyclerView recyclerView;
    TextView textView;
    private String intentValue;
    ArrayList<Model> models = new ArrayList<>();
    ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMiddleBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        bindingNSetter();
        titleSetter();
        RecycleViewMiddleAdapter adapter = new RecycleViewMiddleAdapter(models, this);
        RecyclerViewSetter(recyclerView, adapter);
    }

    public void bindingNSetter() {
        textView = binding.textViewBrand;
        recyclerView = binding.recycleViewMiddle;
        intentValue = getIntent().getStringExtra("phone");
    }

    public void RecyclerViewSetter(RecyclerView recyclerView, RecycleViewMiddleAdapter adapter) {
        recyclerView.setAdapter(adapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this); //Manage the Adapter functionality
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
    }

    public void titleSetter() {
        if (intentValue.equals(Model.IPHONE_KEY)) {
            textView.setText("Brand: " + Model.IPHONE_KEY);
            models = Model.getIphoneLists();
        } else if (intentValue.equals(Model.GOOGLE_PIXEL_KEY)) {
            textView.setText("Brand: " + Model.GOOGLE_PIXEL_KEY);
            models = Model.getPixelLists();
        } else if (intentValue.equals(Model.OPPO_KEY)) {
            textView.setText("Brand: " + Model.OPPO_KEY);
            models = Model.getOppoLists();
        } else if (intentValue.equals(Model.SAMSUNG_KEY)) {
            textView.setText("Brand: " + Model.SAMSUNG_KEY);
            models = Model.getSamsungLists();
        }
    }

    @Override
    public void onModelClick(int position) {
        Intent intent = new Intent(this, PhoneSelectionActivity.class);
        intent.putExtra("phone", models.get(position).getBrand());
        intent.putExtra("model", models.get(position).getModelName());
        intent.putExtra("position", position);
        String brandName = models.get(position).getBrand();
        String ModelName = models.get(position).getModelName();
        int price = models.get(position).getPrice();
        Model model = new Model(brandName, ModelName, price);
        intent.putExtra("user_option", model);
        startActivity(intent);
    }
}