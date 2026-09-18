package domain.result.user;

import domain.result.Error;

public class UserError {
    public static final Error NAME_REQUIRED = new Error("USER_NAME_REQUIRED", "Name cannot be empty");
    public static final Error EMAIL_REQUIRED = new Error("USER_EMAIL_REQUIRED", "Email cannot be empty");
    public static final Error USER_BIRTH_DATE_REQUIRED = new Error("USER_BIRTH_DATE_REQUIRED", "Birthdate cannot be empty");
    public static final Error EMAIL_INVALID = new Error("USER_EMAIL_INVALID", "Invalid email format");
    public static final Error UNDERAGE = new Error("USER_UNDERAGE", "User must be at least 18 years old");

    public static final Error EMAIL_ALREADY_EXISTS = new Error("USER_EMAIL_ALREADY_EXISTS", "Email is already registered");

    public static final Error CREATION_FAILED = new Error("USER_CREATION_FAILED", "An unexpected error occurred while creating the user");
}
