package com.akioss.leanote;

import android.app.Application;

import com.akioss.leanote.common.Constants;
import com.akioss.leanote.model.rest.DataSourceService;
import com.akioss.leanote.utils.logger.LogLevel;
import com.akioss.leanote.utils.logger.Logger;
import com.bumptech.glide.Glide;
import com.bumptech.glide.integration.okhttp.OkHttpUrlLoader;
import com.bumptech.glide.load.model.GlideUrl;
import com.tencent.bugly.crashreport.CrashReport;

import java.io.InputStream;

import cat.ereza.customactivityoncrash.CustomActivityOnCrash;

/*****************************************************************************************************************
 * Author: liyi
 * Create Date: 15/11/24.
 * Package: com.akioss.leanote
 * Discription:
 * Version: 1.0
 * ---------------------------------------------------------------------------------------------------------------
 * Modified By:
 * Modified Date:
 * Why & What is modified :
 *****************************************************************************************************************/
@SuppressWarnings("unused")
public class Leanote extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        /* Install CustomActivityOnCrash */
        CustomActivityOnCrash.install(this);
        /* glide初始化 */
        Glide.get(getApplicationContext()).register(GlideUrl.class, InputStream.class,
                new OkHttpUrlLoader.Factory(DataSourceService.getInstance().getClient()));
        /* bugly初始化 */
        CrashReport.initCrashReport(this, Constants.BuglyAppId, true);
        /* logger初始化 */
        Logger.init(Constants.APP_NAME)
                .logLevel(LogLevel.FULL)
                .methodCount(3);

    }

}
