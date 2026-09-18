package domain.validation.user;

import domain.model.User;
import domain.result.Notification;
import domain.result.user.UserError;

public class UserValidator {
    public static Notification validate(User user) {
        Notification notification = new Notification();

        if (user.getName() == null || user.getName().isBlank()) {
            notification.addError(UserError.NAME_REQUIRED);
        }

        // TODO: Esto es de formato, trasladar esta validacion
        if (user.getEmail() == null || !user.getEmail().contains("@")) {
            notification.addError(UserError.EMAIL_INVALID);
        }

        if (user.isUnderage()) {
            notification.addError(UserError.UNDERAGE);
        }

        return notification;
    }
}