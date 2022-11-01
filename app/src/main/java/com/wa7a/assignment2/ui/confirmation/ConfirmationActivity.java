package com.wa7a.assignment2.ui.confirmation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.wa7a.assignment2.model.Phone;
import com.wa7a.assignment2.model.PaymentInfo;
import com.wa7a.assignment2.model.UserInfo;
import com.wa7a.assignment2.databinding.ActivityConfirmationBinding;

public class ConfirmationActivity extends AppCompatActivity {
    private Phone userOptionIntent;
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
                "\nModel: " + userOptionIntent.getPhoneModel() + "\nPrice: " +
                userOptionIntent.getPrice() + "\nStorage: " + userOptionIntent.getSize()
                + "\nColor: " + userOptionIntent.getColor());
    }
}