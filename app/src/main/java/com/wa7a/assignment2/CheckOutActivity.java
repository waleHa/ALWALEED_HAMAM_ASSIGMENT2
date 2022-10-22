package com.wa7a.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.wa7a.assignment2.Model.Model;
import com.wa7a.assignment2.Model.PaymentInfo;
import com.wa7a.assignment2.Model.UserInfo;

public class CheckOutActivity extends AppCompatActivity {
    private Model userOptionIntent;
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
        setContentView(R.layout.activity_check_out);
        cardAutoCompleteTextView = findViewById(R.id.auto_complete_text_view_card);
        editTextName = findViewById(R.id.edit_text_name);
        editTextAddress = findViewById(R.id.edit_text_address);
        editTextCity = findViewById(R.id.edit_text_city);
        editTextPostalCode = findViewById(R.id.edit_text_postal_code);
        editTextTelephone = findViewById(R.id.edit_text_telephone);
        editTextCardNumber = findViewById(R.id.edit_text_card_number);
        editTextExpiration = findViewById(R.id.edit_text_Expiration);
        editTextCVV = findViewById(R.id.edit_text_CVV);
        nextViewButton = findViewById(R.id.next_view_button);
        textViewValidation = findViewById(R.id.text_view_validation);
        cardArrayAdapter = new ArrayAdapter<String>(this, R.layout.text_dropdown_item, getResources().getStringArray(R.array.cards));
        cardAutoCompleteTextView.setAdapter(cardArrayAdapter);
        Intent intent = getIntent();
        userOptionIntent = (Model) intent.getParcelableExtra("user_option");
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
                    intent2.putExtra("user_info",(Parcelable)userInfoIntent);
                    intent2.putExtra("payment_info",(Parcelable)paymentInfo);
                    startActivity(intent2);

                }
            }
        });
    }
    public void userInfoSetter(){
        userInfoIntent = new UserInfo();
        paymentInfo.setExpiration(editTextExpiration.getText().toString());
        paymentInfo.setCVV(editTextCVV.getText().toString());
        if(cardType != null) {
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
        if (editTextName.length() > 2) {
            if (editTextAddress.length() > 2) {
                if (editTextCity.length() > 2) {
                    if (editTextPostalCode.length() == 6 || editTextPostalCode.length() == 7) {
                        if (editTextTelephone.length() > 6) {
                            if (cardType != null && cardType.length() > 2) {
                                if (editTextCardNumber.length() > 6) {
                                    if (editTextExpiration.length() == 4) {
                                        paymentInfo.setExpiration(editTextCardNumber.getText().toString());
                                        if (editTextCVV.length() == 3) {
                                            return true;
                                        } else {
                                            textViewValidation.setText(textViewValidation.getText() + "Error CVV! ");
                                        }
                                    } else {
                                        textViewValidation.setText(textViewValidation.getText() + "Error Expiration! ");
                                    }
                                } else {
                                    textViewValidation.setText(textViewValidation.getText() + "Error Card Number! ");
                                }
                            } else {
                                textViewValidation.setText(textViewValidation.getText() + "Error Card Type! ");
                            }
                        }
                        else {
                            textViewValidation.setText(textViewValidation.getText() + "Error Telephone! ");
                        }
                    } else {
                        textViewValidation.setText(textViewValidation.getText() + "Error Postal Code! ");
                    }
                } else {
                    textViewValidation.setText(textViewValidation.getText() + "Error City! ");
                }
            } else {
                textViewValidation.setText(textViewValidation.getText() + "Error Address! ");
            }
        } else {
            textViewValidation.setText("Error Name! ");
        }
        return false;
    }
}