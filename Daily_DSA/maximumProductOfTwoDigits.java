package Daily_DSA;

import java.util.Scanner;

public class  maximumProductOfTwoDigits{
    
    // The optimized algorithm method
    public int maxProduct(int n) {
        int max1 = 0;
        int max2 = 0;

        // Handle negative numbers safely
        n = Math.abs(n); 

        // Edge case: if input is a single digit, product is just 0 * digit
        if (n < 10) {
            return 0; 
        }

        while (n != 0) {
            int digit = n % 10;
            
            if (digit > max1) {
                max2 = max1;
                max1 = digit;
            } else if (digit > max2) {
                max2 = digit;
            }
            
            n /= 10;
        }

        return max1 * max2;
    }

    // Main method required to execute inside VS Code
    public static void main(String[] args) {
        maximumProductOfTwoDigits solver = new maximumProductOfTwoDigits();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter an integer: ");
        if (scanner.hasNextInt()) {
            int input = scanner.nextInt();
            int result = solver.maxProduct(input);
            System.out.println("Maximum product of two digits: " + result);
        } else {
            System.out.println("Invalid input. Please enter a valid integer.");
        }

        scanner.close();
    }
}
