package com.wa7a.assignment2.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.wa7a.assignment2.R;

import java.util.ArrayList;

public class Model implements Parcelable {
    private String brand;
    private String modelName;
    private int price;
    private int size;
    private String color;
    private int img;
    static String IPHONE_KEY ="iPhone", OPPO_KEY ="Oppo", GOOGLE_PIXEL_KEY ="Google Pixel", SAMSUNG_KEY ="Samsung";

    public Model() {
    }

    public Model(String brand, String modelName, int price, int size, String color, int img) {
        this.brand = brand;
        this.modelName = modelName;
        this.price = price;
        this.size = size;
        this.color = color;
        this.img = img;
    }

    public Model(String brand, String modelName, int price, int size) {
        this.brand = brand;
        this.modelName = modelName;
        this.price = price;
        this.size = 0;
        this.color = "null";
        this.img = 0;
    }

    protected Model(Parcel in) {
        brand = in.readString();
        modelName = in.readString();
        price = in.readInt();
        size = in.readInt();
        color = in.readString();
        img = in.readInt();
    }

    public static final Creator<Model> CREATOR = new Creator<Model>() {
        @Override
        public Model createFromParcel(Parcel in) {
            return new Model(in);
        }

        @Override
        public Model[] newArray(int size) {
            return new Model[size];
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

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
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
    public static ArrayList<Model> getIphoneLists(){
        ArrayList<Model> models = new ArrayList<>();
        models.add(new Model(Model.IPHONE_KEY, "14 Max", 2600, 128, "White", (R.drawable.iphone)));
        models.add(new Model(Model.IPHONE_KEY, "14", 2000, 128, "Black", (R.drawable.iphone)));
        models.add(new Model(Model.IPHONE_KEY, "14 Pro", 2250, 128, "Silver", (R.drawable.iphone)));
        models.add(new Model(Model.IPHONE_KEY, "14", 2250, 256, "White", (R.drawable.iphone)));
        models.add(new Model(Model.IPHONE_KEY, "14 Pro", 2250, 256, "Red", (R.drawable.iphone)));
        models.add(new Model(Model.IPHONE_KEY, "14 Max", 2600, 512, "Gold", (R.drawable.iphone)));
        return  models;
    }
    public static ArrayList<Model> getPixelLists(){
        ArrayList<Model> models = new ArrayList<>();
        models.add(new Model(Model.GOOGLE_PIXEL_KEY, "Pixel 6", 1000, 128, "White", (R.drawable.pixel)));
        models.add(new Model(Model.GOOGLE_PIXEL_KEY, "Pixel 6a", 1300, 128, "Black", (R.drawable.pixel)));
        models.add(new Model(Model.GOOGLE_PIXEL_KEY, "Pixel 6", 1000, 128, "Silver", (R.drawable.pixel)));
        models.add(new Model(Model.GOOGLE_PIXEL_KEY, "Pixel 6a", 1750, 256, "White", (R.drawable.pixel)));
        models.add(new Model(Model.GOOGLE_PIXEL_KEY, "Pixel 6a", 1750, 256, "Red", (R.drawable.pixel)));
        models.add(new Model(Model.GOOGLE_PIXEL_KEY, "Pixel 6 Pro", 1700, 512, "Gold", (R.drawable.pixel)));
        return  models;
    }
    public static ArrayList<Model> getOppoLists(){
        ArrayList<Model> models = new ArrayList<>();
        models.add(new Model(Model.OPPO_KEY, "Find X3", 1000, 128, "White", (R.drawable.oppo)));
        models.add(new Model(Model.OPPO_KEY, "Find X5", 1300, 128, "Black", (R.drawable.oppo)));
        models.add(new Model(Model.OPPO_KEY, "Find X3", 1000, 128, "Silver", (R.drawable.oppo)));
        models.add(new Model(Model.OPPO_KEY, "Find X5 Pro", 1750, 256, "White", (R.drawable.oppo)));
        models.add(new Model(Model.OPPO_KEY, "Find X5 Pro", 1750, 256, "Red", (R.drawable.oppo)));
        models.add(new Model(Model.OPPO_KEY, "Find X5", 1700, 512, "Gold", (R.drawable.oppo)));
        return  models;
    }
    public static ArrayList<Model> getSamsungLists(){
        ArrayList<Model> models = new ArrayList<>();
        models.add(new Model(Model.SAMSUNG_KEY, "S22", 1000, 128, "White", (R.drawable.samsung)));
        models.add(new Model(Model.SAMSUNG_KEY, "S22 Ultra", 1300, 128, "Black", (R.drawable.samsung)));
        models.add(new Model(Model.SAMSUNG_KEY, "S22", 1000, 128, "Silver", (R.drawable.samsung)));
        models.add(new Model(Model.SAMSUNG_KEY, "Z", 1750, 256, "White", (R.drawable.samsung)));
        models.add(new Model(Model.SAMSUNG_KEY, "Z", 1750, 256, "Red", (R.drawable.samsung)));
        models.add(new Model(Model.SAMSUNG_KEY, "S22 Ultra", 1700, 512, "Gold", (R.drawable.samsung)));
        return  models;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(brand);
        parcel.writeString(modelName);
        parcel.writeInt(price);
        parcel.writeInt(size);
        parcel.writeString(color);
        parcel.writeInt(img);
    }
}
