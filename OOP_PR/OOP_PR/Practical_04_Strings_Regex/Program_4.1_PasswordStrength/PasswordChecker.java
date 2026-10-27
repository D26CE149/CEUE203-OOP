public class PasswordChecker {
    public PasswordChecker() {
    }

    public static boolean hasMinimumLength(String var0) {
        return var0.length() >= 8;
    }

    public static boolean hasUppercase(String var0) {
        return var0.matches(".*[A-Z].*");
    }

    public static boolean hasDigit(String var0) {
        return var0.matches(".*[0-9].*");
    }

    public static boolean hasSpecialCharacter(String var0) {
        return var0.matches(".*[^a-zA-Z0-9].*");
    }

    public static String strength(String var0) {
        int var1 = 0;
        if (hasMinimumLength(var0)) {
            ++var1;
        }

        if (hasUppercase(var0)) {
            ++var1;
        }

        if (hasDigit(var0)) {
            ++var1;
        }

        if (hasSpecialCharacter(var0)) {
            ++var1;
        }

        if (var1 <= 1) {
            return "Weak";
        } else {
            return var1 <= 3 ? "Medium" : "Strong";
        }
    }
}
