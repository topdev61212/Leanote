package com.akioss.leanote.model.datasource.net;

import com.akioss.leanote.common.AppConfig;
import com.akioss.leanote.model.datasource.okclient.OkClientInstance;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.sql.DataSource;

import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;
import retrofit2.RxJavaCallAdapterFactory;

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
public class NetSource{
    private static NetSource netSource;
    private Gson gson;

    public static NetSource getInstance() {
        if (netSource == null) {
            synchronized (DataSource.class) {
                if (netSource == null) {
                    netSource = new NetSource();
                }
            }
        }
        return netSource;
    }

    private NetSource() {
        gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd HH:mm:ss")
                .enableComplexMapKeySerialization() //支持Map的key为复杂对象的形式
                .serializeNulls()
                .create();
    }

    public <S> S createNetService(Class<S> clazz) {
         Retrofit retrofit = new Retrofit.Builder()
                .client(OkClientInstance.getClient())
                .baseUrl(AppConfig.URL_BASE)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return retrofit.create(clazz);
    }

}

