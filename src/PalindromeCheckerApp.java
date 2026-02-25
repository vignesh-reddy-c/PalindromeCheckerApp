package src;
import java.util.Scanner;
import java.util.Stack;
import java.util.ArrayDeque;
import java.util.Deque;
interface PalindromeStrategy {
    boolean isPalindrome(String input);
}
class StackStrategy implements PalindromeStrategy {
    public boolean isPalindrome(String input) {
        String normalized = input.replaceAll("\\s+", "").toLowerCase();
        Stack<Character> stack = new Stack<>();
        for (char c : normalized.toCharArray()) {
            stack.push(c);
        }
        for (char c : normalized.toCharArray()) {
            if (c != stack.pop()) return false;
        }
        return true;
    }
}
class DequeStrategy implements PalindromeStrategy {
    public boolean isPalindrome(String input) {
        String normalized = input.replaceAll("\\s+", "").toLowerCase();
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : normalized.toCharArray()) {
            deque.addLast(c);
        }
        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) return false;
        }
        return true;
    }
}
class PalindromeChecker {
    private PalindromeStrategy strategy;
    public PalindromeChecker(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }
    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }
    public boolean check(String input) {
        return strategy.isPalindrome(input);
    }
}
public class PalindromeCheckerApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        System.out.println("Choose strategy: 1 = Stack, 2 = Deque");
        int choice = sc.nextInt();
        sc.nextLine();
        PalindromeStrategy strategy = (choice == 2) ? new DequeStrategy() : new StackStrategy();
        PalindromeChecker checker = new PalindromeChecker(strategy);
        if (checker.check(input)) {
            System.out.println("The given string is a Palindrome.");
        } else {
            System.out.println("The given string is not a Palindrome.");
        }
    }
}