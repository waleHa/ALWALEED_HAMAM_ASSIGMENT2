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
    static String IPHONE_KEY = "iPhone", OPPO_KEY = "Oppo", GOOGLE_PIXEL_KEY = "Google Pixel", SAMSUNG_KEY = "Samsung";
    static String IPHONE_14 = "14",IPHONE_14PRO="14 Pro",IPHONE_14MAX="14 Max";
    static String GOOGLE_PIXEL_6="Pixel 6",GOOGLE_PIXEL_6A="Pixel 6a",GOOGLE_PIXEL_6PRO="Pixel 6 Pro";
    static String OPPO_FIND_X3 = "Find X3", OPPO_FIND_X5 = "Find X5", OPPO_FIND_X5PRO = "Find X5 Pro";
    static String SAMSUNG_S22 = "S22", SAMSUNG_S22ULTRA = "S22 Ultra ", SAMSUNG_Z = "Z";

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

    public static ArrayList<Model> getIphoneLists() {
        ArrayList<Model> models = new ArrayList<>();
        models.add(new Model(Model.IPHONE_KEY, Model.IPHONE_14MAX, getIphonePrice(Model.IPHONE_14MAX,128), 128, "White", (R.drawable.iphone)));
        models.add(new Model(Model.IPHONE_KEY, Model.IPHONE_14, getIphonePrice(Model.IPHONE_14,128), 128, "Black", (R.drawable.iphone)));
        models.add(new Model(Model.IPHONE_KEY, Model.IPHONE_14PRO, getIphonePrice(Model.IPHONE_14PRO,128), 128, "Silver", (R.drawable.iphone)));
        return models;
    }

    public static ArrayList<Model> getPixelLists() {
        ArrayList<Model> models = new ArrayList<>();
        models.add(new Model(Model.GOOGLE_PIXEL_KEY, Model.GOOGLE_PIXEL_6, getPixelPrice(Model.GOOGLE_PIXEL_6,64), 64, "White", (R.drawable.pixel)));
        models.add(new Model(Model.GOOGLE_PIXEL_KEY, Model.GOOGLE_PIXEL_6A, getPixelPrice(Model.GOOGLE_PIXEL_6A,64), 64, "Black", (R.drawable.pixel)));
        models.add(new Model(Model.GOOGLE_PIXEL_KEY, Model.GOOGLE_PIXEL_6PRO, getPixelPrice(Model.GOOGLE_PIXEL_6PRO,64), 64, "Silver", (R.drawable.pixel)));
        return models;
    }

    public static ArrayList<Model> getOppoLists() {
        ArrayList<Model> models = new ArrayList<>();
        models.add(new Model(Model.OPPO_KEY, Model.OPPO_FIND_X3, getOppoPrice(OPPO_FIND_X3,64), 64, "White", (R.drawable.oppo)));
        models.add(new Model(Model.OPPO_KEY, Model.OPPO_FIND_X5, getOppoPrice(OPPO_FIND_X5,64), 64, "Black", (R.drawable.oppo)));
        models.add(new Model(Model.OPPO_KEY, Model.OPPO_FIND_X5PRO, getOppoPrice(OPPO_FIND_X5PRO,64), 64, "White", (R.drawable.oppo)));
        return models;
    }
    public static ArrayList<Model> getSamsungLists() {
        ArrayList<Model> models = new ArrayList<>();
        models.add(new Model(Model.SAMSUNG_KEY, Model.SAMSUNG_S22, getSamsungPrice(SAMSUNG_S22,64), 64, "White", (R.drawable.oppo)));
        models.add(new Model(Model.SAMSUNG_KEY, Model.SAMSUNG_S22ULTRA, getSamsungPrice(SAMSUNG_S22ULTRA,64), 64, "Black", (R.drawable.oppo)));
        models.add(new Model(Model.SAMSUNG_KEY, Model.SAMSUNG_Z, getSamsungPrice(SAMSUNG_Z,64), 64, "White", (R.drawable.oppo)));
        return models;
    }

    public static int getIphonePrice(String model, int size) {
        if (model == IPHONE_14) {
            if (size == 64) {
                return 2000;
            } else if (size == 128) {
                return 2200;
            } else if (size == 256) {
                return 2400;
            } else if (size == 512) {
                return 2550;
            }
        } else if (model == IPHONE_14PRO) {
            if (size == 64) {
                return 2300;
            } else if (size == 128) {
                return 2500;
            } else if (size == 256) {
                return 2700;
            } else if (size == 512) {
                return 2850;
            }
        }else if (model == IPHONE_14MAX) {
            if (size == 64) {
                return 2400;
            } else if (size == 128) {
                return 2600;
            } else if (size == 256) {
                return 2800;
            } else if (size == 512) {
                return 2950;
            }
        }
        return 0;
    }

    public static int getOppoPrice(String model, int size) {
        if (model == OPPO_FIND_X3) {
            if (size == 64) {
                return 1000;
            } else if (size == 128) {
                return 1100;
            } else if (size == 256) {
                return 1200;
            } else if (size == 512) {
                return 1350;
            }
        } else if (model == OPPO_FIND_X5) {
            if (size == 64) {
                return 1200;
            } else if (size == 128) {
                return 1300;
            } else if (size == 256) {
                return 1400;
            } else if (size == 512) {
                return 1550;
            }         } else if (model == OPPO_FIND_X5PRO) {
            if (size == 64) {
                return 1250;
            } else if (size == 128) {
                return 1350;
            } else if (size == 256) {
                return 1450;
            } else if (size == 512) {
                return 1590;
            }
        }
        return 0;
    }

    public static int getSamsungPrice(String model, int size) {
        if (model == SAMSUNG_S22) {
            if (size == 64) {
                return 1000;
            } else if (size == 128) {
                return 1100;
            } else if (size == 256) {
                return 1200;
            } else if (size == 512) {
                return 1350;
            }
        } else if (model == SAMSUNG_S22ULTRA) {
            if (size == 64) {
                return 1200;
            } else if (size == 128) {
                return 1200;
            } else if (size == 256) {
                return 1300;
            } else if (size == 512) {
                return 1450;
            }
        } else if (model == SAMSUNG_Z) {
            if (size == 64) {
                return 1330;
            } else if (size == 128) {
                return 1430;
            } else if (size == 256) {
                return 1530;
            } else if (size == 512) {
                return 1630;
            }
        }

        return 0;
    }

    public static int getPixelPrice(String model, int size) {
        if (model == "Pixel 6") {
            if (size == 64) {
                return 1000;
            } else if (size == 128) {
                return 1100;
            } else if (size == 256) {
                return 1200;
            } else if (size == 512) {
                return 1350;
            }
        } else if (model == "Pixel 6 Pro") {
            if (size == 64) {
                return 1200;
            } else if (size == 128) {
                return 1200;
            } else if (size == 256) {
                return 1300;
            } else if (size == 512) {
                return 1450;
            }
        } else if (model == "Pixel 6a") {
            if (size == 64) {
                return 1330;
            } else if (size == 128) {
                return 1430;
            } else if (size == 256) {
                return 1530;
            } else if (size == 512) {
                return 1630;
            }
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
