package com.akioss.leanote.model.entity;

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

    private String NoteId;
    private String NotebookId;
    private String UserId;
    private String Title;
    private String Desc;
    private String Abstract;
    private String Content;
    private boolean IsMarkdown;
    private boolean IsBlog;
    private boolean IsTrash;
    private boolean IsDeleted;
    private int Usn;
    private String CreatedTime;
    private String UpdatedTime;
    private String PublicTime;
    private List<String> Tags;
    private List<FileEntity> Files;

    public String getNoteId() {
        return NoteId;
    }

    public void setNoteId(String noteId) {
        NoteId = noteId;
    }

    public String getNotebookId() {
        return NotebookId;
    }

    public void setNotebookId(String notebookId) {
        NotebookId = notebookId;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String desc) {
        Desc = desc;
    }

    public String getAbstract() {
        return Abstract;
    }

    public void setAbstract(String anAbstract) {
        Abstract = anAbstract;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public boolean isMarkdown() {
        return IsMarkdown;
    }

    public void setMarkdown(boolean markdown) {
        IsMarkdown = markdown;
    }

    public boolean isBlog() {
        return IsBlog;
    }

    public void setBlog(boolean blog) {
        IsBlog = blog;
    }

    public boolean isTrash() {
        return IsTrash;
    }

    public void setTrash(boolean trash) {
        IsTrash = trash;
    }

    public boolean isDeleted() {
        return IsDeleted;
    }

    public void setDeleted(boolean deleted) {
        IsDeleted = deleted;
    }

    public int getUsn() {
        return Usn;
    }

    public void setUsn(int usn) {
        Usn = usn;
    }

    public String getCreatedTime() {
        return CreatedTime;
    }

    public void setCreatedTime(String createdTime) {
        CreatedTime = createdTime;
    }

    public String getUpdatedTime() {
        return UpdatedTime;
    }

    public void setUpdatedTime(String updatedTime) {
        UpdatedTime = updatedTime;
    }

    public String getPublicTime() {
        return PublicTime;
    }

    public void setPublicTime(String publicTime) {
        PublicTime = publicTime;
    }

    public List<String> getTags() {
        return Tags;
    }

    public void setTags(List<String> tags) {
        Tags = tags;
    }

    public List<FileEntity> getFiles() {
        return Files;
    }

    public void setFiles(List<FileEntity> files) {
        Files = files;
    }

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
