package com.akioss.leanote.ui.activitys;

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
import com.akioss.leanote.common.AppManager;
import com.akioss.leanote.presenters.impl.MainPresenter;
import com.akioss.leanote.ui.fragments.NoteBooksFragment;
import com.akioss.leanote.ui.fragments.NotesFragment;
import com.akioss.leanote.ui.fragments.PostFragment;
import com.akioss.leanote.ui.fragments.SettingFragment;
import com.akioss.leanote.ui.mvpview.MainView;
import com.akioss.leanote.utils.transformation.CircleImgTransformation;
import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends BaseFragmentActivity<MainPresenter>
        implements MainView, NavigationView.OnNavigationItemSelectedListener {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.nav_view)
    NavigationView navView;
    @Bind(R.id.drawer_layout)
    DrawerLayout drawer;
    @Bind(R.id.progressBar)
    ProgressBar progressBar;
    @Bind(R.id.content_layout)
    FrameLayout contentLayout;

    ImageView logoImg;
    TextView usernameTxt;
    TextView emailTxt;

    private NotesFragment notesFragment;
    private PostFragment postFragment;
    private NoteBooksFragment noteBooksFragment;
    private SettingFragment settingFragment;

    @Override
    public int bindLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initParams() {
        setPresenter(new MainPresenter(this));
        setFragmentContainerId(R.id.content_layout);
        notesFragment = NotesFragment.newInstance();
        postFragment = PostFragment.newInstance();
        noteBooksFragment = NoteBooksFragment.newInstance();
        settingFragment = SettingFragment.newInstance();
    }

    @Override
    public void initView() {
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void doBusiness() {
        //get userinfo
        presenter.getUserInfo();
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
                showFragment(settingFragment);
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
        View headerLayout = navView.getHeaderView(0);
        logoImg = (ImageView) headerLayout.findViewById(R.id.logo_img);
        usernameTxt = (TextView) headerLayout.findViewById(R.id.username_txt);
        emailTxt = (TextView) headerLayout.findViewById(R.id.email_txt);
        Picasso.with(this).load(logoUrl)
                .transform(new CircleImgTransformation())
                .into(logoImg);
        usernameTxt.setText(userName);
        emailTxt.setText("Email: " + email);
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
            AppManager.exitClient(getContext());
            super.onBackPressed();
        }
    }

    @Override
    public void setLoading(boolean flag) {
        progressBar.setVisibility(flag ? View.VISIBLE : View.GONE);
    }

    @Override
    public void showMsg(String msg) {

    }
}
