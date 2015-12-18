package com.akioss.leanote.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.akioss.leanote.ui.activitys.IBaseView;
import com.akioss.leanote.ui.presenters.BasePresenter;

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
public abstract class BaseFragment<P extends BasePresenter> extends Fragment implements IBaseView{

    protected Context mContxt;
    /**
     * fragment跟布局
     */
    protected View rootView;
    /**
     * presenter
     */
    protected P presenter;
    /**
     * fragment监听
     */
    private OnFragmentInteractionListener mListener;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

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
        doBusiness();

        if (presenter != null) {
            presenter.attach(mContxt);
        }

        return rootView;
    }

    protected void setPresenter(P presenter) {
        this.presenter = presenter;
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
}
