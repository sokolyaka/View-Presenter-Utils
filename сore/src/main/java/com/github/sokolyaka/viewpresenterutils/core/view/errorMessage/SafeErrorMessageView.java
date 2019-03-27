package com.github.sokolyaka.viewpresenterutils.core.view.errorMessage;

public class SafeErrorMessageView implements IErrorMessageView {

    private final String TAG;
    private final IErrorMessageView origin;
    private final Logger logger;

    public SafeErrorMessageView(IErrorMessageView origin, Logger logger) {
        this(SafeErrorMessageView.class.getSimpleName(), origin, logger);
    }

    public SafeErrorMessageView(String tag, IErrorMessageView origin, Logger logger) {
        TAG = tag;
        this.origin = origin;
        this.logger = logger;
    }

    @Override
    public void show(String msg) {
        try {
            origin.show(msg);
        } catch (Throwable t) {
            logger.log(TAG, "msg: " + msg, t);
        }
    }

    public interface Logger {
        void log(String tag, String msg, Throwable t);
    }
}