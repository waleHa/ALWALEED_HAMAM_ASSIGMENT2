package com.wa7a.assignment2.ui.selection;

import static com.wa7a.assignment2.constants.Constant.getPrice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

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

import com.wa7a.assignment2.constants.Constant;
import com.wa7a.assignment2.model.Phone;
import com.wa7a.assignment2.R;
import com.wa7a.assignment2.ui.checkout.CheckOutActivity;
import com.wa7a.assignment2.databinding.ActivityPhoneSelectionBinding;

import java.util.Arrays;

public class PhoneSelectionActivity extends AppCompatActivity {
    //    private String intentValue;
    ActivityPhoneSelectionBinding binding;
    ArrayAdapter<String> colorArrayAdapter;
    AutoCompleteTextView colorAutoCompleteTextView;
    RadioButton size64, size128, size256, size512;
    boolean s64 = false, s128 = false, s256 = false, s512 = false;
    TextView brandTextView, phoneModelTextView;
    Button nextViewButton;
    Phone phone = new Phone();
    RadioGroup radioGroup;
    RadioButton radioButton;
    int tempInt = 64;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        binding = ActivityPhoneSelectionBinding.inflate(getLayoutInflater());
//        setContentView(binding.getRoot());
        binding = DataBindingUtil.setContentView(this,R.layout.activity_middle);
        intentNBindingSetter();
        capacitySizeSetter();
        viewsSetter();
    }

    private void viewsSetter() {
        brandTextView.setText("Brand: " + phone.getBrand());
        phoneModelTextView.setText("Phone Model Name: " + phone.getPhoneModel());
        colorArrayAdapter = new ArrayAdapter<String>(this, R.layout.text_dropdown_item, getResources().getStringArray(R.array.colors));
        colorAutoCompleteTextView.setAdapter(colorArrayAdapter);
        colorAutoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item = adapterView.getItemAtPosition(i).toString();
                phone.setColor(item);
            }
        });
        nextViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (colorAutoCompleteTextView.getText().length() > 2) {
                    if (radioButtonSetterNValidate()) {
                        Intent intent = new Intent(getBaseContext(), CheckOutActivity.class);
                        intent.putExtra("user_option", phone);
                        startActivity(intent);
                    }
                }
            }
        });
    }


    public void intentNBindingSetter() {
        phone = getIntent().getParcelableExtra("user_option");
        colorAutoCompleteTextView = binding.autoCompleteTextViewColor;
        size64 = binding.size64;
        size128 = binding.size128;
        size256 = binding.size256;
        size512 = binding.size512;
        radioGroup = binding.radioGroup;
        brandTextView = binding.textViewBrand;
        phoneModelTextView = binding.textViewPhoneModel;
        nextViewButton = binding.nextViewButton;
    }

    private void capacitySizeSetter() {
        String[] brandName = new String[0];
        if (phone.getBrand() != null) {
            if (phone.getBrand().equals(getResources().getString(R.string.IPHONE))) {
                brandName = Arrays.copyOf(getResources().getStringArray(R.array.iphone_storage_capacity), getResources().getStringArray(R.array.iphone_storage_capacity).length);
            }
            if (phone.getBrand().equals(getResources().getString(R.string.GOOGLE_PIXEL))) {
                brandName = Arrays.copyOf(getResources().getStringArray(R.array.pixel_storage_capacity), getResources().getStringArray(R.array.pixel_storage_capacity).length);
            }
            if (phone.getBrand().equals(getResources().getString(R.string.OPPO))) {
                brandName = Arrays.copyOf(getResources().getStringArray(R.array.oppo_storage_capacity), getResources().getStringArray(R.array.oppo_storage_capacity).length);
            }
            if (phone.getBrand().equals(getResources().getString(R.string.SAMSUNG))) {
                brandName = Arrays.copyOf(getResources().getStringArray(R.array.samsung_storage_capacity), getResources().getStringArray(R.array.samsung_storage_capacity).length);
            }
            setCapacity(brandName);
        }
    }

    public void setCapacity(String[] str) {
        if (str != null) {
            for (int i = 0; i < str.length; i++) {
                if ((str)[i].equals("64")) {
                    size64.setVisibility(View.VISIBLE);
                    s64 = true;
                    phone.setSize(64);
                } else if (str[i].equals("128")) {
                    size128.setVisibility(View.VISIBLE);
                    s128 = true;
                    phone.setSize(128);
                } else if (str[i].equals("256")) {
                    size256.setVisibility(View.VISIBLE);
                    s256 = true;
                    phone.setSize(256);
                } else if (str[i].equals("512")) {
                    size512.setVisibility(View.VISIBLE);
                    s512 = true;
                    phone.setSize(512);
                }
            }
        }
    }

    public boolean radioButtonSetterNValidate() {
        int radioId = radioGroup.getCheckedRadioButtonId();
        Log.d("XPrice1 is: ", Constant.priceSetter(128, 1000, 1100, 1200, 1300) + "");
        if (radioId != -1 && radioId > 0) {
            radioButton = findViewById(radioId);
            if (radioButton.getText() != null) {
                String tempStr = (String) radioButton.getText();
                int tempInt = Integer.parseInt(tempStr);
                phone.setPrice(getPrice(phone.getBrand(), phone.getPhoneModel(), tempInt));
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

// data binding
// parecelable
// binding adapter