package com.akioss.leanote.presenters.impl;

import android.content.Context;

import com.akioss.leanote.common.Constants;
import com.akioss.leanote.model.datasource.net.NoteApi;
import com.akioss.leanote.model.datasource.net.UserApi;
import com.akioss.leanote.model.entity.NoteItemEntity;
import com.akioss.leanote.model.entity.SyncStateEntity;
import com.akioss.leanote.presenters.BasePresenter;
import com.akioss.leanote.ui.mvpview.NotesView;
import com.akioss.leanote.utils.GlobalSharePres;
import com.akioss.leanote.utils.logger.Logger;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
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
    private NoteApi noteNetService;
    private UserApi userNetService;

    public NotesPresenter(NotesView notesView) {
        this.notesView = notesView;
    }

    @Override
    public void attach(Context context) {
        super.attach(context);
        sharePres = new GlobalSharePres(mContext, Constants.PRES_ACCOUNT);
        noteNetService = netSource.createNetService(NoteApi.class);
        userNetService = netSource.createNetService(UserApi.class);
    }

    public void getNotes() {
        notesView.hideFab();
        notesView.setLoading(true);
        compositeSubscription.add(
                userNetService.getSyncState()
                        .subscribeOn(Schedulers.io())
                        //获取最新的usn
                        .flatMap(new Func1<SyncStateEntity, Observable<List<NoteItemEntity>>>() {
                            @Override
                            public Observable<List<NoteItemEntity>> call(SyncStateEntity syncStateEntity) {
                                Logger.d(syncStateEntity.toString());
                                return noteNetService.getNotes(syncStateEntity.getLastSyncUsn(),
                                        MAX_ENTITY, sharePres.loadString("token"));
                            }
                        })
                        .observeOn(AndroidSchedulers.mainThread())
                        //过滤掉删除笔记
                        .map(new Func1<List<NoteItemEntity>, List<NoteItemEntity>>() {
                            @Override
                            public List<NoteItemEntity> call(List<NoteItemEntity> noteItemEntities) {
                                List<NoteItemEntity> noteList = new ArrayList<>();
                                for (NoteItemEntity item :
                                        noteItemEntities) {
                                    if (!item.isDeleted()) {
                                        noteList.add(item);
                                    }
                                }
                                return noteList;
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
                                usn = noteItems.get(noteItems.size() - 1).getUsn();
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
