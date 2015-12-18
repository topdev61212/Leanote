package com.akioss.leanote.ui.fragments;

import android.content.Context;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ProgressBar;

import com.akioss.leanote.R;
import com.akioss.leanote.model.entities.NoteItem;
import com.akioss.leanote.ui.adapters.NotesAdapter;
import com.akioss.leanote.ui.mvpview.NotesView;
import com.akioss.leanote.ui.presenters.impl.NotesPresenter;
import com.akioss.leanote.views.refreshview.MaterialRefreshLayout;
import com.akioss.leanote.views.refreshview.MaterialRefreshListener;

import java.util.List;

import butterknife.Bind;

public class NotesFragment extends BaseFragment<NotesPresenter> implements NotesView<NoteItem> {

    @Bind(R.id.refresh_layout)
    MaterialRefreshLayout refreshLayout;
    @Bind(R.id.note_rcview)
    RecyclerView noteRcview;
    @Bind(R.id.notes_pb)
    ProgressBar notesPb;
    @Bind(R.id.edit_fab)
    FloatingActionButton editFab;

    private NotesAdapter adapter;

    public static NotesFragment newInstance() {
        NotesFragment fragment = new NotesFragment();
        return fragment;
    }

    @Override
    public int bindLayout() {
        return R.layout.fragment_notes;
    }

    @Override
    public void initParams() {
        setPresenter(new NotesPresenter(this));
    }

    @Override
    public void initView() {
        noteRcview.setLayoutManager(new LinearLayoutManager(getContext()));
        noteRcview.setAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.alpha_in));
        refreshLayout.setMaterialRefreshListener(refrshListener);
    }

    @Override
    public void doBusiness() {
        presenter.getNotes();
    }

    @Override
    public Context getContext() {
        return mContxt;
    }

    @Override
    public void setUpAdapter(List<NoteItem> datas) {
        if (adapter == null) {
            adapter = new NotesAdapter(datas, getContext());
        }
        noteRcview.setAdapter(adapter);
    }

    @Override
    public void appendDataToAdapter(List<NoteItem> datas) {

    }

    @Override
    public void dragCompleate() {

    }

    @Override
    public void pullCompleate() {

    }

    @Override
    public void showProgress() {
        notesPb.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        notesPb.setVisibility(View.GONE);
    }

    @Override
    public void showFab() {
        editFab.show();
    }

    @Override
    public void hideFab() {
        editFab.hide();
    }

    private MaterialRefreshListener refrshListener = new MaterialRefreshListener() {
        @Override
        public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {
            presenter.getNotes();
        }

        @Override
        public void onfinish() {
            super.onfinish();
        }

        @Override
        public void onRefreshLoadMore(MaterialRefreshLayout materialRefreshLayout) {
            super.onRefreshLoadMore(materialRefreshLayout);
        }
    };

}
