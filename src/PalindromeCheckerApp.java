public class UseCase2PalindromeCheckerApp {
    public static void main(String[] args) {
        String original = "madam";

        String reversed = new StringBuilder(original).reverse().toString();

        if (original.equals(reversed)) {
            System.out.println("The string '" + original + "' is a palindrome.");
        } else {
            System.out.println("The string '" + original + "' is not a palindrome.");
        }
    }
}
