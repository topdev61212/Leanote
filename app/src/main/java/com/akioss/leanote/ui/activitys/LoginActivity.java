package com.akioss.leanote.ui.activitys;

import android.content.Intent;
import android.os.Build;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.akioss.leanote.R;
import com.akioss.leanote.presenters.impl.LoginPresenter;
import com.akioss.leanote.ui.mvpview.LoginView;
import com.akioss.leanote.utils.AnimateUtil;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/*****************************************************************************************************************
 * Author: liyi
 * Create Date: 15/11/30.
 * Package: com.akioss.leanote.ui.activitys
 * Discription:
 * Version: 1.0
 * ---------------------------------------------------------------------------------------------------------------
 * Modified By:
 * Modified Date:
 * Why & What is modified :
 *****************************************************************************************************************/
public class LoginActivity extends BaseFragmentActivity<LoginPresenter>
        implements LoginView, View.OnClickListener {

    @Bind(R.id.username_edt)
    EditText usernameEdt;
    @Bind(R.id.pwd_edt)
    EditText pwdEdt;
    @Bind(R.id.signin_layout)
    RelativeLayout signinLayout;
    @Bind(R.id.inputLayout)
    TextInputLayout inputLayout;
    @Bind(R.id.sigin_txt)
    TextView siginTxt;
    @Bind(R.id.sigin_progressBar)
    ProgressBar progressBar;
    @Bind(R.id.lostpwd_txt)
    TextView lostpwdTxt;
    @Bind(R.id.register_txt)
    TextView registerTxt;


    @Override
    public int bindLayout() {
        return R.layout.activity_login;
    }

    @Override
    public void initParams() {
        setPresenter(new LoginPresenter(this));
    }

    @Override
    public void initView() {
        initStatusBar();
        ButterKnife.bind(this);
        /* 整体渐入动画 */
        View decView = getWindow().getDecorView();
        AnimateUtil.alphaIn(decView);
    }

    private void initStatusBar() {
        Window window = getWindow();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(getResources().getColor(R.color.colorPrimary));
        }

    }

    @Override
    public void doBusiness() {
        //do nothing
    }

    @OnClick({R.id.signin_layout})
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.signin_layout:
                presenter.login(usernameEdt.getText().toString().trim(),
                        pwdEdt.getText().toString().trim());
                break;
            default:
                break;
        }
    }

    @Override
    public void moveToMainActivity() {
        Intent intent = new Intent(getContext(), MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void setEmailErrorMsg(String msg) {
        usernameEdt.setError(msg);
    }

    @Override
    public void setPwdErrorMsg(String msg) {
        pwdEdt.setError(msg);
    }

    @Override
    public void setLoading(boolean flag) {
        signinLayout.setClickable(!flag);
        siginTxt.setVisibility(flag ? View.GONE : View.VISIBLE);
        progressBar.setVisibility(flag ? View.VISIBLE : View.GONE);
    }

    @Override
    public void showMsg(String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

}
