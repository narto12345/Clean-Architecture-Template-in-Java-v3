package domain.result;

public class Result<T> {
    private final T value;
    private final Notification notification;

    private Result(T value, Notification notification) {
        this.value = value;
        this.notification = notification;
    }

    public static <T> Result<T> success(T value) {
        return new Result<>(value, new Notification());
    }

    public static <T> Result<T> failure(Notification notification) {
        return new Result<>(null, notification);
    }

    public static <T> Result<T> failure(Error error) {
        Notification n = new Notification();
        n.addError(error);
        return new Result<>(null, n);
    }

    public boolean isSuccess() {
        return !notification.hasErrors();
    }

    public boolean isFailure() {
        return notification.hasErrors();
    }

    public T getValue() {
        if (isFailure()) {
            throw new IllegalStateException("Cannot retrieve value from a failed result.");
        }
        return value;
    }

    public Notification getNotification() {
        return notification;
    }
}