package com.wa7a.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.wa7a.assignment2.Model.Model;

import java.util.ArrayList;

public class PhoneSelectionActivity extends AppCompatActivity {
    private String intentValue;
    private Model userOptionIntent;
    ArrayAdapter<String> colorArrayAdapter, modelArrayAdapter;
    AutoCompleteTextView colorAutoCompleteTextView, modelAutoCompleteTextView;
    RadioButton size64, size128, size256, size512;
    boolean s64 = false, s128 = false, s256 = false, s512 = false;
    TextView brandTextView, modelTextView;
    Button nextViewButton;
    Model model = new Model();
    RadioGroup radioGroup;
    RadioButton radioButton;
    String[] storageCapacity;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_selection);
        intent = getIntent();
        intentValue = intent.getStringExtra("phone");
        userOptionIntent = intent.getParcelableExtra("user_option");

        size64 = findViewById(R.id.size_64);
        size128 = findViewById(R.id.size_128);
        size256 = findViewById(R.id.size_256);
        size512 = findViewById(R.id.size_512);
        radioGroup = findViewById(R.id.radio_group);
        brandTextView = findViewById(R.id.text_view_brand);
        modelTextView = findViewById(R.id.text_view_model);
        nextViewButton = findViewById(R.id.next_view_button);
        Integer modelPosition = intent.getIntExtra("position", 0);
        if (intentValue.equals(getResources().getString(R.string.IPHONE))) {
            model = Model.getIphoneLists().get(modelPosition);
            setCapacity(getResources().getStringArray(R.array.iphone_storage_capacity));
//            userOptionIntent.setPrice(Model.getIphonePrice(model.getBrand(),model.getSize()));
        }
        if (intentValue.equals(getResources().getString(R.string.GOOGLE_PIXEL))) {
            model = Model.getPixelLists().get(modelPosition);
            setCapacity(getResources().getStringArray(R.array.pixel_storage_capacity));
//            userOptionIntent.setPrice(Model.getPixelPrice(model.getBrand(),model.getSize()));

        }
        if (intentValue.equals(getResources().getString(R.string.OPPO))) {
            model = Model.getOppoLists().get(modelPosition);
            setCapacity(getResources().getStringArray(R.array.oppo_storage_capacity));
//            userOptionIntent.setPrice(Model.getOppoPrice(model.getBrand(),model.getSize()));

        }
        if (intentValue.equals(getResources().getString(R.string.SAMSUNG))) {
            model = Model.getSamsungLists().get(modelPosition);
            setCapacity(getResources().getStringArray(R.array.samsung_storage_capacity));
//            userOptionIntent.setPrice(Model.getSamsungPrice(model.getBrand(),model.getSize()));
//            Toast.makeText(this,Model.getSamsungPrice(model.getBrand(),model.getSize()),Toast.LENGTH_SHORT).show();
        }


        colorAutoCompleteTextView = findViewById(R.id.auto_complete_text_view_color);
        brandTextView.setText("Brand: " + model.getBrand());
        modelTextView.setText("Model Name: " + model.getModelName());
        colorArrayAdapter = new ArrayAdapter<String>(this, R.layout.text_dropdown_item, getResources().getStringArray(R.array.colors));
        colorAutoCompleteTextView.setAdapter(colorArrayAdapter);

        colorAutoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item = adapterView.getItemAtPosition(i).toString();
                model.setColor(item);
            }
        });

        nextViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Validate()) {
                    Intent intent = new Intent(getBaseContext(), CheckOutActivity.class);
                    userOptionIntent.setSize(model.getSize());
                    userOptionIntent.setColor(model.getColor());
                    userOptionIntent.setPrice(model.getPrice());
                    intent.putExtra("user_option", userOptionIntent);
                    startActivity(intent);
                }
            }
        });
    }

    public void setCapacity(String[] str) {
        if (str != null) {
            for (int i = 0; i < str.length; i++) {
                if ((str)[i].equals("64")) {
                    size64.setVisibility(View.VISIBLE);
                    s64 = true;
                    model.setSize(64);
                } else if (str[i].equals("128")) {
                    size128.setVisibility(View.VISIBLE);
                    s128 = true;
                    model.setSize(128);
                } else if (str[i].equals("256")) {
                    size256.setVisibility(View.VISIBLE);
                    s256 = true;
                    model.setSize(256);
                } else if (str[i].equals("512")) {
                    size512.setVisibility(View.VISIBLE);
                    s512 = true;
                    model.setSize(512);
                }
            }
        }
    }

    public boolean Validate() {
        if (colorAutoCompleteTextView.getText().length() > 2) {
            return radioButtonSetterNValidate();
        }
        return false;
    }
    public boolean radioButtonSetterNValidate() {
        int radioId = radioGroup.getCheckedRadioButtonId();
        if (radioId != -1 && radioId > 0) {
            radioButton = findViewById(radioId);
            if (radioButton.getText() != null) {
                String tempStr = (String) radioButton.getText();
                int tempInt = Integer.parseInt(tempStr);
                if (model.getBrand()==MainActivity.SAMSUNG_KEY) {
                    model.setPrice(Model.getSamsungPrice(model.getModelName(), tempInt));
                    Toast.makeText(this,Model.getSamsungPrice(model.getModelName(),tempInt)+"$",Toast.LENGTH_SHORT).show();
                }else if (model.getBrand()==MainActivity.OPPO_KEY) {
                    model.setPrice(Model.getOppoPrice(model.getModelName(), tempInt));
                    Toast.makeText(this,Model.getOppoPrice(model.getModelName(),tempInt)+"$",Toast.LENGTH_SHORT).show();
                }else if (model.getBrand()==MainActivity.IPHONE_KEY) {
                    model.setPrice(Model.getIphonePrice(model.getModelName(), tempInt));
                    Toast.makeText(this,Model.getIphonePrice(model.getModelName(),tempInt)+"$",Toast.LENGTH_SHORT).show();
                } else if (model.getBrand()==MainActivity.GOOGLE_PIXEL_KEY) {
                    model.setPrice(Model.getPixelPrice(model.getModelName(), tempInt));
                    Toast.makeText(this,Model.getPixelPrice(model.getModelName(),tempInt)+"$",Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        }
            return  false;
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

}