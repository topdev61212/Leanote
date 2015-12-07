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
public class UserInfo extends BaseInfo {

    private String UserId;
    private String Username;
    private String Email;
    private boolean Verified;
    private String Logo;

    public void setUserId(String UserId) {
        this.UserId = UserId;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setVerified(boolean Verified) {
        this.Verified = Verified;
    }

    public void setLogo(String Logo) {
        this.Logo = Logo;
    }

    public String getUserId() {
        return UserId;
    }

    public String getUsername() {
        return Username;
    }

    public String getEmail() {
        return Email;
    }

    public boolean isVerified() {
        return Verified;
    }

    public String getLogo() {
        return Logo;
    }

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
