package com.akioss.leanote.core.presenters.impl;

import android.content.Context;

import com.akioss.leanote.common.Constants;
import com.akioss.leanote.core.mvpview.NotesView;
import com.akioss.leanote.core.presenters.BasePresenter;
import com.akioss.leanote.model.entities.NoteItemEntity;
import com.akioss.leanote.utils.GlobalSharePres;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

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
public class NotesPresenter extends BasePresenter {

    private static final int MAX_ENTITY = 20;

    private final NotesView notesView;
    private GlobalSharePres sharePres;
    private int usn = 0;

    public NotesPresenter(NotesView notesView) {
        this.notesView = notesView;
    }

    @Override
    public void attach(Context context) {
        super.attach(context);
        sharePres = new GlobalSharePres(mContext, Constants.PRES_ACCOUNT);
    }

    public void getNotes() {
        notesView.hideFab();
        notesView.setLoading(true);
        compositeSubscription.add(
                dataSource.getNotes(usn, MAX_ENTITY, sharePres.loadString("token"))
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.io())
                        .map(new Func1<List<NoteItemEntity>, List<NoteItemEntity>>() {
                            @Override
                            public List<NoteItemEntity> call(List<NoteItemEntity> noteItemEntities) {
                                List<NoteItemEntity> items = new ArrayList<>();
                                for (int i = 0; i < noteItemEntities.size(); i++) {
                                    if (!noteItemEntities.get(i).IsDeleted) {
                                        items.add(noteItemEntities.get(i));
                                    }
                                }
                                return items;
                            }
                        })
                        .subscribe(new Subscriber<List<NoteItemEntity>>() {
                            @Override
                            public void onCompleted() {
                                notesView.setLoading(false);
                            }

                            @Override
                            public void onError(Throwable e) {
                                notesView.setLoading(false);
                            }

                            @Override
                            public void onNext(List<NoteItemEntity> noteItems) {
                                usn = noteItems.get(noteItems.size() - 1).Usn;
                                notesView.setUpAdapter(noteItems);
                                notesView.showFab();
                                notesView.showMsg("sync notes compleate!");
                            }
                        })
        );
    }


    public void loadMore() {

    }

    @Override
    public void detach() {
        super.detach();
        sharePres = null;
    }
}
