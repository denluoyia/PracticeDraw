package com.hencoder.hencoderpracticedraw1;

import android.content.Context;

public class UIUtil {

    public static int dp2px(Context context, float dipValue){
        float scale = context.getResources().getDisplayMetrics().density;
        return (int)(scale * dipValue + 0.5f);
    }

    public static float px2dp(Context context, int pxValue){
        float scale = context.getResources().getDisplayMetrics().density;
        return (float)(pxValue / scale + 0.5f);
    }
}
