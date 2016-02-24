package com.akioss.leanote.ui.activitys;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.akioss.leanote.Leanote;
import com.akioss.leanote.common.AppManager;
import com.akioss.leanote.presenters.BasePresenter;

import java.lang.ref.WeakReference;

/*****************************************************************************************************************
 * Author: liyi
 * Create Date: 15/11/24.
 * Package: com.akioss.leanote.ui.activitys
 * Discription:
 * Version: 1.0
 * ---------------------------------------------------------------------------------------------------------------
 * Modified By:
 * Modified Date:
 * Why & What is modified :
 *****************************************************************************************************************/
@SuppressWarnings("unused")
public abstract class BaseFragmentActivity<P extends BasePresenter> extends AppCompatActivity {

    /**
     * activity弱引用 防止activity内存泄露
     */
    private WeakReference< Activity> weakActivity;
    /**
     * fragment管理器
     */
    protected FragmentManager mFragmentManager = null;
    /**
     * 放置fragment的view
     */
    protected int mFragmentContainer;
    /**
     * 当前显示的Fragment
     */
    public Fragment mCurrentFragment;

    /**
     * 当前Activity presenter
     */
    protected P presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Activity弱引用
        weakActivity = new WeakReference<Activity>(this);
        AppManager.add(weakActivity);
        //获取FragmentManager
        mFragmentManager = getSupportFragmentManager();

        if (bindLayout() <= 0) {
            throw new RuntimeException("you should be bind layout frist!");
        }else {
            setContentView(bindLayout());
        }

        initView();
        initParams();

        if (presenter != null) {
            presenter.attach(getContext());
        }

        doBusiness();
    }

    protected abstract @LayoutRes int bindLayout();

    protected abstract void initView();

    protected abstract void initParams();

    protected abstract void doBusiness();

    @Override
    protected void onStart() {
        super.onStart();
    }

    /**
     * Don't delete this method
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.detach();
        }
        if (weakActivity != null) {
            AppManager.remove(weakActivity);
        }
        Leanote.get().getRefWatcher().watch(this);
    }

    protected void setPresenter(P presenter){
        this.presenter = presenter;
    }

    /**
     * get context
     */
    protected Activity getContext() {
        if (weakActivity != null) {
            return weakActivity.get();
        } else {
            return null;
        }
    }

    /**
     * @param container 用于放置fragment的布局id
     * @param fragment 要添加的Fragment
     */
    public void addFragment(int container, Fragment fragment) {

        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        if (!isFragmentAdded(fragment)) {
            fragmentTransaction
                    .add(container, fragment,
                            fragment.getClass().getName()).commitAllowingStateLoss();
            mCurrentFragment = fragment;
        } else {
            fragmentTransaction.show(fragment).commitAllowingStateLoss();
        }

        mFragmentContainer = container;
    }

    /**
     * 需要在调用任何函数前设置
     *
     * @param container 用于放置fragment的布局id
     */
    public void setFragmentContainerId(int container) {
        mFragmentContainer = container;
    }

    /**
     * 判断一个Fragment是否已经添加
     *
     * @param fragment 要判断是否已经添加的Fragment
     * @return true or false
     */
    public boolean isFragmentAdded(Fragment fragment) {
        return fragment != null
                && mFragmentManager.findFragmentByTag(fragment.getClass().getName()) != null;
    }

    /**
     * 检查放置fragment的布局id
     */
    private void checkContainer() {
        if (mFragmentContainer <= 0) {
            throw new RuntimeException(
                    "在调用replaceFragment函数之前请调用setFragmentContainerId函数来设置fragment container id");
        }
    }

    /**
     * 显示Fragment，并且把上一个隐藏
     *
     * @param fragmentShow fragment
     */
    public void showFragment(Fragment fragmentShow) {
        showFragmentInContainer(mFragmentContainer, fragmentShow);
    }

    /**
     * 将fragmentShow显示在一个新的container上,而不覆盖mFragmentContainer。
     * 这种情况适用于Fragment中又嵌套Fragment
     *
     * @param container containerId
     * @param fragmentShow fragment
     */
    public void showFragmentInContainer(int container, Fragment fragmentShow) {
        checkContainer();

        if (mCurrentFragment != fragmentShow) {
            FragmentTransaction transaction = mFragmentManager.beginTransaction();
            if (mCurrentFragment != null) {
                // 首先隐藏原来显示的Fragment
                transaction.hide(mCurrentFragment);
            }
            // 然后再显示传递进来的Fragment
            if (mFragmentManager.findFragmentByTag(fragmentShow.getClass().getName()) == null) {
                transaction
                        .add(container, fragmentShow, fragmentShow.getClass().getName());
            } else {
                transaction.show(fragmentShow);
            }
            transaction.commitAllowingStateLoss();
            mCurrentFragment = fragmentShow;
        }
    }

    /**
     * 移除上一个Fragment，显示传递进来的Fragment
     *
     * @param fragment fragment
     */
    public void replaceFragment(Fragment fragment) {
        replaceFragment(fragment, false);
    }

    /**
     * @param fragment fragment
     */
    public void replaceFragment(Fragment fragment, boolean isAddToBackStack) {
        checkContainer();
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        transaction.replace(mFragmentContainer,
                fragment);
        if (isAddToBackStack) {
            transaction.addToBackStack(null);
        }
        transaction.commitAllowingStateLoss();
        mCurrentFragment = fragment;
    }

    /**
     * @param container containerId
     * @param fragment fragment
     */
    public void replaceFragment(int container, Fragment fragment) {
        checkContainer();
        if (mCurrentFragment != fragment) {
            FragmentTransaction transaction = mFragmentManager.beginTransaction();
            transaction.replace(container,
                    fragment, fragment.getClass().getSimpleName());
            transaction.commitAllowingStateLoss();
            mCurrentFragment = fragment;
        }
    }

    /**
     * @param fragment fragment
     */
    public void remove(Fragment fragment) {
        if (null != fragment) {
            FragmentTransaction transaction = mFragmentManager.beginTransaction();
            transaction.remove(fragment);
            transaction.commitAllowingStateLoss();
        }
    }

    /**
     * @param fragment fragment
     */
    public void detach(Fragment fragment) {
        if (null != fragment) {
            FragmentTransaction transaction = mFragmentManager.beginTransaction();
            transaction.detach(fragment);
            transaction.commit();
        }
    }

}
