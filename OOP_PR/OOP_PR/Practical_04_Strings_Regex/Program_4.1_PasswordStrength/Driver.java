import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a password: ");
        String pw = scanner.nextLine();

        System.out.println("Password: " + pw);
        System.out.println("Length rule: " + PasswordChecker.hasMinimumLength(pw));
        System.out.println("Uppercase rule: " + PasswordChecker.hasUppercase(pw));
        System.out.println("Digit rule: " + PasswordChecker.hasDigit(pw));
        System.out.println("Special character rule: " + PasswordChecker.hasSpecialCharacter(pw));
        System.out.println("Strength: " + PasswordChecker.strength(pw));

        scanner.close();
    }
}
