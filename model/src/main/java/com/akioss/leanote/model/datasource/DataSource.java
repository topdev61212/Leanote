package com.akioss.leanote.model.datasource;

import com.akioss.leanote.common.AppConfig;
import com.akioss.leanote.model.entities.AccountInfoEntity;
import com.akioss.leanote.model.entities.BaseInfoEntity;
import com.akioss.leanote.model.entities.NoteItemEntity;
import com.akioss.leanote.model.entities.UserInfoEntity;
import com.akioss.leanote.model.okclient.OkClientInstance;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.util.List;

import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;
import retrofit2.RxJavaCallAdapterFactory;
import rx.Observable;

/*****************************************************************************************************************
 * Author: liyi
 * Create Date: 16/1/27.
 * Package: com.akioss.leanote.model.datasource
 * Discription:
 * Version: 1.0
 * ---------------------------------------------------------------------------------------------------------------
 * Modified By:
 * Modified Date:
 * Why & What is modified :
 *****************************************************************************************************************/
public class DataSource implements UserApi,NoteApi{
    private static DataSource dataSource;
    private final UserApi userApiService;
    private final NoteApi noteApiService;

    public static DataSource getInstance() {
        if (dataSource == null) {
            synchronized (DataSource.class) {
                if (dataSource == null) {
                    dataSource = new DataSource();
                }
            }
        }
        return dataSource;
    }

    private DataSource() {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd HH:mm:ss")
                .enableComplexMapKeySerialization() //支持Map的key为复杂对象的形式
                .serializeNulls()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .client(OkClientInstance.getClient())
                .baseUrl(AppConfig.URL_BASE)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        userApiService = retrofit.create(UserApi.class);
        noteApiService = retrofit.create(NoteApi.class);
    }

    @Override
    public Observable<List<NoteItemEntity>> getNotes(int afterUsn, int maxEntry, String token) {
        return noteApiService.getNotes(afterUsn, maxEntry ,token);
    }

    @Override
    public Observable<AccountInfoEntity> authLogin(String email, String pwd) {
        return userApiService.authLogin(email, pwd);
    }

    @Override
    public Observable<BaseInfoEntity> logout(String token) {
        return userApiService.logout(token);
    }

    @Override
    public Observable<BaseInfoEntity> register(String email, String pwd) {
        return userApiService.register(email, pwd);
    }

    @Override
    public Observable<UserInfoEntity> getUserInfo(String userId, String token) {
        return userApiService.getUserInfo(userId, token);
    }

    @Override
    public Observable<BaseInfoEntity> updateUsername(String userName, String token) {
        return userApiService.updateUsername(userName, token);
    }

    @Override
    public Observable<BaseInfoEntity> updatePwd(String oldPwd, String newPwd, String token) {
        return userApiService.updatePwd(oldPwd, newPwd, token);
    }

    @Override
    public Observable<BaseInfoEntity> updateLogo(File file) {
        return userApiService.updateLogo(file);
    }

}

