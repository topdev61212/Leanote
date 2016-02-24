package com.akioss.leanote.model.entity;

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
public class BaseInfoEntity {

    private boolean Ok = true; //默认为true
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
