package com.akioss.leanote.widgets;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/*****************************************************************************************************************
 * Author: liyi
 * Create Date: 15/12/2.
 * Package: com.akioss.leanote.views
 * Discription:
 * Version: 1.0
 * ---------------------------------------------------------------------------------------------------------------
 * Modified By:
 * Modified Date:
 * Why & What is modified :
 *****************************************************************************************************************/
public class LeanoteTextView extends TextView {

    public LeanoteTextView(Context context) {
        super(context);

        if (!isInEditMode()) {
            init(context);
        }
    }

    public LeanoteTextView(Context context, AttributeSet attrs) {
        super(context, attrs);

        if (!isInEditMode()) {
            init(context);
        }
    }

    public LeanoteTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        if (!isInEditMode()) {
            init(context);
        }
    }

    private void init(Context context) {

        Typeface t = Typeface.createFromAsset(context.getAssets(), "fonts/cai_804.ttf");
        this.setTypeface(t);
    }
}
