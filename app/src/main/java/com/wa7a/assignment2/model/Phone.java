package com.wa7a.assignment2.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.wa7a.assignment2.constants.Constant;

public class Phone implements Parcelable {
    private String brand;
    private String phoneModel;
    private int price;
    private int size;
    private String color;
    private int img;


    public Phone() {
    }

    public Phone(String brand, String phoneModel, int price, int size, int img) {
        this.brand = brand;
        this.phoneModel = phoneModel;
        this.price = price;
        this.size = size;
        this.color = "";
        this.img = img;
    }

    public Phone(String brand, String phoneModel, int price) {
        this.brand = brand;
        this.phoneModel = phoneModel;
        this.price = price;
        this.size = 0;
        this.color = "null";
        this.img = 0;
    }

    protected Phone(Parcel in) {
        brand = in.readString();
        phoneModel = in.readString();
        price = in.readInt();
        size = in.readInt();
        color = in.readString();
        img = in.readInt();
    }

    public static final Creator<Phone> CREATOR = new Creator<Phone>() {
        @Override
        public Phone createFromParcel(Parcel in) {
            return new Phone(in);
        }

        @Override
        public Phone[] newArray(int size) {
            return new Phone[size];
        }
    };

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getPhoneModel() {
        return phoneModel;
    }

    public void setPhoneModel(String modelName) {
        this.phoneModel = modelName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(brand);
        parcel.writeString(phoneModel);
        parcel.writeInt(price);
        parcel.writeInt(size);
        parcel.writeString(color);
        parcel.writeInt(img);
    }

}
