package com.akioss.leanote.presenters.impl;

import android.content.Context;

import com.akioss.leanote.common.Constants;
import com.akioss.leanote.model.datasource.net.UserApi;
import com.akioss.leanote.model.entity.UserInfoEntity;
import com.akioss.leanote.presenters.BasePresenter;
import com.akioss.leanote.ui.mvpview.MainView;
import com.akioss.leanote.utils.GlobalSharePres;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/*****************************************************************************************************************
 * Author: liyi
 * Create Date: 15/12/7.
 * Package: com.akioss.leanote.ui.presenters.impl
 * Discription:
 * Version: 1.0
 * ---------------------------------------------------------------------------------------------------------------
 * Modified By:
 * Modified Date:
 * Why & What is modified :
 *****************************************************************************************************************/
public class MainPresenter extends BasePresenter {

    private final MainView mainView;
    private GlobalSharePres sharePres;
    private UserApi userNetService;

    public MainPresenter(MainView mainView) {
        this.mainView = mainView;
    }

    @Override
    public void attach(Context context) {
        super.attach(context);
        sharePres = new GlobalSharePres(mContext, Constants.PRES_ACCOUNT);
        userNetService = netSource.createNetService(UserApi.class);
    }

    public void getUserInfo() {
        compositeSubscription.add(
                userNetService.getUserInfo(sharePres.loadString("userId"), sharePres.loadString("token"))
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.io())
                        .filter(new Func1<UserInfoEntity, Boolean>() {
                            @Override
                            public Boolean call(UserInfoEntity userInfo) {
                                return userInfo.isOk();
                            }
                        })
                        .subscribe(new Subscriber<UserInfoEntity>() {
                            @Override
                            public void onCompleted() {

                            }

                            @Override
                            public void onError(Throwable e) {
                                mainView.showMsg(e.getMessage());
                            }

                            @Override
                            public void onNext(UserInfoEntity userInfo) {
                                mainView.setUpHeader(userInfo.getLogo(), userInfo.getUsername(),
                                        userInfo.getEmail());
                            }
                        })
        );
    }

    @Override
    public void detach() {
        super.detach();
        sharePres = null;
    }
}
