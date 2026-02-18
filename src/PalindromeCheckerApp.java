import java.util.Scanner;
public class PalindromeCheckerApp {

    public static void main(String[] args) {

        System.out.println("Welcome to Palindrome Checker Application");

        Scanner sc = new Scanner(system.in);
        system.out.println("enter a word to check polindrome :");
        String word = sc.nextLine();
        String reversed = new StringBuilder(word).reverse().toString();

        if (word.equals(reversed)) {
            System.out.println(word + " is a Palindrome");
        } else {
            System.out.println(word + " is not a Palindrome");
        }
    }
}
