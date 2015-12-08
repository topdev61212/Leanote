package com.akioss.leanote.ui.presenters.impl;

import android.content.Context;

import com.akioss.leanote.R;
import com.akioss.leanote.common.Constants;
import com.akioss.leanote.common.GlobalSharePres;
import com.akioss.leanote.model.entities.UserInfo;
import com.akioss.leanote.model.rest.DataSourceService;
import com.akioss.leanote.ui.mvpview.MainView;
import com.akioss.leanote.ui.presenters.interfaces.IMainPresenter;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

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
public class MainPresenter implements IMainPresenter {

    private final MainView mainView;
    private GlobalSharePres sharePres;

    public MainPresenter(MainView mainView) {
        this.mainView = mainView;
        sharePres = new GlobalSharePres((Context) mainView, Constants.PRES_ACCOUNT);
    }

    @Override
    public void getUserInfo() {
        DataSourceService.getInstance().getUserInfo(
                sharePres.loadString("userId"),
                sharePres.loadString("token")
        ).enqueue(new Callback<UserInfo>() {
            @Override
            public void onResponse(Response<UserInfo> response, Retrofit retrofit) {
                UserInfo userInfo = response.body();
                if (!userInfo.isOk()) {
                    mainView.showSnackMsg(userInfo.getMsg());
                } else {
                    mainView.setUpHeader(userInfo.getLogo(), userInfo.getUsername(),
                            userInfo.getEmail());
                }
            }

            @Override
            public void onFailure(Throwable t) {
                mainView.showSnackMsg(R.string.net_error);
            }
        });
    }
}
