package com.wa7a.assignment2.ui.middle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.wa7a.assignment2.R;
import com.wa7a.assignment2.constants.Constant;
import com.wa7a.assignment2.databinding.ActivityMiddleBinding;
import com.wa7a.assignment2.model.Phone;
import com.wa7a.assignment2.ui.selection.PhoneSelectionActivity;

import java.util.ArrayList;

public class MiddleActivity extends AppCompatActivity implements RecycleViewMiddleAdapter.OnModelListener {
    ActivityMiddleBinding binding;
    RecyclerView recyclerView;
    TextView textView;
    private String intentValue;
    ArrayList<Phone> phones = new ArrayList<>();
    RecycleViewMiddleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMiddleBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        bindingNSetter();
        titleSetter();
        recyclerViewSetter();
    }

//
    public void bindingNSetter() {
        textView = binding.textViewBrand;
        recyclerView = binding.recycleViewMiddle;
        intentValue = getIntent().getStringExtra("phone");
    }

    public void recyclerViewSetter() {
        adapter = new RecycleViewMiddleAdapter(phones, this);//**OnModelListener
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
    }

    public void titleSetter() {
        String brandName="";
        if (intentValue.equals(Constant.IPHONE_TITLE)) {
            brandName = Constant.IPHONE_TITLE;
        } else if (intentValue.equals(Constant.GOOGLE_PIXEL_TITLE)) {
            brandName = Constant.GOOGLE_PIXEL_TITLE;
        } else if (intentValue.equals(Constant.OPPO_TITLE)) {
            brandName = Constant.OPPO_TITLE;
        } else if (intentValue.equals(Constant.SAMSUNG_TITLE)) {
            brandName = Constant.SAMSUNG_TITLE;
        }
        textView.setText("Brand: " + brandName);
        phones = Constant.getLists(brandName);
    }

    @Override
    public void onModelClick(int position) {
        Intent intent = new Intent(this, PhoneSelectionActivity.class);
        intent.putExtra("user_option", phones.get(position));
        String brandName = phones.get(position).getBrand();
        String ModelName = phones.get(position).getPhoneModel();
        int price = phones.get(position).getPrice();
        Phone phone = new Phone(brandName, ModelName, price);
        intent.putExtra("user_option", phone);
        startActivity(intent);
    }
}
