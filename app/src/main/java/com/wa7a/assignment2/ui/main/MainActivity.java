package com.wa7a.assignment2.ui.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.wa7a.assignment2.constants.Constant;
import com.wa7a.assignment2.R;
import com.wa7a.assignment2.databinding.ActivityMainBinding;
import com.wa7a.assignment2.databinding.ActivityMiddleBinding;
import com.wa7a.assignment2.ui.middle.MiddleActivity;

public class MainActivity extends AppCompatActivity {
    Intent intent;
//    ActivityMainBinding mainBinding;
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        intent = new Intent(getBaseContext(), MiddleActivity.class);
        switch (item.getItemId()) {
            case R.id.iphone_item:
                return optionSetter(Constant.IPHONE_TITLE);
            case R.id.oppo_item:
                return optionSetter(Constant.OPPO_TITLE);
            case R.id.pixel_item:
                return optionSetter(Constant.GOOGLE_PIXEL_TITLE);
            case R.id.samsung_item:
                return optionSetter(Constant.SAMSUNG_TITLE);
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public boolean optionSetter(String str) {
        intent.putExtra("phone", str);
        startActivity(intent);
        return true;
    }
}