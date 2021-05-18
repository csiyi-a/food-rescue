package com.example.foodrescue;

import android.widget.EditText;

/**
 * ClassName: StringUtils
 * Description: 描述
 * Author: HuangGuoHua
 * Date: 2021/5/15 15:01
 */
public class StringUtils {

    public static boolean isNotNull(EditText editText){
        return editText.getText().toString().trim().length()!=0;
    }

    public static String getVal(EditText editText){
        return editText.getText().toString().trim();
    }
    public static String getMultiNumber(int number) {
        return number < 10 ? "0" + number : Integer.toString(number);
    }

    public static String getLocalMonth(int month) {
        return getMultiNumber(month + 1);
    }

    public static boolean isBlank(String src) {
        return src == null || src.trim().length() == 0;
    }
}
