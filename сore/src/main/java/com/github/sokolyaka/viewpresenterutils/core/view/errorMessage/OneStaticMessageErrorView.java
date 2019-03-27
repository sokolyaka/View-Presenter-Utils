package com.github.sokolyaka.viewpresenterutils.core.view.errorMessage;

public class OneStaticMessageErrorView implements IErrorMessageView {
    private final IErrorMessageView origin;
    private final String messageToShow;

    public OneStaticMessageErrorView(IErrorMessageView origin, String messageToShow) {
        this.origin = origin;
        this.messageToShow = messageToShow;
    }

    @Override
    public void show(String msg) {
        origin.show(messageToShow);
    }
}