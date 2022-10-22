package com.wa7a.assignment2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.wa7a.assignment2.Model.Model;

import java.util.ArrayList;

public class MiddleActivity extends AppCompatActivity implements RecycleViewMiddleAdapter.OnModelListener {
    RecyclerView recyclerView;
    TextView textView;
    private String intentValue;
    ArrayList<Model> models;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_middle);
        textView = findViewById(R.id.text_view_brand);
        recyclerView = findViewById(R.id.recycle_view_middle);
        models = new ArrayList<>();
        Intent intent = getIntent();
        intentValue = intent.getStringExtra("phone");


        if(intentValue.equals(MainActivity.IPHONE_KEY)) {
            textView.setText("Brand: iPhone");
            models = Model.getIphoneLists();
        } else if(intentValue.equals(MainActivity.GOOGLE_PIXEL_KEY)) {
            textView.setText("Brand: Google Pixel");
            models = Model.getPixelLists();

        } else if(intentValue.equals(MainActivity.OPPO_KEY)) {
            textView.setText("Brand: Oppo");
            models = Model.getOppoLists();

        } else if(intentValue.equals(MainActivity.SAMSUNG_KEY)) {
            textView.setText("Brand: Samsung");
            models = Model.getSamsungLists();

        }

        RecycleViewMiddleAdapter adapter = new RecycleViewMiddleAdapter(models,this);
        recyclerView.setAdapter(adapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this); //Manage the Adapter functionality

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setHasFixedSize(true);

    }

    @Override
    public void onModelClick(int position) {
        Intent intent = new Intent(this, PhoneSelectionActivity.class);
        intent.putExtra("phone",models.get(position).getBrand());
        intent.putExtra("model",models.get(position).getModelName());
        intent.putExtra("position",position);
        Model model = new Model(models.get(position).getBrand(),models.get(position).getModelName(),models.get(position).getPrice(),models.get(position).getPrice());

        intent.putExtra("user_option",model);
        startActivity(intent);
    }
}