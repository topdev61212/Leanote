package com.akioss.leanote.ui.presenters;

import android.app.Activity;
import android.content.Context;

/*****************************************************************************************************************
 * Author: liyi
 * Create Date: 15/12/11.
 * Package: com.akioss.leanote.ui.presenters
 * Discription:
 * Version: 1.0
 * ---------------------------------------------------------------------------------------------------------------
 * Modified By:
 * Modified Date:
 * Why & What is modified :
 *****************************************************************************************************************/
public abstract class BasePresenter {

    protected Context mContext;

    public void attach(Context context) {
        mContext = context;
    }

    /**
     * 在Fragment的onDestroy中调用.用于注销广播接收器等</br>
     */
    public void detach() {
        mContext = null;
    }

    protected boolean isActivityAlive() {
        if (mContext instanceof Activity) {
            Activity activity = (Activity) mContext;
            return !activity.isFinishing();
        }
        return false;
    }

}
