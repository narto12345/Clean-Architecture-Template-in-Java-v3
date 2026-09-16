package domain.result;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Notification {
    private final List<Error> errors = new ArrayList<>();

    public void addError(String code, String message) {
        this.errors.add(new Error(code, message));
    }

    public void addError(Error error) {
        this.errors.add(error);
    }

    public void addErrors(Notification notification) {
        this.errors.addAll(notification.getErrors());
    }

    public boolean hasErrors() {
        return !this.errors.isEmpty();
    }

    public List<Error> getErrors() {
        return Collections.unmodifiableList(this.errors);
    }
}