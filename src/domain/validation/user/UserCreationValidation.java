package domain.validation.user;

import java.time.LocalDate;

import domain.model.User;
import domain.result.Notification;
import domain.result.user.UserError;
import domain.validation.common.Email;

public class UserCreationValidation {
    public static Notification validate(User user) {
        Notification notification = new Notification();

        validatetName(user, notification);
        validateEmail(user, notification);
        validateBirthDate(user, notification);

        return notification;
    }

    private static void validatetName(User user, Notification notification) {
        if (user.getName() == null || user.getName().isBlank()) {
            notification.addError(UserError.NAME_REQUIRED);
        }
    }

    private static void validateEmail(User user, Notification notification) {
        if (user.getEmail() == null || user.getEmail().isBlank()) {
            notification.addError(UserError.EMAIL_REQUIRED);
            return;
        }

        if (Email.isInvalid(user.getEmail())) {
            notification.addError(UserError.EMAIL_INVALID);
        }
    }

    private static void validateBirthDate(User user, Notification notification) {
        if (user.getBirthDate() == null) {
            notification.addError(UserError.USER_BIRTH_DATE_REQUIRED);
            return;
        }

        if (user.isUnderage(LocalDate.now(

        ))) {
            notification.addError(UserError.UNDERAGE);
        }
    }
}