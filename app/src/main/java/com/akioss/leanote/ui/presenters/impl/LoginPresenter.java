package com.akioss.leanote.ui.presenters.impl;

import android.content.Context;

import com.akioss.leanote.common.Constants;
import com.akioss.leanote.core.netsource.UserApi;
import com.akioss.leanote.model.entities.AccountInfoEntity;
import com.akioss.leanote.ui.mvpview.LoginView;
import com.akioss.leanote.ui.presenters.BasePresenter;
import com.akioss.leanote.utils.GlobalSharePres;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/*****************************************************************************************************************
 * Author: liyi
 * Create Date: 15/12/2.
 * Package: com.akioss.leanote.ui.presenters.impl
 * Discription:
 * Version: 1.0
 * ---------------------------------------------------------------------------------------------------------------
 * Modified By:
 * Modified Date:
 * Why & What is modified :
 *****************************************************************************************************************/
public class LoginPresenter extends BasePresenter {

    private final LoginView loginView;
    private GlobalSharePres sharePres;
    private UserApi userNetService;

    public LoginPresenter(LoginView loginView) {
        this.loginView = loginView;
    }

    @Override
    public void attach(Context context) {
        super.attach(context);
        sharePres = new GlobalSharePres(mContext, Constants.PRES_ACCOUNT);
        userNetService = netSource.createNetService(UserApi.class);
    }

    public void login(String email, String pwd) {
        if (email == null || pwd == null) {
            return;
        }

        loginView.setLoading(true);
        compositeSubscription.add(
                userNetService.authLogin(email, pwd)
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.io())
                        .subscribe(new Subscriber<AccountInfoEntity>() {
                            @Override
                            public void onCompleted() {
                                loginView.setLoading(false);
                            }

                            @Override
                            public void onError(Throwable e) {
                                loginView.setLoading(false);
                            }

                            @Override
                            public void onNext(AccountInfoEntity accountInfo) {
                                if (!accountInfo.Ok) {
                                    loginView.showMsg(accountInfo.Msg);
                                }else {
                                    sharePres.saveString("token", accountInfo.Token);
                                    sharePres.saveString("userId", accountInfo.UserId);
                                    loginView.moveToMainActivity();
                                }
                            }
                        })
        );
    }

    public void register(String email, String pwd) {

    }

    public void findLostPwd() {

    }

    @Override
    public void detach() {
        super.detach();
        sharePres = null;
    }
}
