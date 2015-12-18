package com.akioss.leanote.common;

/*****************************************************************************************************************
 * Author: liyi
 * Create Date: 15/12/10.
 * Package: com.akioss.leanote.common
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

    public void setFileId(String FileId) {
        this.FileId = FileId;
    }

    public void setLocalFileId(String LocalFileId) {
        this.LocalFileId = LocalFileId;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public void setHasBody(boolean HasBody) {
        this.HasBody = HasBody;
    }

    public void setIsAttach(boolean IsAttach) {
        this.IsAttach = IsAttach;
    }

    public String getFileId() {
        return FileId;
    }

    public String getLocalFileId() {
        return LocalFileId;
    }

    public String getType() {
        return Type;
    }

    public String getTitle() {
        return Title;
    }

    public boolean isHasBody() {
        return HasBody;
    }

    public boolean isIsAttach() {
        return IsAttach;
    }
}
