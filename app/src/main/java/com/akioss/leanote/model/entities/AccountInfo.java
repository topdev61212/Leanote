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
@SuppressWarnings("unused")
public class AccountInfo extends BaseInfo {

    private String Token;
    private String UserId;
    private String Email;
    private String Username;

    public void setToken(String Token) {
        this.Token = Token;
    }

    public void setUserId(String UserId) {
        this.UserId = UserId;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getToken() {
        return Token;
    }

    public String getUserId() {
        return UserId;
    }

    public String getEmail() {
        return Email;
    }

    public String getUsername() {
        return Username;
    }

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
