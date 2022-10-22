package com.wa7a.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.wa7a.assignment2.Model.Model;
import com.wa7a.assignment2.Model.PaymentInfo;
import com.wa7a.assignment2.Model.UserInfo;

public class ConfirmationActivity extends AppCompatActivity {
    private Model userOptionIntent;
    UserInfo userInfoIntent ;
    PaymentInfo paymentInfoIntent;
    TextView textViewCustomerInfo, textViewPaymentInfo, textViewProductInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);
        Intent intent = getIntent();

        userOptionIntent = getIntent().getParcelableExtra("user_option");
        userInfoIntent = (UserInfo) intent.getParcelableExtra("user_info");
        paymentInfoIntent = (PaymentInfo) intent.getParcelableExtra("payment_info");

        textViewCustomerInfo = findViewById(R.id.text_view_customer_info);
        textViewPaymentInfo = findViewById(R.id.text_view_payment_details);
        textViewProductInfo = findViewById(R.id.text_view_phone_details);

        textViewCustomerInfo.setText("Name: "+userInfoIntent.getName().toString() + "\nAddress: " + userInfoIntent.getAddress1().toString()+"\nCity: "+userInfoIntent.getCity().toString()+"\nPostal Code"+userInfoIntent.getPostalCode().toString()+"\nPhone: "+userInfoIntent.getTelephone());

        textViewPaymentInfo.setText("Card Number: "+paymentInfoIntent.getCreditCardNumber().toString()+ "\nCard Type: " + paymentInfoIntent.getCardType().toString());
        textViewProductInfo.setText("Name: "+userInfoIntent.getName().toString() + "\nAddress: " + userInfoIntent.getAddress1().toString()+"\nCity: "+userInfoIntent.getCity().toString()+"\nPostal Code"+userInfoIntent.getPostalCode().toString()+"\nPhone: "+userInfoIntent.getTelephone());
    }
}