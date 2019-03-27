package com.github.sokolyaka.viewpresenterutils.android.errorMessage;

import android.app.Dialog;
import android.content.DialogInterface;

import com.github.sokolyaka.viewpresenterutils.core.view.errorMessage.IErrorMessageView;

import java.util.HashMap;
import java.util.Map;

public class OnlyUniqueErrorMessageView implements IErrorMessageView {
    private final IDialogBuilder dialogBuilder;
    private final Map<String, Dialog> map;

    public OnlyUniqueErrorMessageView(IDialogBuilder dialogBuilder) {
        this(dialogBuilder, new HashMap<String, Dialog>());
    }

    public OnlyUniqueErrorMessageView(IDialogBuilder dialogBuilder, Map<String, Dialog> mapToStoreDialogs) {
        this.dialogBuilder = dialogBuilder;
        map = mapToStoreDialogs;
    }

    @Override
    public void show(final String msg) {
        if (map.containsKey(msg)) {
            return;
        }
        final Dialog dialog = dialogBuilder.build(msg);
        dialog.setOnDismissListener(
                new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialog) {
                        map.remove(msg);
                    }
                });
        dialog.show();
        map.put(msg, dialog);
    }
}
