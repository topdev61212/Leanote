package com.akioss.leanote.ui.presenters.impl;

import android.widget.Toast;

import com.akioss.leanote.common.Constants;
import com.akioss.leanote.common.GlobalSharePres;
import com.akioss.leanote.model.entities.NoteItem;
import com.akioss.leanote.model.rest.DataSourceService;
import com.akioss.leanote.ui.mvpview.NotesView;
import com.akioss.leanote.ui.presenters.BasePresenter;
import com.akioss.leanote.ui.presenters.interfaces.INotesPresenter;

import java.util.List;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/*****************************************************************************************************************
 * Author: liyi
 * Create Date: 15/12/11.
 * Package: com.akioss.leanote.ui.presenters.impl
 * Discription:
 * Version: 1.0
 * ---------------------------------------------------------------------------------------------------------------
 * Modified By:
 * Modified Date:
 * Why & What is modified :
 *****************************************************************************************************************/
public class NotesPresenter extends BasePresenter implements INotesPresenter {

    private static final int MAX_ENTITY = 10;

    private final NotesView notesView;
    private GlobalSharePres sharePres;
    private int usn = 0;

    public NotesPresenter(NotesView notesView) {
        this.notesView = notesView;
        sharePres = new GlobalSharePres(notesView.getContext(), Constants.PRES_ACCOUNT);
    }

    @Override
    public void getNotes() {
        notesView.hideFab();
        notesView.showProgress();
        DataSourceService.getInstance().getNotes(usn, MAX_ENTITY, sharePres.loadString("token"))
                .enqueue(new Callback<List<NoteItem>>() {
                    @Override
                    public void onResponse(Response<List<NoteItem>> response, Retrofit retrofit) {
                        if (response.isSuccess()) {
                            List<NoteItem> notelist = response.body();
                            for (int i = 0; i < notelist.size(); i++) {
                                if (notelist.get(i).isIsDeleted()) {
                                    notelist.remove(i);
                                }
                            }
                            usn = notelist.get(notelist.size()).getUsn();
                            notesView.setUpAdapter(notelist);
                            notesView.showFab();
                            notesView.hideProgress();
                            Toast.makeText(notesView.getContext(), "sync notes compleate!", Toast.LENGTH_SHORT).show();
                        }else {
                            notesView.hideProgress();
                        }
                    }
                    @Override
                    public void onFailure(Throwable t) {
                        notesView.hideProgress();
                    }
                });
    }

    @Override
    public void loadMore() {

    }

}
