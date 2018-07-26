package com.qinsanjie.playandroid.constant;

import com.blankj.utilcode.util.AppUtils;

/**
 * @author qinsanjie
 * @date 18/7/26.
 * @desc
 */

public class PreferenceKeys {
    public static String KEY_SCHEME;

    static {
        KEY_SCHEME = AppUtils.getAppPackageName();
    }

    /**
     * 用户id
     */
    public static final String USER_ID = KEY_SCHEME + "user_id";
    /**
     * 上一个展示引导页的版本
     */
    public static final String LAST_SHOW_INTRODUCE_VERSION = KEY_SCHEME + "last_show_introduce_version";
    ;
}
