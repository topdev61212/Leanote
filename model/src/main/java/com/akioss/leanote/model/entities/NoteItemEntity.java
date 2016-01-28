package com.akioss.leanote.model.entities;

import java.util.List;

/*****************************************************************************************************************
 * Author: liyi
 * Create Date: 15/12/10.
 * Package: com.akioss.leanote.model.entities
 * Discription:
 * Version: 1.0
 * ---------------------------------------------------------------------------------------------------------------
 * Modified By:
 * Modified Date:
 * Why & What is modified :
 *****************************************************************************************************************/
public class NoteItemEntity extends BaseInfoEntity {

    public String NoteId;
    public String NotebookId;
    public String UserId;
    public String Title;
    public String Desc;
    public String Abstract;
    public String Content;
    public boolean IsMarkdown;
    public boolean IsBlog;
    public boolean IsTrash;
    public boolean IsDeleted;
    public int Usn;
    public String CreatedTime;
    public String UpdatedTime;
    public String PublicTime;
    public List<String> Tags;
    public List<FileEntity> Files;

    @Override
    public String toString() {
        return "NoteItemEntity{" +
                "NoteId='" + NoteId + '\'' +
                ", NotebookId='" + NotebookId + '\'' +
                ", UserId='" + UserId + '\'' +
                ", Title='" + Title + '\'' +
                ", Desc='" + Desc + '\'' +
                ", Abstract='" + Abstract + '\'' +
                ", Content='" + Content + '\'' +
                ", IsMarkdown=" + IsMarkdown +
                ", IsBlog=" + IsBlog +
                ", IsTrash=" + IsTrash +
                ", IsDeleted=" + IsDeleted +
                ", Usn=" + Usn +
                ", CreatedTime='" + CreatedTime + '\'' +
                ", UpdatedTime='" + UpdatedTime + '\'' +
                ", PublicTime='" + PublicTime + '\'' +
                ", Tags=" + Tags +
                ", Files=" + Files +
                '}';
    }
}
