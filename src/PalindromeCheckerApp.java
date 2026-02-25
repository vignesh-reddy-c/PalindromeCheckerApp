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
        for (char c : normalized.toCharArray()) stack.push(c);
        for (char c : normalized.toCharArray()) if (c != stack.pop()) return false;
        return true;
    }
}
class DequeStrategy implements PalindromeStrategy {
    public boolean isPalindrome(String input) {
        String normalized = input.replaceAll("\\s+", "").toLowerCase();
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : normalized.toCharArray()) deque.addLast(c);
        while (deque.size() > 1) if (deque.removeFirst() != deque.removeLast()) return false;
        return true;
    }
}
class RecursiveStrategy implements PalindromeStrategy {
    public boolean isPalindrome(String input) {
        String normalized = input.replaceAll("\\s+", "").toLowerCase();
        return check(normalized, 0, normalized.length() - 1);
    }
    private boolean check(String str, int start, int end) {
        if (start >= end) return true;
        if (str.charAt(start) != str.charAt(end)) return false;
        return check(str, start + 1, end - 1);
    }
}
public class PalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        PalindromeStrategy[] strategies = {
                new StackStrategy(),
                new DequeStrategy(),
                new RecursiveStrategy()
        };
        String[] names = {"Stack Strategy", "Deque Strategy", "Recursive Strategy"};
        for (int i = 0; i < strategies.length; i++) {
            long startTime = System.nanoTime();
            boolean result = strategies[i].isPalindrome(input);
            long endTime = System.nanoTime();
            System.out.printf("%s: %s, Time = %d ns%n", names[i], result ? "Palindrome" : "Not Palindrome", (endTime - startTime));
        }
    }
}