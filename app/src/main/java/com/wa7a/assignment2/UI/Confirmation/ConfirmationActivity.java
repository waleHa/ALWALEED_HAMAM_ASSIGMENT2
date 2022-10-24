package com.wa7a.assignment2.UI.Confirmation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.wa7a.assignment2.Model.Model;
import com.wa7a.assignment2.Model.PaymentInfo;
import com.wa7a.assignment2.Model.UserInfo;
import com.wa7a.assignment2.R;
import com.wa7a.assignment2.databinding.ActivityCheckOutBinding;
import com.wa7a.assignment2.databinding.ActivityConfirmationBinding;

public class ConfirmationActivity extends AppCompatActivity {
    private Model userOptionIntent;
    UserInfo userInfoIntent;
    PaymentInfo paymentInfoIntent;
    TextView textViewCustomerInfo, textViewPaymentInfo, textViewProductInfo;
    ActivityConfirmationBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityConfirmationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        intentNBindingSetter();
    }

    private void intentNBindingSetter() {
        userOptionIntent = getIntent().getParcelableExtra("user_option");
        userInfoIntent = getIntent().getParcelableExtra("user_info");
        paymentInfoIntent = getIntent().getParcelableExtra("payment_info");

        textViewCustomerInfo = binding.textViewCustomerInfo;
        textViewPaymentInfo = binding.textViewPaymentDetails;
        textViewProductInfo = binding.textViewPhoneDetails;

        textViewCustomerInfo.setText("Name: " + userInfoIntent.getName() +
                "\nAddress: " + userInfoIntent.getAddress1() + "\nCity: " +
                userInfoIntent.getCity() + "\nPostal Code" + userInfoIntent.getPostalCode()
                + "\nPhone: " + userInfoIntent.getTelephone());

        textViewPaymentInfo.setText("Card Number: " + paymentInfoIntent.getCreditCardNumber()
                + "\nCard Type: " + paymentInfoIntent.getCardType());

        textViewProductInfo.setText("Brand: " + userOptionIntent.getBrand() +
                "\nModel: " + userOptionIntent.getModelName() + "\nPrice: " +
                userOptionIntent.getPrice() + "\nStorage: " + userOptionIntent.getSize()
                + "\nColor: " + userOptionIntent.getColor());
    }
}