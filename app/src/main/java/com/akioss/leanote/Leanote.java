package com.akioss.leanote;

import android.app.Application;

import com.akioss.leanote.common.AppConfig;
import com.akioss.leanote.common.Constants;
import com.akioss.leanote.utils.logger.LogLevel;
import com.akioss.leanote.utils.logger.Logger;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;
import com.tencent.bugly.crashreport.CrashReport;

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

    private RefWatcher refWatcher;
    private static Leanote application;

    public static Leanote get() {
        return application;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        application = (Leanote) getApplicationContext();
        /* Install CustomActivityOnCrash */
//        CustomActivityOnCrash.install(this);
        /* bugly初始化 */
        CrashReport.initCrashReport(this, Constants.BuglyAppId, true);
        /* logger初始化 */
        Logger.init(AppConfig.APP_NAME)
                .logLevel(LogLevel.FULL)
                .methodCount(3);

        refWatcher = LeakCanary.install(this);
    }

    public RefWatcher getRefWatcher() {
        return refWatcher;
    }
}
