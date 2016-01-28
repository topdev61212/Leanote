package com.akioss.leanote.model.entities;

/*****************************************************************************************************************
 * Author: liyi
 * Create Date: 15/11/25.
 * Package: com.akioss.leanote.model.entities
 * Discription:
 * Version: 1.0
 * ---------------------------------------------------------------------------------------------------------------
 * Modified By:
 * Modified Date:
 * Why & What is modified :
 *****************************************************************************************************************/
public class AccountInfoEntity extends BaseInfoEntity {

    public String Token;
    public String UserId;
    public String Email;
    public String Username;

    @Override
    public String toString() {
        return "AccountInfo{" +
                "Token='" + Token + '\'' +
                ", UserId='" + UserId + '\'' +
                ", Email='" + Email + '\'' +
                ", Username='" + Username + '\'' +
                '}';
    }
}
