package cn.evendy.uniots.utils;

import android.content.Context;

/**
 * Created by evendy .
 */
public class AppUtils {
    public static String getAppVersionName(Context context) {
        try {
            String pkName = context.getPackageName();
            String versionName = context.getPackageManager().getPackageInfo(
                    pkName, 0).versionName;
            return versionName;
        } catch (Exception e) {
        }
        return "";
    }
}
