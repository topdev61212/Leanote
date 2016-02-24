package com.akioss.leanote.ui.fragments;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ProgressBar;

import com.akioss.leanote.R;
import com.akioss.leanote.model.entity.NoteItemEntity;
import com.akioss.leanote.presenters.impl.NotesPresenter;
import com.akioss.leanote.ui.activitys.NoteContentActivity;
import com.akioss.leanote.ui.adapters.NotesAdapter;
import com.akioss.leanote.ui.mvpview.NotesView;
import com.akioss.leanote.utils.logger.Logger;

import java.util.List;

import butterknife.Bind;

public class NotesFragment extends BaseFragment<NotesPresenter> implements
        NotesView<NoteItemEntity>, SwipeRefreshLayout.OnRefreshListener {

    @Bind(R.id.refresh_layout)
    SwipeRefreshLayout refreshLayout;
    @Bind(R.id.note_rcview)
    RecyclerView noteRcview;
    @Bind(R.id.notes_pb)
    ProgressBar notesPb;
    @Bind(R.id.edit_fab)
    FloatingActionButton editFab;

    private NotesAdapter adapter;
    private List<NoteItemEntity> dataBuffers;

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
        noteRcview.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    public void doBusiness() {
        presenter.getNotes();
    }

    @Override
    public void setUpAdapter(List<NoteItemEntity> datas) {
        Logger.d(datas.toString());
        dataBuffers = datas;
        if (adapter == null) {
            adapter = new NotesAdapter(datas, getContext());
            noteRcview.setAdapter(adapter);
            adapter.setOnItemClickListener(noteItemClickListener);
        }
    }

    private AdapterView.OnItemClickListener noteItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent intent = new Intent(getContext(), NoteContentActivity.class);
            intent.putExtra("noteId", dataBuffers.get(position).getNoteId());
            getContext().startActivity(intent);
        }
    };

    @Override
    public void appendDataToAdapter(List<NoteItemEntity> datas) {

    }

    @Override
    public void onRefresh() {

    }

    @Override
    public void dragCompleate() {

    }

    @Override
    public void pullCompleate() {

    }

    @Override
    public void showFab() {
        editFab.show();
    }

    @Override
    public void hideFab() {
        editFab.hide();
    }

    @Override
    public void setLoading(boolean flag) {
        notesPb.setVisibility(flag ? View.VISIBLE : View.GONE);
    }

    @Override
    public void showMsg(String msg) {

    }
}
