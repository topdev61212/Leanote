package com.akioss.leanote.ui.fragments;

import com.akioss.leanote.R;
import com.akioss.leanote.presenters.impl.PostPresenter;

import butterknife.ButterKnife;

public class PostFragment extends BaseFragment<PostPresenter> {

    public static PostFragment newInstance() {
        PostFragment fragment = new PostFragment();
        return fragment;
    }

    @Override
    public int bindLayout() {
        return R.layout.fragment_post;
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
