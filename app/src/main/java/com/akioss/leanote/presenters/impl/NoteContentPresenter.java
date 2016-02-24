package com.akioss.leanote.presenters.impl;

import android.content.Context;

import com.akioss.leanote.model.datasource.net.NoteApi;
import com.akioss.leanote.model.entity.NoteContentEntity;
import com.akioss.leanote.presenters.BasePresenter;
import com.akioss.leanote.ui.mvpview.NoteContentView;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/*****************************************************************************************************************
 * Author: liyi
 * Create Date: 16/2/23.
 * Package: com.akioss.leanote.presenters.impl
 * Discription:
 * Version: 1.0
 * ---------------------------------------------------------------------------------------------------------------
 * Modified By:
 * Modified Date:
 * Why & What is modified :
 *****************************************************************************************************************/
public class NoteContentPresenter extends BasePresenter {
    private final NoteContentView noteContentView;
    private NoteApi noteNetService;

    public NoteContentPresenter(NoteContentView noteContentView) {
        this.noteContentView = noteContentView;
    }

    @Override
    public void attach(Context context) {
        super.attach(context);
        noteNetService = netSource.createNetService(NoteApi.class);
    }

    public void getNoteContent(String noteId) {
        noteContentView.setLoading(true);
        compositeSubscription.add(
                noteNetService.getNoteContent(noteId)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Subscriber<NoteContentEntity>() {
                            @Override
                            public void onCompleted() {
                                noteContentView.setLoading(false);
                            }

                            @Override
                            public void onError(Throwable e) {
                                noteContentView.setLoading(false);
                            }

                            @Override
                            public void onNext(NoteContentEntity noteContentEntity) {
                                noteContentView.showMarkdownText(noteContentEntity.getContent());
                            }
                        })
        );
    }
}
