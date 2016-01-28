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
public class UserInfoEntity extends BaseInfoEntity {

    public String UserId;
    public String Username;
    public String Email;
    public boolean Verified;
    public String Logo;

    @Override
    public String toString() {
        return "UserInfo{" +
                "UserId='" + UserId + '\'' +
                ", Username='" + Username + '\'' +
                ", Email='" + Email + '\'' +
                ", Verified=" + Verified +
                ", Logo='" + Logo + '\'' +
                '}';
    }
}
