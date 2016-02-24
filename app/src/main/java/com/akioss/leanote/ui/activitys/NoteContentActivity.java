package com.akioss.leanote.ui.activitys;

import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.akioss.leanote.R;
import com.akioss.leanote.presenters.impl.NoteContentPresenter;
import com.akioss.leanote.ui.mvpview.NoteContentView;
import com.akioss.leanote.widgets.MarkdownView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class NoteContentActivity extends BaseFragmentActivity<NoteContentPresenter>
        implements NoteContentView {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.notecontent_mdview)
    MarkdownView notecontentMdview;
    @Bind(R.id.progressBar)
    ProgressBar progressBar;

    private String noteId;

    @Override
    protected int bindLayout() {
        return R.layout.activity_note_content;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        //init toolbar
        toolbar.setTitle("NoteContent");
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(toolbar);
    }

    @Override
    protected void initParams() {
        setPresenter(new NoteContentPresenter(this));
        noteId = getIntent().getStringExtra("noteId");
    }

    @Override
    protected void doBusiness() {
        presenter.getNoteContent(noteId);
    }

    @Override
    public void setLoading(boolean flag) {
        progressBar.setVisibility(flag ? View.VISIBLE : View.GONE);
    }

    @Override
    public void showMsg(String msg) {
        Toast.makeText(NoteContentActivity.this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showMarkdownText(String text) {
        notecontentMdview.loadMarkdown(text);
    }
}
