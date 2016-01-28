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
public class BaseInfoEntity {

    public boolean Ok = true; //默认为true
    public String Msg;

    @Override
    public String toString() {
        return "BaseInfo{" +
                "Ok=" + Ok +
                ", Msg='" + Msg + '\'' +
                '}';
    }
}
