package com.github.sokolyaka.viewpresenterutils.android.errorMessage;

import com.github.sokolyaka.viewpresenterutils.core.view.errorMessage.IErrorMessageView;

public class DialogErrorMessageView implements IErrorMessageView {
    private final IDialogBuilder dialogBuilder;

    public DialogErrorMessageView(IDialogBuilder dialogBuilder) {
        this.dialogBuilder = dialogBuilder;
    }

    @Override
    public void show(final String msg) {
        dialogBuilder.build(msg).show();
    }
}
