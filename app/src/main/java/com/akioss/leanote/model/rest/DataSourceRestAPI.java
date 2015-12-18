package com.akioss.leanote.model.rest;

import com.akioss.leanote.model.entities.AccountInfo;
import com.akioss.leanote.model.entities.BaseInfo;
import com.akioss.leanote.model.entities.NoteItem;
import com.akioss.leanote.model.entities.UserInfo;

import java.io.File;
import java.util.List;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Multipart;
import retrofit.http.POST;
import retrofit.http.Part;
import retrofit.http.Query;

/*****************************************************************************************************************
 * Author: liyi
 * Create Date: 15/11/26.
 * Package: com.akioss.leanote.model.rest
 * Discription:
 * Version: 1.0
 * ---------------------------------------------------------------------------------------------------------------
 * Modified By:
 * Modified Date:
 * Why & What is modified :
 *****************************************************************************************************************/
@SuppressWarnings("unused")
public interface DataSourceRestAPI {

    @GET("auth/login")
    Call<AccountInfo> authLogin(
            @Query("email") String email,
            @Query("pwd") String pwd
    );

    @GET("auth/logout")
    Call<BaseInfo> logout(
            @Query("token") String token
    );

    @POST("auth/register")
    Call<BaseInfo> register(
            @Query("email") String email,
            @Query("pwd") String pwd
    );

    @GET("user/info")
    Call<UserInfo> getUserInfo(
            @Query("userId") String userId,
            @Query("token") String token
    );

    @POST("user/updateUsername")
    Call<BaseInfo> updateUsername(
            @Query("username") String userName,
            @Query("token") String token
    );

    @POST("user/updatePwd")
    Call<BaseInfo> updatePwd(
            @Query("oldPwd") String oldPwd,
            @Query("newPwd") String newPwd,
            @Query("token") String token
    );

    @Multipart
    @POST("user/updateLogo")
    Call<BaseInfo> updateLogo(
            @Part("file") File file
    );

    @GET("note/getSyncNotes")
    Call<List<NoteItem>> getNotes(
            @Query("afterUsn") int afterUsn,
            @Query("maxEntry") int maxEntry,
            @Query("token") String token
    );
}
