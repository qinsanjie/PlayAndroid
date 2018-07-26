package com.qinsanjie.playandroid.constant;

import com.blankj.utilcode.util.AppUtils;

/**
 */
public class BundleConstants {
    public static String PRE_KEY = "";

    static {
        PRE_KEY = AppUtils.getAppPackageName();
    }
    /**
     * 数据传输
     **/
    public static final String INTEGER = PRE_KEY + "INTEGER";
    public static final String LONG = PRE_KEY + "LONG";
    public static final String BOOLEAN = PRE_KEY + "BOOLEAN";
    public static final String STRING = PRE_KEY + "STRING";
    public static final String OBJECT = PRE_KEY + "OBJECT";
    public static final String BUNDLE = PRE_KEY + "BUNDLE";

}
