package com.akioss.leanote.ui.activitys;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.ImageView;

import com.akioss.leanote.R;
import com.akioss.leanote.common.Constants;
import com.akioss.leanote.utils.AnimateUtil;
import com.akioss.leanote.utils.GlobalSharePres;
import com.akioss.leanote.utils.StatusBarUtil;

import butterknife.Bind;
import butterknife.ButterKnife;

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
public class LauncherActivity extends BaseFragmentActivity {

    @Bind(R.id.launcher_img)
    ImageView launcherImg;

    private GlobalSharePres sharePres;

    @Override
    public int bindLayout() {
        return R.layout.activity_launcher;
    }

    @Override
    public void initParams() {
        sharePres = new GlobalSharePres(getContext(), Constants.PRES_ACCOUNT);
    }

    @Override
    public void initView() {
        initStatusBar();
        ButterKnife.bind(this);
    }

    @Override
    public void doBusiness() {
        ObjectAnimator animator = AnimateUtil.tada(launcherImg);
        animator.start();
        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                moveToNextActivity();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }

    private void initStatusBar() {
        StatusBarUtil.setColor(getContext(), getResources().getColor(R.color.white));
    }

    private void moveToNextActivity() {
        if ( TextUtils.isEmpty(sharePres.loadString("token"))) {
            Intent moveToLoginIntent = new Intent(getContext(), LoginActivity.class);
            ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                    getContext(), launcherImg, getResources().getString(R.string.shareelement_logo)
            );
            ActivityCompat.startActivity(getContext(), moveToLoginIntent, options.toBundle());
            finish();
        } else {
            Intent moveToMainActivity = new Intent(getContext(), MainActivity.class);
            startActivity(moveToMainActivity);
            finish();
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK
                && event.getAction() == KeyEvent.ACTION_DOWN) {
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
