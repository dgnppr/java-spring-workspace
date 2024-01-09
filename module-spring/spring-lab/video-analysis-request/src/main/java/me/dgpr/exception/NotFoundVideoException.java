package me.dgpr.exception;

public class NotFoundVideoException extends RuntimeException {

    private static final String MESSAGE_FORMAT = "비디오 조회 실패 [idx=%d]";

    public NotFoundVideoException(final long idx) {
        super(String.format(MESSAGE_FORMAT, idx));
    }
}
