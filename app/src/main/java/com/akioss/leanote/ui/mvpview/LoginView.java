package com.akioss.leanote.ui.mvpview;

/*****************************************************************************************************************
 * Author: liyi
 * Create Date: 15/12/2.
 * Package: com.akioss.leanote.ui.mvpview
 * Discription:
 * Version: 1.0
 * ---------------------------------------------------------------------------------------------------------------
 * Modified By:
 * Modified Date:
 * Why & What is modified :
 *****************************************************************************************************************/
public interface LoginView extends BaseView{

    void moveToMainActivity();

    void setEmailErrorMsg(String msg);

    void setPwdErrorMsg(String msg);
}
