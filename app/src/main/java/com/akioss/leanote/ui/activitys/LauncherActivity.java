package com.akioss.leanote.ui.activitys;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.view.KeyEvent;
import android.view.Window;
import android.widget.ImageView;

import com.akioss.leanote.R;
import com.akioss.leanote.utils.AnimateUtil;

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

    @Override
    public int bindLayout() {
        return R.layout.activity_launcher;
    }

    @Override
    public void initParams() {

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
                Intent moveToLoginIntent = new Intent(getContext(), LoginActivity.class);
                ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                        getContext(), launcherImg, getResources().getString(R.string.shareelement_logo)
                );
                ActivityCompat.startActivity(getContext(), moveToLoginIntent, options.toBundle());
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
        Window window = getWindow();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(getResources().getColor(R.color.white));
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
