package com.wa7a.assignment2.constants;


import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.wa7a.assignment2.R;
import com.wa7a.assignment2.model.Phone;

import java.util.ArrayList;

public class Constant {
    public static final String IPHONE_TITLE = "iPhone";
    public static final String OPPO_TITLE = "Oppo";
    public static final String GOOGLE_PIXEL_TITLE = "Google Pixel";
    public static final String SAMSUNG_TITLE = "Samsung";
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


    public static ArrayList<Phone> getLists(String brand) {
        ArrayList<Phone> phones = new ArrayList<>();
        int defaultSize = 64;
        int photo;
        int price1, price2, price3;

        if (brand.equals(Constant.IPHONE_TITLE)) {
            photo = (R.drawable.iphone);
            defaultSize = 128;
            price1 = getPrice(brand, Constant.IPHONE_14MAX, defaultSize);
            price2 = getPrice(brand, Constant.IPHONE_14, defaultSize);
            price3 = getPrice(brand, Constant.IPHONE_14PRO, defaultSize);
            phones.add(new Phone(brand, Constant.IPHONE_14MAX, price1, defaultSize, photo));
            phones.add(new Phone(brand, Constant.IPHONE_14, price2, defaultSize, photo));
            phones.add(new Phone(brand, Constant.IPHONE_14PRO, price3, defaultSize, photo));
        } else if (brand.equals(Constant.SAMSUNG_TITLE)) {
            photo = (R.drawable.samsung);
            price1 = getPrice(brand, Constant.SAMSUNG_S22, defaultSize);
            phones.add(new Phone(brand, Constant.SAMSUNG_S22, price1, defaultSize, photo));
            price2 = getPrice(brand, Constant.SAMSUNG_S22ULTRA, defaultSize);
            phones.add(new Phone(brand, Constant.SAMSUNG_S22ULTRA, price2, defaultSize, photo));
            price3 = getPrice(brand, Constant.SAMSUNG_Z, defaultSize);
            phones.add(new Phone(brand, Constant.SAMSUNG_Z, price3, defaultSize, photo));
        } else if (brand.equals(Constant.OPPO_TITLE)) {
            photo = (R.drawable.oppo);
            price1 = getPrice(brand, Constant.OPPO_FIND_X3, defaultSize);
            phones.add(new Phone(brand, Constant.OPPO_FIND_X3, price1, defaultSize, photo));
            price2 = getPrice(brand, Constant.OPPO_FIND_X5, defaultSize);
            phones.add(new Phone(brand, Constant.OPPO_FIND_X5, price2, defaultSize, photo));
            price3 = getPrice(brand, Constant.OPPO_FIND_X5PRO, defaultSize);
            phones.add(new Phone(brand, Constant.OPPO_FIND_X5PRO, price3, defaultSize, photo));
        } else if (brand.equals(Constant.GOOGLE_PIXEL_TITLE)) {
            photo = (R.drawable.pixel);
            price1 = getPrice(brand, Constant.GOOGLE_PIXEL_6, defaultSize);
            phones.add(new Phone(brand, Constant.GOOGLE_PIXEL_6, price1, defaultSize, photo));
            price2 = getPrice(brand, Constant.GOOGLE_PIXEL_6A, defaultSize);
            phones.add(new Phone(brand, Constant.GOOGLE_PIXEL_6A, price2, defaultSize, photo));
            price3 = getPrice(brand, Constant.GOOGLE_PIXEL_6PRO, defaultSize);
            phones.add(new Phone(brand, Constant.GOOGLE_PIXEL_6PRO, price3, defaultSize, photo));
        }
        return phones;
    }


    public static int priceSetter(int size, int price1, int price2, int price3, int price4) {
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

    public static int getPrice(String brand, String model, int size) {
        int price1 = 0, price2 = 0, price3 = 0, price4 = 0;
        if (brand.equals(Constant.IPHONE_TITLE)) {
            if (model.equals(Constant.IPHONE_14)) {
                price1 = 2000;
                price2 = 2200;
                price3 = 2550;
                price4 = 2550;
            } else if (model.equals(Constant.IPHONE_14PRO)) {
                price1 = 2300;
                price2 = 2500;
                price3 = 2750;
                price4 = 2850;
            } else if (model.equals(Constant.IPHONE_14MAX)) {
                price1 = 2400;
                price2 = 2600;
                price3 = 2800;
                price4 = 2950;
            }
        } else if (brand.equals(Constant.GOOGLE_PIXEL_TITLE)) {
            if (model.equals(Constant.GOOGLE_PIXEL_6)) {
                price1 = 1000;
                price2 = 1100;
                price3 = 1200;
                price4 = 1350;
            } else if (model.equals(Constant.GOOGLE_PIXEL_6PRO)) {
                price1 = 1100;
                price2 = 1200;
                price3 = 1300;
                price4 = 1350;
            } else if (model.equals(Constant.GOOGLE_PIXEL_6A)) {
                price1 = 1330;
                price2 = 1430;
                price3 = 1530;
                price4 = 1630;
            }
        } else if (brand.equals(Constant.OPPO_TITLE)) {
            if (model.equals(Constant.OPPO_FIND_X3)) {
                price1 = 1000;
                price2 = 1100;
                price3 = 1250;
                price4 = 1350;
            } else if (model.equals(Constant.OPPO_FIND_X5)) {
                price1 = 1200;
                price2 = 1300;
                price3 = 1450;
                price4 = 15550;
            } else if (model.equals(Constant.OPPO_FIND_X5PRO)) {
                price1 = 1250;
                price2 = 1350;
                price3 = 1450;
                price4 = 1590;
            }
        } else if (brand.equals(Constant.SAMSUNG_TITLE)) {
            if (model.equals(Constant.SAMSUNG_S22)) {
                price1 = 1000;
                price2 = 1100;
                price3 = 1250;
                price4 = 1350;

            } else if (model.equals(Constant.SAMSUNG_S22ULTRA)) {
                price1 = 1110;
                price2 = 1200;
                price3 = 1330;
                price4 = 1470;
            } else if (model.equals(Constant.SAMSUNG_Z)) {
                price1 = 1330;
                price2 = 1430;
                price3 = 1530;
                price4 = 1640;
            }
        }
        return Constant.priceSetter(size, price1, price2, price3, price4);
    }

}
