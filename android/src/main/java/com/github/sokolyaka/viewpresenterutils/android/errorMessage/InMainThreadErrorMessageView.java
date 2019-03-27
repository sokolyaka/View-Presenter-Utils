package com.github.sokolyaka.viewpresenterutils.android.errorMessage;

import android.os.Handler;
import android.os.Looper;

import com.github.sokolyaka.viewpresenterutils.core.view.errorMessage.IErrorMessageView;

public class InMainThreadErrorMessageView implements IErrorMessageView {
    private final IErrorMessageView origin;
    private final Handler handler;

    public InMainThreadErrorMessageView(IErrorMessageView origin) {
        this.origin = origin;
        this.handler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void show(final String msg) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                origin.show(msg);
            }
        });
    }
}