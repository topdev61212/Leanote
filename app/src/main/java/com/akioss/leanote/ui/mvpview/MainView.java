package com.akioss.leanote.ui.mvpview;

import android.support.annotation.StringRes;

/*****************************************************************************************************************
 * Author: liyi
 * Create Date: 15/12/7.
 * Package: com.akioss.leanote.ui.mvpview
 * Discription:
 * Version: 1.0
 * ---------------------------------------------------------------------------------------------------------------
 * Modified By:
 * Modified Date:
 * Why & What is modified :
 *****************************************************************************************************************/
public interface MainView {

    void setUpHeader(String logoUrl, String userName, String email);

    void showProgress();

    void hideProgress();

    void showSnackMsg(String msg);

    void showSnackMsg(@StringRes int resId);
}
