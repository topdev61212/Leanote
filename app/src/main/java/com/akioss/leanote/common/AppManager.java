package com.akioss.leanote.common;

import android.app.Activity;

import java.lang.ref.WeakReference;
import java.util.Stack;

/*****************************************************************************************************************
 * Author: liyi
 * Create Date: 15/12/2.
 * Package: com.akioss.leanote.common
 * Discription:
 * Version: 1.0
 * ---------------------------------------------------------------------------------------------------------------
 * Modified By:
 * Modified Date:
 * Why & What is modified :
 *****************************************************************************************************************/
@SuppressWarnings("unused")
public class AppManager {
    /* 管理activity栈 */
    private static Stack<WeakReference<Activity>> activitys = new Stack<>();

    /**
     * 将activity弱引用压入栈中
     * @param task activity弱引用
     */
    public static void pushTask(WeakReference<Activity> task) {
        activitys.push(task);
    }

    /**
     * 将传入的Activity对象从栈中移除
     * @param task activity弱引用
     */
    public static void removeTask(WeakReference<Activity> task) {
        activitys.remove(task);
    }

    /**
     * 根据指定位置从栈中移除Activity
     * @param taskIndex Activity栈索引
     */
    public static void removeTask(int taskIndex) {
        if (activitys.size() > taskIndex)
            activitys.remove(taskIndex);
    }

    /**
     * 将栈中Activity移除至栈顶
     */
    public static void removeToTop() {
        int end = activitys.size();
        int start = 1;
        for (int i = end - 1; i >= start; i--) {
            Activity mActivity = activitys.get(i).get();
            if(null != mActivity && !mActivity.isFinishing()){
                mActivity.finish();
            }
        }
    }

    /**
     * 移除全部（用于整个应用退出）
     */
    public static void removeAll() {
        //finish所有的Activity
        for (WeakReference<Activity> task : activitys) {
            Activity mActivity = task.get();
            if(null != mActivity && !mActivity.isFinishing()){
                mActivity.finish();
            }
        }
    }

    /**
     * 应用完全退出
     */
    public static void exit() {
        try{
            //stop service
            // TODO: 15/11/30

            //cancel httprequest
            // TODO: 15/11/30

            removeAll();
            System.exit(0);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
