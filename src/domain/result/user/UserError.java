package domain.result.user;

import domain.result.Error;

public class UserError {
    public static Error NAME_REQUIRED = new Error("USER_NAME_REQUIRED", "Name cannot be empty");
    public static Error EMAIL_REQUIRED = new Error("USER_EMAIL_REQUIRED", "Email cannot be empty");
    public static Error BIRTHDATE_REQUIRED = new Error("USERBIRTH_DATE_REQUIRED", "Birthdate cannot be empty");
    public static Error EMAIL_INVALID = new Error("USER_EMAIL_INVALID", "Invalid email format");
    public static Error UNDERAGE = new Error("USER_UNDERAGE", "User must be at least 18 years old");

    public static Error CREATION_FAILED = new Error("USER_CREATION_FAILED", "An unexpected error occurred while creating the user");
    public static Error EMAIL_ALREADY_EXISTS = new Error("USER_EMAIL_ALREADY_EXISTS", "Email is already registered");
}
