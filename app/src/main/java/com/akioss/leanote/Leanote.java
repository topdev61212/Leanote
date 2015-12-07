package com.akioss.leanote;

import android.app.Application;

import com.akioss.leanote.common.Constants;
import com.akioss.leanote.utils.logger.Logger;
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

    @Override
    public void onCreate() {
        super.onCreate();

        /* bugly初始化 */
        CrashReport.initCrashReport(this, Constants.BuglyAppId, true);
        /* logger初始化 */
        Logger.init(Constants.APP_NAME)
                .methodCount(3);
    }

}
