package com.akioss.leanote.core.presenters;

import android.content.Context;

import com.akioss.leanote.model.datasource.DataSource;

import rx.subscriptions.CompositeSubscription;

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
    protected DataSource dataSource;
    protected CompositeSubscription compositeSubscription;

    public void attach(Context context) {
        mContext = context;
        dataSource = DataSource.getInstance();
        compositeSubscription = new CompositeSubscription();
    }

    /**
     * 在Fragment的onDestroy中调用.用于注销广播接收器等</br>
     */
    public void detach() {
        mContext = null;
        if (compositeSubscription != null) {
            compositeSubscription.unsubscribe();
            compositeSubscription = null;
        }
    }

}
