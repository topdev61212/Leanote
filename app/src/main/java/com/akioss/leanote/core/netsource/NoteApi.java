package com.akioss.leanote.core.netsource;

import com.akioss.leanote.model.entities.NoteItemEntity;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/*****************************************************************************************************************
 * Author: liyi
 * Create Date: 16/1/28.
 * Package: com.akioss.leanote.model.datasource
 * Discription:
 * Version: 1.0
 * ---------------------------------------------------------------------------------------------------------------
 * Modified By:
 * Modified Date:
 * Why & What is modified :
 *****************************************************************************************************************/
@SuppressWarnings("unused")
public interface NoteApi {
    @GET("note/getSyncNotes")
    Observable<List<NoteItemEntity>> getNotes(
            @Query("afterUsn") int afterUsn,
            @Query("maxEntry") int maxEntry,
            @Query("token") String token
    );
}
