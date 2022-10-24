package com.wa7a.assignment2.UI.PhoneSelection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.camera2.params.Capability;
import android.os.Bundle;
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
import com.wa7a.assignment2.R;
import com.wa7a.assignment2.UI.Checkout.CheckOutActivity;
import com.wa7a.assignment2.UI.Main.MainActivity;
import com.wa7a.assignment2.databinding.ActivityPhoneSelectionBinding;

public class PhoneSelectionActivity extends AppCompatActivity {
    private String intentValue;
    ActivityPhoneSelectionBinding binding;
    private Model userOptionIntent;
    ArrayAdapter<String> colorArrayAdapter;
    AutoCompleteTextView colorAutoCompleteTextView;
    RadioButton size64, size128, size256, size512;
    boolean s64 = false, s128 = false, s256 = false, s512 = false;
    TextView brandTextView, modelTextView;
    Button nextViewButton;
    Model model = new Model();
    RadioGroup radioGroup;
    RadioButton radioButton;
    int modelPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPhoneSelectionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        intentNBindingSetter();
        CapacitySizeSetter();
        ViewsSetter();
    }

    private void ViewsSetter() {
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


    private void CapacitySizeSetter() {
        if (intentValue.equals(getResources().getString(R.string.IPHONE))) {
            model = Model.getIphoneLists().get(modelPosition);
            setCapacity(getResources().getStringArray(R.array.iphone_storage_capacity));
        }
        if (intentValue.equals(getResources().getString(R.string.GOOGLE_PIXEL))) {
            model = Model.getPixelLists().get(modelPosition);
            setCapacity(getResources().getStringArray(R.array.pixel_storage_capacity));
        }
        if (intentValue.equals(getResources().getString(R.string.OPPO))) {
            model = Model.getOppoLists().get(modelPosition);
            setCapacity(getResources().getStringArray(R.array.oppo_storage_capacity));
        }
        if (intentValue.equals(getResources().getString(R.string.SAMSUNG))) {
            model = Model.getSamsungLists().get(modelPosition);
            setCapacity(getResources().getStringArray(R.array.samsung_storage_capacity));
        }
    }

    public void intentNBindingSetter() {
        intentValue = getIntent().getStringExtra("phone");
        userOptionIntent = getIntent().getParcelableExtra("user_option");
        modelPosition = getIntent().getIntExtra("position", 0);
        colorAutoCompleteTextView = binding.autoCompleteTextViewColor;
        size64 = binding.size64;
        size128 = binding.size128;
        size256 = binding.size256;
        size512 = binding.size512;
        radioGroup = binding.radioGroup;
        brandTextView = binding.textViewBrand;
        modelTextView = binding.textViewModel;
        nextViewButton = binding.nextViewButton;
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
                model.setPrice(Model.getPrice(model.getBrand(), model.getModelName(), tempInt));
                Toast.makeText(this, Model.getPrice(model.getBrand(), model.getModelName(), tempInt) + "$", Toast.LENGTH_SHORT).show();
                return true;
            }
        }
        return false;
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

}