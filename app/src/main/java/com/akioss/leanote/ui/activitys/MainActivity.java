package com.akioss.leanote.ui.activitys;

import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.akioss.leanote.R;
import com.akioss.leanote.ui.fragments.NoteBooksFragment;
import com.akioss.leanote.ui.fragments.NotesFragment;
import com.akioss.leanote.ui.fragments.OnFragmentInteractionListener;
import com.akioss.leanote.ui.fragments.PostFragment;
import com.akioss.leanote.ui.mvpview.MainView;
import com.akioss.leanote.ui.presenters.impl.MainPresenter;
import com.akioss.leanote.utils.bitmaptransform.GlideCircleTransform;
import com.bumptech.glide.Glide;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends BaseFragmentActivity
        implements MainView, OnFragmentInteractionListener,
        NavigationView.OnNavigationItemSelectedListener {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.menu_fab)
    FloatingActionButton menu_fab;
    @Bind(R.id.nav_view)
    NavigationView navView;
    @Bind(R.id.drawer_layout)
    DrawerLayout drawer;
    @Bind(R.id.progressBar)
    ProgressBar progressBar;
    @Bind(R.id.logo_img)
    ImageView logoImg;
    @Bind(R.id.username_txt)
    TextView usernameTxt;
    @Bind(R.id.email_txt)
    TextView emailTxt;
    @Bind(R.id.content_layout)
    FrameLayout contentLayout;

    private MainPresenter mainPresenter;

    private NotesFragment notesFragment;
    private PostFragment postFragment;
    private NoteBooksFragment noteBooksFragment;

    @Override
    public int bindLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initParams() {
        mainPresenter = new MainPresenter(this);
        setFragmentContainerId(R.id.content_layout);
        notesFragment = NotesFragment.newInstance();
        postFragment = PostFragment.newInstance();
        noteBooksFragment = NoteBooksFragment.newInstance();
    }

    @Override
    public void initView() {
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        menu_fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawer.openDrawer(GravityCompat.START);
            }
        });

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void doBusiness() {
        //get userinfo
        mainPresenter.getUserInfo();
        //init notes fragment
        showFragment(notesFragment);
        navView.setCheckedItem(R.id.nav_notes);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.nav_notes:
                showFragment(notesFragment);
                break;
            case R.id.nav_post:
                showFragment(postFragment);
                break;
            case R.id.nav_notebooks:
                showFragment(noteBooksFragment);
                break;
            case R.id.nav_settings:
                break;
            case R.id.nav_share:
                break;
            case R.id.nav_send:
                break;
            default:
                break;
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void setUpHeader(String logoUrl, String userName, String email) {
        Glide.with(this).load(logoUrl)
                .crossFade()
                .transform(new GlideCircleTransform(this))
                .into(logoImg);
        usernameTxt.setText(userName);
        emailTxt.setText("Email: " + email);
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showSnackMsg(String msg) {
//        Snackbar.make(fab, msg, Snackbar.LENGTH_SHORT);
    }

    @Override
    public void showSnackMsg(int resId) {
//        Snackbar.make(fab, getResources().getString(resId), Snackbar.LENGTH_SHORT);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_addnote:
                break;
            case R.id.action_settings:
                break;
        }

        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
