package com.akioss.leanote.core.presenters.impl;

import android.content.Context;

import com.akioss.leanote.common.Constants;
import com.akioss.leanote.core.mvpview.LoginView;
import com.akioss.leanote.core.presenters.BasePresenter;
import com.akioss.leanote.core.presenters.interfaces.ILoginPresenter;
import com.akioss.leanote.model.entities.AccountInfoEntity;
import com.akioss.leanote.utils.GlobalSharePres;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
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
public class LoginPresenter extends BasePresenter implements ILoginPresenter {

    private final LoginView loginView;
    private GlobalSharePres sharePres;

    public LoginPresenter(LoginView loginView) {
        this.loginView = loginView;
    }

    @Override
    public void attach(Context context) {
        super.attach(context);
        sharePres = new GlobalSharePres(mContext, Constants.PRES_ACCOUNT);
    }

    @Override
    public void login(String email, String pwd) {
        if (email == null || pwd == null) {
            return;
        }

        loginView.setLoading(true);
        compositeSubscription.add(
                dataSource.authLogin(email, pwd)
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.io())
                        .filter(new Func1<AccountInfoEntity, Boolean>() {
                            @Override
                            public Boolean call(AccountInfoEntity accountInfo) {
                                return null;
                            }
                        })
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

    @Override
    public void register(String email, String pwd) {

    }

    @Override
    public void findLostPwd() {

    }

    @Override
    public void detach() {
        super.detach();
        sharePres = null;
    }
}
