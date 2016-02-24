package com.akioss.leanote.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.akioss.leanote.Leanote;
import com.akioss.leanote.presenters.BasePresenter;

import butterknife.ButterKnife;

/*****************************************************************************************************************
 * Author: liyi
 * Create Date: 15/11/24.
 * Package: com.akioss.leanote.ui.fragments
 * Discription:
 * Version: 1.0
 * ---------------------------------------------------------------------------------------------------------------
 * Modified By:
 * Modified Date:
 * Why & What is modified :
 *****************************************************************************************************************/
public abstract class BaseFragment<P extends BasePresenter> extends Fragment {

    protected Context mContxt;
    /**
     * fragment跟布局
     */
    protected View rootView;
    /**
     * presenter
     */
    protected P presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mContxt = getActivity();
        if (bindLayout() <= 0){
            throw new RuntimeException("Do not exec bindLayout method!");
        } else {
            rootView = LayoutInflater.from(mContxt).inflate(bindLayout(), container, false);
        }
        ButterKnife.bind(this, rootView);

        initParams();
        initView();

        //绑定presenter
        if (presenter != null) {
            presenter.attach(mContxt);
        }

        doBusiness();

        return rootView;
    }

    protected abstract @LayoutRes int bindLayout();

    protected abstract void initParams();

    protected abstract void initView();

    protected abstract void doBusiness();

    protected void setPresenter(P presenter) {
        this.presenter = presenter;
    }

    public Context getContext() {
        return mContxt;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onDetach() {
        if (presenter != null) {
            presenter.detach();
        }
        super.onDetach();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Leanote.get().getRefWatcher().watch(this);
    }
}
