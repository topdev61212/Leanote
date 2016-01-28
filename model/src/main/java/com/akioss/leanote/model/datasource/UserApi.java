package com.akioss.leanote.model.datasource;

import com.akioss.leanote.model.entities.AccountInfoEntity;
import com.akioss.leanote.model.entities.BaseInfoEntity;
import com.akioss.leanote.model.entities.UserInfoEntity;

import java.io.File;

import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;
import rx.Observable;

/*****************************************************************************************************************
 * Author: liyi
 * Create Date: 16/1/28.
 * Package: com.akioss.leanote.model.datasource
 * Discription:
 * Version: 1.0
 * ---------------------------------------------------------------------------------------------------------------
 * Modified By:
 * Modified Date:
 * Why & What is modified :
 *****************************************************************************************************************/
@SuppressWarnings("unused")
public interface UserApi {
    @GET(("auth/login"))
    Observable<AccountInfoEntity> authLogin(
            @Query("email") String email,
            @Query("pwd") String pwd
    );

    @GET("auth/logout")
    Observable<BaseInfoEntity> logout(
            @Query("token") String token
    );

    @POST("auth/register")
    Observable<BaseInfoEntity> register(
            @Query("email") String email,
            @Query("pwd") String pwd
    );

    @GET("user/info")
    Observable<UserInfoEntity> getUserInfo(
            @Query("userId") String userId,
            @Query("token") String token
    );

    @POST("user/updateUsername")
    Observable<BaseInfoEntity> updateUsername(
            @Query("username") String userName,
            @Query("token") String token
    );

    @POST("user/updatePwd")
    Observable<BaseInfoEntity> updatePwd(
            @Query("oldPwd") String oldPwd,
            @Query("newPwd") String newPwd,
            @Query("token") String token
    );

    @Multipart
    @POST("user/updateLogo")
    Observable<BaseInfoEntity> updateLogo(
            @Part("file") File file
    );
}
