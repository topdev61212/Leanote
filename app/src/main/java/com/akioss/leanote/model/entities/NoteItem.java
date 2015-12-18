package com.akioss.leanote.model.entities;

import com.akioss.leanote.common.FileEntity;

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
public class NoteItem extends BaseInfo {

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

    public void setNoteId(String NoteId) {
        this.NoteId = NoteId;
    }

    public void setNotebookId(String NotebookId) {
        this.NotebookId = NotebookId;
    }

    public void setUserId(String UserId) {
        this.UserId = UserId;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public void setDesc(String Desc) {
        this.Desc = Desc;
    }

    public void setAbstract(String Abstract) {
        this.Abstract = Abstract;
    }

    public void setContent(String Content) {
        this.Content = Content;
    }

    public void setIsMarkdown(boolean IsMarkdown) {
        this.IsMarkdown = IsMarkdown;
    }

    public void setIsBlog(boolean IsBlog) {
        this.IsBlog = IsBlog;
    }

    public void setIsTrash(boolean IsTrash) {
        this.IsTrash = IsTrash;
    }

    public void setIsDeleted(boolean IsDeleted) {
        this.IsDeleted = IsDeleted;
    }

    public void setUsn(int Usn) {
        this.Usn = Usn;
    }

    public void setCreatedTime(String CreatedTime) {
        this.CreatedTime = CreatedTime;
    }

    public void setUpdatedTime(String UpdatedTime) {
        this.UpdatedTime = UpdatedTime;
    }

    public void setPublicTime(String PublicTime) {
        this.PublicTime = PublicTime;
    }

    public void setTags(List<String> Tags) {
        this.Tags = Tags;
    }

    public void setFiles(List<FileEntity> Files) {
        this.Files = Files;
    }

    public String getNoteId() {
        return NoteId;
    }

    public String getNotebookId() {
        return NotebookId;
    }

    public String getUserId() {
        return UserId;
    }

    public String getTitle() {
        return Title;
    }

    public String getDesc() {
        return Desc;
    }

    public String getAbstract() {
        return Abstract;
    }

    public String getContent() {
        return Content;
    }

    public boolean isIsMarkdown() {
        return IsMarkdown;
    }

    public boolean isIsBlog() {
        return IsBlog;
    }

    public boolean isIsTrash() {
        return IsTrash;
    }

    public boolean isIsDeleted() {
        return IsDeleted;
    }

    public int getUsn() {
        return Usn;
    }

    public String getCreatedTime() {
        return CreatedTime;
    }

    public String getUpdatedTime() {
        return UpdatedTime;
    }

    public String getPublicTime() {
        return PublicTime;
    }

    public List<String> getTags() {
        return Tags;
    }

    public List<FileEntity> getFiles() {
        return Files;
    }


}
