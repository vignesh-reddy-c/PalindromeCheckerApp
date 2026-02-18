import java.util.Scanner;
public class PalindromeCheckerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string to check: ");
        String original = scanner.nextLine();

        if (original == null || original.isEmpty()) {
            System.out.println("Invalid input. Please enter a non-empty string.");
        } else {
            String reversed = "";
            int length = original.length();

            for (int i = length - 1; i >= 0; i--) {
                reversed += original.charAt(i);
            }
            if (original.equals(reversed)) {
                System.out.println("Result: \"" + original + "\" is a palindrome.");
            } else {
                System.out.println("Result: \"" + original + "\" is not a palindrome.");
            }
        }
        scanner.close();
    }
}
