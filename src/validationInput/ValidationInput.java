package validationInput;

import java.util.regex.Pattern;

public class ValidationInput {


    public String validationInput(String email, String password) {

        if (email == null || email.isBlank()) {
            return "Email is required";
        }

        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        if (!Pattern.compile(regex).matcher(email).matches()) {
            return "Email is not valid";
        }

        if (password == null || password.isBlank()) {
            return "Password is required";
        }

        if (password.length() < 8) {
            return "Password is Short.";
        }

        return "Input is valid";
    }

}
