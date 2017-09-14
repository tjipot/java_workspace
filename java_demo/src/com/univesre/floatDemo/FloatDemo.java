package com.univesre.floatDemo;

import java.text.DecimalFormat;

/**
 * Created by HY on 17-9-9.
 */
public class FloatDemo {


    public static void main(String[] args) {

        float aVirtualPrice = (float) 11.1111;
        int itemNum = 3;
        float totalPrice = aVirtualPrice * itemNum;
        System.out.println(totalPrice);
        System.out.println(Math.round(totalPrice * 100)/100);
        float finalPrice = (float)(Math.round(totalPrice * 100)) / 100;
        System.out.println(finalPrice);

        float aFloatNumber = (float) 1.2;
        DecimalFormat decimalFormat = new DecimalFormat(".00"); // 告诉构造方法要2位小数格式的字串, 如果小数不足2位, 以0补足;
        String floatFormatStr = decimalFormat.format(aFloatNumber); // 返回2位精度的浮点字串;
        System.out.println(floatFormatStr);

    }

}
