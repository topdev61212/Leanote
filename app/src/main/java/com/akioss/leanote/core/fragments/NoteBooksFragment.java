package com.akioss.leanote.core.fragments;

import com.akioss.leanote.R;
import com.akioss.leanote.core.presenters.impl.NoteBooksPresenter;

import butterknife.ButterKnife;


public class NoteBooksFragment extends BaseFragment<NoteBooksPresenter> {

    public static NoteBooksFragment newInstance() {
        NoteBooksFragment fragment = new NoteBooksFragment();
        return fragment;
    }

    @Override
    public int bindLayout() {
        return R.layout.fragment_note_books;
    }

    @Override
    public void initParams() {

    }

    @Override
    public void initView() {
        ButterKnife.bind(this, rootView);

    }

    @Override
    public void doBusiness() {

    }
}
