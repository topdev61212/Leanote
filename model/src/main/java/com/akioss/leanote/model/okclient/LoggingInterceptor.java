package com.akioss.leanote.model.okclient;

import android.util.Log;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/*****************************************************************************************************************
 * Author: liyi
 * Create Date: 16/1/13.
 * Package: com.ebuymi.app.android.model.datasource
 * Discription:
 * Version: 1.0
 * ---------------------------------------------------------------------------------------------------------------
 * Modified By:
 * Modified Date:
 * Why & What is modified :
 *****************************************************************************************************************/
public class LoggingInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();

        Log.d("okhttp", "* Sending request to");
        Log.d("okhttp", request.url().toString());
        Log.d("okhttp", "* request headers:");
        Log.d("okhttp", request.headers().toString());

        Response response = chain.proceed(request);

        Log.d("okhttp", "* Received response from ");
        Log.d("okhttp", response.request().url().toString());
        Log.d("okhttp", "* response headers: ");
        Log.d("okhttp", response.headers().toString());

        return response;
    }
}
