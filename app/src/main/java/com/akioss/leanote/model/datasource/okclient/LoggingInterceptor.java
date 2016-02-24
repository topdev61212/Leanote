package com.akioss.leanote.model.datasource.okclient;

import com.akioss.leanote.utils.logger.Logger;

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

//        Logger.d("Sending request to");
//        Logger.d(request.url().toString());
//        Logger.d("request headers:");
//        Logger.d(request.headers().toString());

        Response response = chain.proceed(request);

//        Logger.d("Received response from ");
//        Logger.d(response.request().url().toString());
//        Logger.d("response headers: ");
//        Logger.d(response.headers().toString());
        Logger.d(response.body().toString());

        return response;
    }
}
