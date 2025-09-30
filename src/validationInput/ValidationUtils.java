package validationInput;

import model.TypeAgent;

public class ValidationUtils {

    public static boolean isValidEmail(String email) {
        return email != null && email.contains("@");
    }

    public static boolean isValidPassword(String password) {
        return password != null && password.length() >= 8;
    }

    public static boolean isValidType(String typeInput) {
        if (typeInput == null)
        {
            return false;
        }
        typeInput = typeInput.toUpperCase();
        return typeInput.equals("OUVRIER") || typeInput.equals("STAGIARE");
    }
}
