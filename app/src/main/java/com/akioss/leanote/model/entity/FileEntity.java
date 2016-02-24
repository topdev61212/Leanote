package com.akioss.leanote.model.entity;

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

    public String getFileId() {
        return FileId;
    }

    public void setFileId(String fileId) {
        FileId = fileId;
    }

    public String getLocalFileId() {
        return LocalFileId;
    }

    public void setLocalFileId(String localFileId) {
        LocalFileId = localFileId;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public boolean isHasBody() {
        return HasBody;
    }

    public void setHasBody(boolean hasBody) {
        HasBody = hasBody;
    }

    public boolean isAttach() {
        return IsAttach;
    }

    public void setAttach(boolean attach) {
        IsAttach = attach;
    }

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