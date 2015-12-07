package com.akioss.leanote.utils;

import android.content.Context;
import android.widget.Toast;

import javax.inject.Inject;

public class ToastHelper {

    @Inject
    ToastHelper() {
    }

    Toast toast = null;

    public void showToast(Context context, CharSequence text) {
        if (toast == null) {
            toast = Toast.makeText(context, text, Toast.LENGTH_LONG);
        } else {
            toast.setText(text);
        }
        toast.show();
    }

    public void show(Context context) {
        // showToast(context, utils.getContent());
    }
}
