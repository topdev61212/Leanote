package com.akioss.leanote.model.datasource.okclient;

import com.akioss.leanote.Leanote;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/*****************************************************************************************************************
 * Author: liyi
 * Create Date: 16/1/28.
 * Package: com.akioss.leanote.model.okclient
 * Discription:
 * Version: 1.0
 * ---------------------------------------------------------------------------------------------------------------
 * Modified By:
 * Modified Date:
 * Why & What is modified :
 *****************************************************************************************************************/
public class OkClientInstance {
    private static volatile OkHttpClient _client;

    public static OkHttpClient getClient() {
        if (_client == null) {
            synchronized (OkClientInstance.class) {
                if (_client == null) {
                    _client = new OkHttpClient.Builder()
                            .cookieJar(new CookiesManager(Leanote.get()))
                            .addNetworkInterceptor(new LoggingInterceptor())
                            .connectTimeout(10, TimeUnit.SECONDS)
                            .writeTimeout(10, TimeUnit.SECONDS)
                            .readTimeout(30, TimeUnit.SECONDS)
                            .build();
                }
            }
        }

        return _client;
    }
}
