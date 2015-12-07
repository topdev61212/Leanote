package com.akioss.leanote.model.entities;

/*****************************************************************************************************************
 * Author: liyi
 * Create Date: 15/11/27.
 * Package: com.akioss.leanote.model.entities
 * Discription:
 * Version: 1.0
 * ---------------------------------------------------------------------------------------------------------------
 * Modified By:
 * Modified Date:
 * Why & What is modified :
 *****************************************************************************************************************/
@SuppressWarnings("unused")
public class BaseInfo {

    private boolean Ok;
    private String Msg;

    public boolean isOk() {
        return Ok;
    }

    public String getMsg() {
        return Msg;
    }

    @Override
    public String toString() {
        return "BaseInfo{" +
                "Ok=" + Ok +
                ", Msg='" + Msg + '\'' +
                '}';
    }
}
