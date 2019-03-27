package com.github.sokolyaka.viewpresenterutils.android.errorMessage;

import android.content.ContextWrapper;
import android.widget.Toast;

import com.github.sokolyaka.viewpresenterutils.core.view.errorMessage.IErrorMessageView;

public class ToastErrorMessageView implements IErrorMessageView {
    private final ContextWrapper contextWrapper;

    public ToastErrorMessageView(ContextWrapper contextWrapper) {
        this.contextWrapper = contextWrapper;
    }

    @Override
    public void show(String msg) {
        if (contextWrapper.getBaseContext() != null) {
            Toast.makeText(
                    contextWrapper,
                    msg,
                    Toast.LENGTH_SHORT
            ).show();
        }

    }
}
