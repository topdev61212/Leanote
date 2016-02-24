package com.akioss.leanote.ui.fragments;

import com.akioss.leanote.R;
import com.akioss.leanote.presenters.impl.SettingPresenter;

/*****************************************************************************************************************
 * Author: liyi
 * Create Date: 16/2/17.
 * Package: com.akioss.leanote.ui.fragments
 * Discription:
 * Version: 1.0
 * ---------------------------------------------------------------------------------------------------------------
 * Modified By:
 * Modified Date:
 * Why & What is modified :
 *****************************************************************************************************************/
public class SettingFragment extends BaseFragment<SettingPresenter> {

    public static SettingFragment newInstance() {
        SettingFragment fragment = new SettingFragment();
        return fragment;
    }

    @Override
    protected int bindLayout() {
        return R.layout.fragment_setting;
    }

    @Override
    protected void initParams() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected void doBusiness() {

    }
}
