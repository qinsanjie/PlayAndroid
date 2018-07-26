package com.qinsanjie.playandroid.utils;

import android.app.Activity;

import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.AppUtils;
import com.blankj.utilcode.util.SPUtils;
import com.qinsanjie.playandroid.constant.PreferenceKeys;
import com.qinsanjie.playandroid.mvp.ui.activity.IntroduceAppActivity;
import com.qinsanjie.playandroid.mvp.ui.activity.MainActivity;

/**
 * @author qinsanjie
 * @date 17/7/26.
 * @desc 处理APP的页面跳转
 */

public class AppRouter {
    /**
     * 登录路由，引导用户该展示哪个页面
     *
     * @param context 上下文
     */
    public static void loginRoute(Activity context) {
        String lastShowIntroduceVersion = SPUtils.getInstance().getString(PreferenceKeys.LAST_SHOW_INTRODUCE_VERSION);

        if (!AppUtils.getAppVersionName().equals(lastShowIntroduceVersion)) {//同一个版本，说明已经展示过了，不同版本，需要展示
            ActivityUtils.startActivity(IntroduceAppActivity.class);
        } else {
            long userId = SPUtils.getInstance().getLong(PreferenceKeys.USER_ID, 0);
            if (userId == 0) {//用户为零，说明还没有登录
                ActivityUtils.startActivity(MainActivity.class);
            } else {
                ActivityUtils.startActivity(MainActivity.class);
            }
        }
        //关闭页面
        if (context != null && !context.isFinishing()) {
            context.finish();
        }
    }
}
