package com.akioss.leanote.model.entities;

/*****************************************************************************************************************
 * Author: liyi
 * Create Date: 16/1/28.
 * Package: com.akioss.leanote.model
 * Discription:
 * Version: 1.0
 * ---------------------------------------------------------------------------------------------------------------
 * Modified By:
 * Modified Date:
 * Why & What is modified :
 *****************************************************************************************************************/
public class FileEntity {

    private String FileId;
    private String LocalFileId;
    private String Type;
    private String Title;
    private boolean HasBody;
    private boolean IsAttach;

    @Override
    public String toString() {
        return "FileEntity{" +
                "FileId='" + FileId + '\'' +
                ", LocalFileId='" + LocalFileId + '\'' +
                ", Type='" + Type + '\'' +
                ", Title='" + Title + '\'' +
                ", HasBody=" + HasBody +
                ", IsAttach=" + IsAttach +
                '}';
    }
}