package com.github.sokolyaka.viewpresenterutils.core.view.errorMessage;

public class IgnoreErrorMessageView implements IErrorMessageView {
    private final IErrorMessageView origin;
    private final String ignoreMsg;

    public IgnoreErrorMessageView(IErrorMessageView origin, String ignoreMsg) {
        this.origin = origin;
        this.ignoreMsg = ignoreMsg;
    }

    @Override
    public void show(String msg) {
        if (!ignoreMsg.equals(msg)) {
            origin.show(msg);
        }
    }
}