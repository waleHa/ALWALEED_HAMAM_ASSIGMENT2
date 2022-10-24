package com.wa7a.assignment2.Model;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.widget.Toast;

import com.wa7a.assignment2.R;

import java.util.ArrayList;

public class Model implements Parcelable {
    private String brand;
    private String modelName;
    private int price;
    private int size;
    private String color;
    private int img;
    public static final String IPHONE_KEY = "iPhone";
    public static final String OPPO_KEY = "Oppo";
    public static final String GOOGLE_PIXEL_KEY = "Google Pixel";
    public static final String SAMSUNG_KEY = "Samsung";
    public static final String IPHONE_14 = "14";
    public static final String IPHONE_14PRO = "14 Pro";
    public static final String IPHONE_14MAX = "14 Max";
    public static final String GOOGLE_PIXEL_6 = "Pixel 6";
    public static final String GOOGLE_PIXEL_6A = "Pixel 6a";
    public static final String GOOGLE_PIXEL_6PRO = "Pixel 6 Pro";
    public static final String OPPO_FIND_X3 = "Find X3", OPPO_FIND_X5 = "Find X5";
    public static final String OPPO_FIND_X5PRO = "Find X5 Pro";
    public static final String SAMSUNG_S22 = "S22";
    public static final String SAMSUNG_S22ULTRA = "S22 Ultra ", SAMSUNG_Z = "Z";

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

    public Model(String brand, String modelName, int price) {
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


    public static ArrayList<Model> getIphoneLists() {
        ArrayList<Model> models = new ArrayList<>();
        int photo = (R.drawable.iphone);
        String brand = Model.IPHONE_KEY;
        int size = 128;
        int price1 = getPrice(brand, Model.IPHONE_14MAX, size);
        int price2 = getPrice(brand, Model.IPHONE_14, size);
        int price3 = getPrice(brand, Model.IPHONE_14PRO, size);
        models.add(new Model(brand, Model.IPHONE_14MAX, price1, size, "", photo));
        models.add(new Model(brand, Model.IPHONE_14, price2, size, "", photo));
        models.add(new Model(brand, Model.IPHONE_14PRO, price3, size, "", photo));
        return models;
    }

    public static ArrayList<Model> getPixelLists() {
        ArrayList<Model> models = new ArrayList<>();
        int photo = (R.drawable.pixel);
        String brand = Model.GOOGLE_PIXEL_KEY;
        int size = 64;
        int price1 = getPrice(brand, Model.GOOGLE_PIXEL_6, size);
        models.add(new Model(brand, Model.GOOGLE_PIXEL_6, price1, size, "", photo));
        int price2 = getPrice(brand, Model.GOOGLE_PIXEL_6A, size);
        models.add(new Model(brand, Model.GOOGLE_PIXEL_6A, price2, size, "", photo));
        int price3 = getPrice(brand, Model.GOOGLE_PIXEL_6PRO, size);
        models.add(new Model(brand, Model.GOOGLE_PIXEL_6PRO, price3, size, "", photo));
        return models;
    }


    public static ArrayList<Model> getOppoLists() {
        ArrayList<Model> models = new ArrayList<>();
        int photo = (R.drawable.oppo);
        String brand = Model.OPPO_KEY;
        int size = 64;
        int price1 = getPrice(brand, Model.OPPO_FIND_X3, size);
        models.add(new Model(brand, Model.OPPO_FIND_X3, price1, size, "", photo));

        int price2 = getPrice(brand, Model.OPPO_FIND_X5, size);
        models.add(new Model(brand, Model.OPPO_FIND_X5, price2, size, "", photo));

        int price3 = getPrice(brand, Model.OPPO_FIND_X5PRO, size);
        models.add(new Model(brand, Model.OPPO_FIND_X5PRO, price3, size, "", photo));
        return models;
    }

    public static ArrayList<Model> getSamsungLists() {
        ArrayList<Model> models = new ArrayList<>();
        int photo = (R.drawable.samsung);
        String brand = Model.SAMSUNG_KEY;
        int size = 64;
        int price1 = getPrice(brand, Model.SAMSUNG_S22, size);
        models.add(new Model(brand, Model.SAMSUNG_S22, price1, size, "", photo));
        int price2 = getPrice(brand, Model.SAMSUNG_S22ULTRA, size);
        models.add(new Model(brand, Model.SAMSUNG_S22ULTRA, price2, size, "", photo));
        int price3 = getPrice(brand, Model.SAMSUNG_Z, size);
        models.add(new Model(brand, Model.SAMSUNG_Z, price3, size, "", photo));
        return models;
    }

    public static int getPrice(String brand, String model, int size) {
        if (brand == IPHONE_KEY) {
            if (model == IPHONE_14) {
                return PriceSetter(size, 2000, 2200, 2400, 2550);
            } else if (model == IPHONE_14PRO) {
                return PriceSetter(size, 2300, 2500, 2700, 2850);
            } else if (model == IPHONE_14MAX) {
                return PriceSetter(size, 2400, 2600, 2800, 2950);
            }
        } else if (brand == GOOGLE_PIXEL_KEY) {
            if (model == GOOGLE_PIXEL_6) {
                return PriceSetter(size, 1000, 1100, 1200, 1350);
            } else if (model == GOOGLE_PIXEL_6PRO) {
                return PriceSetter(size, 1100, 1200, 1300, 1350);
            } else if (model == GOOGLE_PIXEL_6A) {
                return PriceSetter(size, 1330, 1430, 1530, 1630);
            }
        } else if (brand == OPPO_KEY) {
            if (model == OPPO_FIND_X3) {
                return PriceSetter(size, 1000, 1100, 1200, 1350);
            } else if (model == OPPO_FIND_X5) {
                return PriceSetter(size, 1200, 1300, 1400, 1550);

            } else if (model == OPPO_FIND_X5PRO) {
                return PriceSetter(size, 1250, 1350, 1450, 1590);
            }
        } else if (brand == SAMSUNG_KEY) {
            if (model == SAMSUNG_S22) {
                return PriceSetter(size, 1000, 1100, 1200, 1350);
            } else if (model == SAMSUNG_S22ULTRA) {
                return PriceSetter(size, 1110, 1200, 1330, 1470);
            } else if (model == SAMSUNG_Z) {
                return PriceSetter(size, 1330, 1430, 1530, 1630);
            }
        }
        return -1;
    }

    public static int PriceSetter(int size, int price1, int price2, int price3, int price4) {
        if (price1 != 0 && size == 64) {
            return price1;
        }
        if (price2 != 0 && size == 128) {
            return price2;
        }
        if (price3 != 0 && size == 256) {
            return price3;
        }
        if (price4 != 0 && size == 512) {
            return price4;
        }
        return 0;
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
