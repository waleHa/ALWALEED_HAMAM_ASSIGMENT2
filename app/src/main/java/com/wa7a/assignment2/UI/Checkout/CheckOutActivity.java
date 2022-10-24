package com.wa7a.assignment2.UI.Checkout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.wa7a.assignment2.Model.Model;
import com.wa7a.assignment2.Model.PaymentInfo;
import com.wa7a.assignment2.Model.UserInfo;
import com.wa7a.assignment2.R;
import com.wa7a.assignment2.UI.Confirmation.ConfirmationActivity;
import com.wa7a.assignment2.databinding.ActivityCheckOutBinding;

public class CheckOutActivity extends AppCompatActivity {
    private Model userOptionIntent;
    ActivityCheckOutBinding binding;
    private UserInfo userInfoIntent;
    String cardType;
    private PaymentInfo paymentInfo = new PaymentInfo();
    AutoCompleteTextView cardAutoCompleteTextView;
    ArrayAdapter<String> cardArrayAdapter;
    TextView textViewValidation;
    EditText editTextName, editTextAddress, editTextCity, editTextPostalCode, editTextTelephone, editTextCardNumber, editTextExpiration, editTextCVV;
    Button nextViewButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCheckOutBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        intentNBindingSetter();
        ViewSetter();
    }

    private void ViewSetter() {
        cardAutoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item = adapterView.getItemAtPosition(i).toString();
                cardType = item;
            }
        });
        nextViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Validate()) {
                    userInfoSetter();
                    Intent intent2 = new Intent(getBaseContext(), ConfirmationActivity.class);
                    intent2.putExtra("user_option", userOptionIntent);
                    intent2.putExtra("user_info", (Parcelable) userInfoIntent);
                    intent2.putExtra("payment_info", (Parcelable) paymentInfo);
                    startActivity(intent2);
                }
            }
        });
    }

    public void intentNBindingSetter() {
        cardAutoCompleteTextView = binding.autoCompleteTextViewCard;
        editTextName = binding.editTextName;
        editTextAddress = binding.editTextAddress;
        editTextCity = binding.editTextCity;
        editTextPostalCode = binding.editTextPostalCode;
        editTextTelephone = binding.editTextTelephone;
        editTextCardNumber = binding.editTextCardNumber;
        editTextExpiration = binding.editTextExpiration;
        editTextCVV = binding.editTextCVV;
        nextViewButton = binding.nextViewButton;
        textViewValidation = binding.textViewValidation;
        cardArrayAdapter = new ArrayAdapter<String>(this, R.layout.text_dropdown_item, getResources().getStringArray(R.array.cards));
        cardAutoCompleteTextView.setAdapter(cardArrayAdapter);
        userOptionIntent = (Model) getIntent().getParcelableExtra("user_option");
    }

    public void userInfoSetter() {
        userInfoIntent = new UserInfo();
        paymentInfo.setExpiration(editTextExpiration.getText().toString());
        paymentInfo.setCVV(editTextCVV.getText().toString());
        if (cardType != null) {
            paymentInfo.setCardType(cardType);
        }
        paymentInfo.setCreditCardNumber(editTextCardNumber.getText().toString());
        userInfoIntent.setPaymentInfo(paymentInfo);
        userInfoIntent.setAddress1(editTextAddress.getText().toString());
        userInfoIntent.setName(editTextName.getText().toString());
        userInfoIntent.setCity(editTextCity.getText().toString());
        userInfoIntent.setPostalCode(editTextPostalCode.getText().toString());
        userInfoIntent.setTelephone(editTextTelephone.getText().toString());
    }

    public boolean Validate() {
        textViewValidation.setText("");
        boolean validation = true;
        if (true) {
            if (!isLengthMoreThan(2, editTextName.length())) {
                textViewValidation.setText("Error Name! ");
             }
            if (!isLengthMoreThan(2, editTextAddress.length())) {
                textViewValidation.setText(textViewValidation.getText() + "Error Address! ");
            }
            if (!isLengthMoreThan(2, editTextCity.length())) {
                textViewValidation.setText(textViewValidation.getText() + "Error City! ");
            }
            if (!isLengthMoreThan(6, editTextPostalCode.length())) {
                textViewValidation.setText(textViewValidation.getText() + "Error Postal Code! ");
            }
            if (!isLengthMoreThan(6, editTextTelephone.length())) {
                textViewValidation.setText(textViewValidation.getText() + "Error Telephone! ");
            }
            if (!isLengthMoreThan(2, cardType.length())) {
                textViewValidation.setText(textViewValidation.getText() + "Error Card Type! ");
            }
            if (!isLengthMoreThan(6, editTextCardNumber.length())) {
                textViewValidation.setText(textViewValidation.getText() + "Error Card Number! ");
            }
            if (!isLengthMoreThan(6, editTextExpiration.length())) {
                textViewValidation.setText(editTextExpiration.getText() + "Error Card Number! ");
            }
            if (!isLengthEqual(editTextExpiration.length(), 4)) {
                textViewValidation.setText(textViewValidation.getText() + "Error Expiration! ");
            }
            if (!isLengthEqual(editTextCVV.length(), 3)) {
                textViewValidation.setText(textViewValidation.getText() + "Error CVV! ");
            }
            validation = false;
        }
        return validation;
    }

    public boolean isLengthMoreThan(int number, int var) {
        if (var > number) {
            return true;
        }
        return true;
    }

    public boolean isLengthEqual(int number, int var) {
        if (var == number) {
            return true;
        }
        return true;
    }
}