package com.akioss.leanote.model.datasource.net;


import com.akioss.leanote.model.entity.AccountInfoEntity;
import com.akioss.leanote.model.entity.BaseInfoEntity;
import com.akioss.leanote.model.entity.SyncStateEntity;
import com.akioss.leanote.model.entity.UserInfoEntity;

import java.io.File;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
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

    @FormUrlEncoded
    @POST("auth/register")
    Observable<BaseInfoEntity> register(
            @Field("email") String email,
            @Field("pwd") String pwd
    );

    @GET("user/info")
    Observable<UserInfoEntity> getUserInfo(
            @Query("userId") String userId,
            @Query("token") String token
    );

    @FormUrlEncoded
    @POST("user/updateUsername")
    Observable<BaseInfoEntity> updateUsername(
            @Field("username") String userName,
            @Field("token") String token
    );

    @FormUrlEncoded
    @POST("user/updatePwd")
    Observable<BaseInfoEntity> updatePwd(
            @Field("oldPwd") String oldPwd,
            @Field("newPwd") String newPwd,
            @Field("token") String token
    );

    @Multipart
    @POST("user/updateLogo")
    Observable<BaseInfoEntity> updateLogo(
            @Part("file") File file
    );

    @GET("user/getSyncState")
    Observable<SyncStateEntity> getSyncState();
}
