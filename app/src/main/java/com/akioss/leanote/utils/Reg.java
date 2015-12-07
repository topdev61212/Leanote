package com.akioss.leanote.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*****************************************************************************************************************
 * Author: liyi
 * Create Date: 15/12/4.
 * Package: com.akioss.leanote.utils
 * Discription:
 * Version: 1.0
 * ---------------------------------------------------------------------------------------------------------------
 * Modified By:
 * Modified Date:
 * Why & What is modified :
 *****************************************************************************************************************/
@SuppressWarnings("unused")
public class Reg {
    /**
     * 邮箱验证
     * @param strEmail
     * @return isEmail
     */
    public static boolean isEmail(String strEmail) {
        String strPattern = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";
        Pattern p = Pattern.compile(strPattern);
        Matcher m = p.matcher(strEmail);
        return m.matches();
    }

    /**
     * 手机号格式验证
     * @param mobile 要验证的字符
     * @return isMobile
     */
    public static boolean isMobile(String mobile) {
        String strPattern = "^(0|(\\+)?86|17951)?(13[0-9]|15[012356789]|17[678]|18[0-9]|14[57])[0-9]{8}$";
        Pattern p = Pattern.compile(strPattern);
        Matcher m = p.matcher(mobile);
        return m.matches();
    }

    /**
     * 数字验证
     * @param numStr
     * @return isNumber
     */
    public static boolean isNumber(String numStr) {
        String strPattern = "^[0-9]*$";
        Pattern p = Pattern.compile(strPattern);
        Matcher m = p.matcher(numStr);
        return m.matches();
    }

    /**
     * 金钱格式验证
     * @param money
     * @return isMoney
     */
    public static boolean isMoney(String money){
        //^(-)?[1-9]([0-9]+)(\.?[0-9]{2})$|^(-)?0\.[1-9]{2}$
        String strPattern = "^(-)?[1-9]([0-9]+)(\\.?[0-9]{2})$|^(-)?0\\.[1-9]{2}$";
        Pattern p = Pattern.compile(strPattern);
        Matcher m = p.matcher(money);
        return m.matches();
    }

    /**
     * 用户名格式验证
     * @param username
     * @return isUsername
     */
    public static boolean isUsername(String username){
        String strPattern = "^[a-zA-Z0-9_]{6,18}$";
        Pattern p = Pattern.compile(strPattern);
        Matcher m = p.matcher(username);
        return m.matches();
    }

    /**
     * 密码格式验证
     * @param pwd
     * @return
     */
    public static boolean isPwd(String pwd){
        String strPattern = "^[a-zA-Z0-9_]+$";
        Pattern p = Pattern.compile(strPattern);
        Matcher m = p.matcher(pwd);
        return m.matches();
    }

    /**
     * URL格式验证
     * @param str
     * @return
     */
    public static boolean isURL(String str){
        String strPattern = "^http:.+itemId\\=(.+)$";
        Pattern p = Pattern.compile(strPattern);
        Matcher m = p.matcher(str);
        return m.matches();
    }
}
