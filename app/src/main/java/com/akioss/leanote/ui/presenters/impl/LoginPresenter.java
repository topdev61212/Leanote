package com.akioss.leanote.ui.presenters.impl;

import android.content.Context;

import com.akioss.leanote.common.Constants;
import com.akioss.leanote.common.GlobalSharePres;
import com.akioss.leanote.model.entities.AccountInfo;
import com.akioss.leanote.model.rest.DataSourceService;
import com.akioss.leanote.ui.mvpview.LoginView;
import com.akioss.leanote.ui.presenters.interfaces.ILoginPresenter;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

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
public class LoginPresenter implements ILoginPresenter {

    private final LoginView loginView;
    private GlobalSharePres sharePres;

    public LoginPresenter(LoginView loginView) {
        this.loginView = loginView;
        sharePres = new GlobalSharePres((Context) loginView, Constants.PRES_ACCOUNT);
    }

    @Override
    public void login(String email, String pwd) {
        if (email == null || pwd == null) {
            return;
        }

        loginView.showLoginProgress();
        DataSourceService.getInstance().authLogin(email, pwd)
                .enqueue(new Callback<AccountInfo>() {
                    @Override
                    public void onResponse(Response<AccountInfo> response, Retrofit retrofit) {
                        AccountInfo accountInfo = response.body();
                        loginView.hideLoginProgress();
                        if (!accountInfo.isOk()) {
                            loginView.showMsg(accountInfo.getMsg());
                        }else {
                            sharePres.saveString("token", accountInfo.getToken());
                            sharePres.saveString("userId", accountInfo.getUserId());
                            loginView.moveToMainActivity();
                        }
                    }

                    @Override
                    public void onFailure(Throwable t) {
                        loginView.hideLoginProgress();
                        loginView.showMsg(t.getMessage());
                    }
                });
    }

    @Override
    public void register(String email, String pwd) {

    }

    @Override
    public void findLostPwd() {

    }
}
