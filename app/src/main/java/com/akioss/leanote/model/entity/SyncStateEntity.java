package com.akioss.leanote.model.entity;

/*****************************************************************************************************************
 * Author: liyi
 * Create Date: 16/2/17.
 * Package: com.akioss.leanote.model.entities
 * Discription:
 * Version: 1.0
 * ---------------------------------------------------------------------------------------------------------------
 * Modified By:
 * Modified Date:
 * Why & What is modified :
 *****************************************************************************************************************/
public class SyncStateEntity extends BaseInfoEntity {

    private int LastSyncUsn;
    private String LastSyncTime;

    public void setLastSyncUsn(int LastSyncUsn) {
        this.LastSyncUsn = LastSyncUsn;
    }

    public void setLastSyncTime(String LastSyncTime) {
        this.LastSyncTime = LastSyncTime;
    }

    public int getLastSyncUsn() {
        return LastSyncUsn;
    }

    public String getLastSyncTime() {
        return LastSyncTime;
    }

    @Override
    public String toString() {
        return "SyncStateEntity{" +
                "LastSyncUsn=" + LastSyncUsn +
                ", LastSyncTime='" + LastSyncTime + '\'' +
                '}';
    }
}
