package com.akioss.leanote.common;

import android.app.Activity;
import android.content.Context;
import android.os.Process;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/*****************************************************************************************************************
 * Author: liyi
 * Create Date: 16/2/23.
 * Package: com.akioss.leanote.common
 * Discription:
 * Version: 1.0
 * ---------------------------------------------------------------------------------------------------------------
 * Modified By:
 * Modified Date:
 * Why & What is modified :
 *****************************************************************************************************************/
public class AppManager {
    private static List<WeakReference<Activity>> activityList = new ArrayList<>();

    public static void add(WeakReference<Activity> weakActivity) {
        if (weakActivity == null) {
            return;
        }
        activityList.add(weakActivity);
    }

    public static void remove(WeakReference<Activity> weakActivity) {
        if (weakActivity == null) {
            return;
        }
        activityList.remove(weakActivity);
    }

    public static void exitClient(Context context){
        for(WeakReference<Activity> item: activityList){
            if (item.get() != null) {
                item.get().finish();
            }
        }
        Process.killProcess(Process.myPid());
    }
}
