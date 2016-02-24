package com.akioss.leanote.model.entity;

/*****************************************************************************************************************
 * Author: liyi
 * Create Date: 16/2/23.
 * Package: com.akioss.leanote.model.entity
 * Discription:
 * Version: 1.0
 * ---------------------------------------------------------------------------------------------------------------
 * Modified By:
 * Modified Date:
 * Why & What is modified :
 *****************************************************************************************************************/
public class NoteContentEntity {
    private String NoteId;
    private String UserId;
    private String Content;

    public String getNoteId() {
        return NoteId;
    }

    public String getUserId() {
        return UserId;
    }

    public String getContent() {
        return Content;
    }

    @Override
    public String toString() {
        return "NoteContentEntity{" +
                "NoteId='" + NoteId + '\'' +
                ", UserId='" + UserId + '\'' +
                ", Content='" + Content + '\'' +
                '}';
    }
}
