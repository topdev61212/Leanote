package com.akioss.leanote.domain;

import android.content.Context;

import com.akioss.leanote.model.datasource.NetSource;
import com.akioss.leanote.model.datasource.UserApi;
import com.akioss.leanote.model.entities.AccountInfoEntity;

import rx.Observable;

/*****************************************************************************************************************
 * Author: liyi
 * Create Date: 16/2/1.
 * Package: com.akioss.leanote.domain
 * Discription:
 * Version: 1.0
 * ---------------------------------------------------------------------------------------------------------------
 * Modified By:
 * Modified Date:
 * Why & What is modified :
 *****************************************************************************************************************/
public class LoginUseCase extends UseCase<AccountInfoEntity> {

    private UserApi userService;

    private final String email;
    private final String pwd;

    public LoginUseCase(String email, String pwd) {
        this.email = email;
        this.pwd = pwd;
    }

    @Override
    public void attach(Context context) {
        super.attach(context);
        userService = NetSource.getInstance().createNetService(UserApi.class);
    }

    private Observable<AccountInfoEntity> authorLogin(String email, String pwd) {
        return userService.authLogin(email, pwd);
    }

    @Override
    public Observable<AccountInfoEntity> execute() {
        return authorLogin(email, pwd);
    }
}
