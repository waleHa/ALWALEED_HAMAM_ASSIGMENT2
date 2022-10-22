package com.wa7a.assignment2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Intent intent;
    static String IPHONE_KEY ="iPhone", OPPO_KEY ="Oppo", GOOGLE_PIXEL_KEY ="Google Pixel", SAMSUNG_KEY ="Samsung";
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        intent = new Intent(getBaseContext(), MiddleActivity.class);
        switch (item.getItemId()){
            case R.id.iPhone_item:
                intent.putExtra("phone", IPHONE_KEY);
                startActivity(intent);
                return true;
            case R.id.oppo_item:
                intent.putExtra("phone", OPPO_KEY);
                startActivity(intent);
                return true;
            case R.id.pixel_item:
                intent.putExtra("phone", GOOGLE_PIXEL_KEY);
                startActivity(intent);
                return true;
            case R.id.samsung_item:
                intent.putExtra("phone", SAMSUNG_KEY);
                Toast.makeText(this,"End1",Toast.LENGTH_SHORT).show();
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

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
}