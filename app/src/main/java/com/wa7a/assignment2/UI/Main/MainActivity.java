package com.wa7a.assignment2.UI.Main;

import static com.wa7a.assignment2.Model.Model.OPPO_KEY;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.wa7a.assignment2.Model.Model;
import com.wa7a.assignment2.R;
import com.wa7a.assignment2.UI.Middle.MiddleActivity;

public class MainActivity extends AppCompatActivity {
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
            case R.id.iPhone_item:
                return optionSetter(Model.IPHONE_KEY);
            case R.id.oppo_item:
                return optionSetter(Model.OPPO_KEY);
            case R.id.pixel_item:
                return optionSetter(Model.GOOGLE_PIXEL_KEY);
            case R.id.samsung_item:
                return optionSetter(Model.SAMSUNG_KEY);
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public boolean optionSetter(String model) {
        intent.putExtra("phone", model);
        startActivity(intent);
        return true;
    }
}