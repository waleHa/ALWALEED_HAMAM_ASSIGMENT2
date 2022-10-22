package com.wa7a.assignment2.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class PaymentInfo implements Parcelable {
    private String cardType;
    private String creditCardNumber;
    private String expiration;
    private String CVV;
    public PaymentInfo(){}
    public PaymentInfo(String cardType, String creditCardNumber, String expiration, String CVV) {
        this.cardType = cardType;
        this.creditCardNumber = creditCardNumber;
        this.expiration = expiration;
        this.CVV = CVV;
    }

    protected PaymentInfo(Parcel in) {
        cardType = in.readString();
        creditCardNumber = in.readString();
        expiration = in.readString();
        CVV = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(cardType);
        dest.writeString(creditCardNumber);
        dest.writeString(expiration);
        dest.writeString(CVV);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<PaymentInfo> CREATOR = new Creator<PaymentInfo>() {
        @Override
        public PaymentInfo createFromParcel(Parcel in) {
            return new PaymentInfo(in);
        }

        @Override
        public PaymentInfo[] newArray(int size) {
            return new PaymentInfo[size];
        }
    };

    public String getCardType() {
        return cardType;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public String getExpiration() {
        return expiration;
    }

    public String getCVV() {
        return CVV;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }

    public void setCVV(String CVV) {
        this.CVV = CVV;
    }
}
