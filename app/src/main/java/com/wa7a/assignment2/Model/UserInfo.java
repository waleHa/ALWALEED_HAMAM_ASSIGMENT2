package com.wa7a.assignment2.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class UserInfo implements Parcelable {
    private String name;
    private String address1;
    private String address2;
    private String city;
    private String postalCode;
    private String telephone;
    private PaymentInfo paymentInfo;

    public UserInfo() {
    }

    public UserInfo(String name, String address1, String address2, String city, String postalCode, String telephone, PaymentInfo paymentInfo) {
        this.name = name;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.postalCode = postalCode;
        this.telephone = telephone;
        this.paymentInfo = paymentInfo;
    }

    protected UserInfo(Parcel in) {
        name = in.readString();
        address1 = in.readString();
        address2 = in.readString();
        city = in.readString();
        postalCode = in.readString();
        telephone = in.readString();
    }

    public static final Creator<UserInfo> CREATOR = new Creator<UserInfo>() {
        @Override
        public UserInfo createFromParcel(Parcel in) {
            return new UserInfo(in);
        }

        @Override
        public UserInfo[] newArray(int size) {
            return new UserInfo[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public PaymentInfo getPaymentInfo() {
        return paymentInfo;
    }

    public void setPaymentInfo(PaymentInfo paymentInfo) {
        this.paymentInfo = paymentInfo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(address1);
        parcel.writeString(address2);
        parcel.writeString(city);
        parcel.writeString(postalCode);
        parcel.writeString(telephone);
    }
}
