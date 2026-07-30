package Strings;
import java.util.Scanner;
public class DetectCapital {

    static class Solution {
        public boolean detectCapitalUse(String word) {
            int n = word.length();
            int capital = 0;

            for (int i = 0; i < n; i++) {
                if (Character.isUpperCase(word.charAt(i))) {
                    capital++;
                }
            }

            return capital == n || capital == 0 || (Character.isUpperCase(word.charAt(0)) && capital == 1);
        }
    }

    // Main method to run and test your code in VS Code
    public static void main(String[] args) {
        Solution solver = new Solution();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a word to test: ");
        String input = scanner.next();

        boolean result = solver.detectCapitalUse(input);
        System.out.println("Result: " + result);

        scanner.close();
    }
}
