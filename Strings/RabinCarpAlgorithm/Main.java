package Strings.RabinCarpAlgorithm;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Standard match requiring repetitions
        String a1 = "abcd";
        String b1 = "cdabcdab";
        int result1 = solution.repeatedStringMatch(a1, b1);
        System.out.println("Test 1 Result: " + result1); // Expected output: 3 ("abcdabcdabcd")

        // Test Case 2: Pattern already exists inside 'a' without repetition
        String a2 = "a";
        String b2 = "a";
        int result2 = solution.repeatedStringMatch(a2, b2);
        System.out.println("Test 2 Result: " + result2); // Expected output: 1

        // Test Case 3: Match is completely impossible
        String a3 = "abc";
        String b3 = "wxyz";
        int result3 = solution.repeatedStringMatch(a3, b3);
        System.out.println("Test 3 Result: " + result3); // Expected output: -1
    }
}

class Solution {
    public int repeatedStringMatch(String a, String b) {
        StringBuilder sb = new StringBuilder(a);
        int repeatCount = 1;

        // 1. Repeat string 'a' until its length is at least the length of 'b'
        while (sb.length() < b.length()) {
            sb.append(a);
            repeatCount++;
        }

        // 2. Search for 'b' (pattern) in the repeated text string using Rabin-Karp
        if (rabinKarpContains(sb.toString(), b)) {
            return repeatCount;
        }

        // 3. Append 'a' one more time in case 'b' spans across a boundary seam
        sb.append(a);
        if (rabinKarpContains(sb.toString(), b)) {
            return repeatCount + 1;
        }

        return -1;
    }

    // Your corrected Rabin-Karp pattern searching algorithm
    private boolean rabinKarpContains(String txt, String pat) {
        final int d = 256;    // characters (base)
        int q = 103;          // prime number
        int n = txt.length(); // length of long repeated text
        int m = pat.length(); // length of target pattern 'b'
        int h = 1;            // for calculating highest weight
        int p = 0;            // pattern hash
        int t = 0;            // window hash

        if (m > n || m == 0 || n == 0) {
            return false;
        }

        // Calculating h
        for (int i = 0; i < m - 1; i++) {
            h = (h * d) % q;
        }

        // Calculate first window and pattern hash
        for (int i = 0; i < m; i++) {
            p = (p * d + pat.charAt(i)) % q;
            t = (t * d + txt.charAt(i)) % q;
        }

        // Slide the pattern over the text
        for (int i = 0; i <= n - m; i++) {
            if (p == t) {
                // Check for characters to avoid spurious hits (collisions)
                int j = 0;
                for (j = 0; j < m; j++) {
                    if (pat.charAt(j) != txt.charAt(i + j)) {
                        break;
                    }
                }

                if (j == m) {
                    return true; // Match found!
                }
            }

            // Calculate rolling hash for the next window
            if (i < n - m) {
                t = (d * (t - txt.charAt(i) * h) + txt.charAt(i + m)) % q;

                // Handle negative hash results in Java
                if (t < 0) {
                    t = t + q;
                }
            }
        }
        return false;
    }
}

