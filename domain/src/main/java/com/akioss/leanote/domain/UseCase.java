package com.akioss.leanote.domain;

import android.content.Context;

import rx.Observable;
import rx.subscriptions.CompositeSubscription;

/*****************************************************************************************************************
 * Author: liyi
 * Create Date: 16/1/30.
 * Package: com.akioss.leanote.domain
 * Discription:
 * Version: 1.0
 * ---------------------------------------------------------------------------------------------------------------
 * Modified By:
 * Modified Date:
 * Why & What is modified :
 *****************************************************************************************************************/
public abstract class UseCase<R> {

    protected Context mContext;
    protected CompositeSubscription compositeSubscription;

    public void attach(Context context) {
        if (context != null) {
            mContext = context;
        }
        compositeSubscription = new CompositeSubscription();
    }

    public void detach() {
        if (mContext != null) {
            mContext = null;
        }
        compositeSubscription.unsubscribe();
    }

    abstract Observable<R> execute();

}
