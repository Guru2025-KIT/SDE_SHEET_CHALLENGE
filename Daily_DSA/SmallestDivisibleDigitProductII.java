package Daily_DSA;
public class SmallestDivisibleDigitProductII {

    public String smallestNumber(String num, long t) {
        // Step 1: Count prime factors of t
        int cnt2 = 0, cnt3 = 0, cnt5 = 0, cnt7 = 0;
        while (t % 2 == 0) { cnt2++; t /= 2; }
        while (t % 3 == 0) { cnt3++; t /= 3; }
        while (t % 5 == 0) { cnt5++; t /= 5; }
        while (t % 7 == 0) { cnt7++; t /= 7; }
        
        // If t has prime factors other than 2, 3, 5, 7, it's impossible
        if (t > 1) {
            return "-1";
        }

        int n = num.length();
        // Prefixes state tracking for factors remaining
        int[] p2 = new int[n + 1];
        int[] p3 = new int[n + 1];
        int[] p5 = new int[n + 1];
        int[] p7 = new int[n + 1];
        
        p2[0] = cnt2; p3[0] = cnt3; p5[0] = cnt5; p7[0] = cnt7;
        
        // Find the first zero digit if any exists
        int firstZeroIdx = -1;
        for (int i = 0; i < n; i++) {
            char c = num.charAt(i);
            if (c == '0') {
                if (firstZeroIdx == -1) firstZeroIdx = i;
                p2[i + 1] = p2[i];
                p3[i + 1] = p3[i];
                p5[i + 1] = p5[i];
                p7[i + 1] = p7[i];
            } else {
                int d = c - '0';
                p2[i + 1] = Math.max(0, p2[i] - getFactor(d, 2));
                p3[i + 1] = Math.max(0, p3[i] - getFactor(d, 3));
                p5[i + 1] = Math.max(0, p5[i] - getFactor(d, 5));
                p7[i + 1] = Math.max(0, p7[i] - getFactor(d, 7));
            }
        }

        // Case A: The original number itself is zero-free and satisfies the constraint
        if (firstZeroIdx == -1 && p2[n] == 0 && p3[n] == 0 && p5[n] == 0 && p7[n] == 0) {
            return num;
        }

        // Case B: Try to increment at some position from right to left
        int startIdx = (firstZeroIdx != -1) ? firstZeroIdx : n - 1;
        
        for (int i = startIdx; i >= 0; i--) {
            int curDigit = num.charAt(i) - '0';
            // Try changing the digit at position i to something greater
            for (int d = curDigit + 1; d <= 9; d++) {
                int rem2 = Math.max(0, p2[i] - getFactor(d, 2));
                int rem3 = Math.max(0, p3[i] - getFactor(d, 3));
                int rem5 = Math.max(0, p5[i] - getFactor(d, 5));
                int rem7 = Math.max(0, p7[i] - getFactor(d, 7));
                
                int remLen = n - 1 - i;
                String suffix = getExactMinSuffix(rem2, rem3, rem5, rem7, remLen);
                if (suffix != null) {
                    return num.substring(0, i) + d + suffix;
                }
            }
        }

        // Case C: No valid variation found within the same length. Increase length by 1.
        int len = n + 1;
        while (true) {
            String suffix = getExactMinSuffix(cnt2, cnt3, cnt5, cnt7, len);
            if (suffix != null) {
                return suffix;
            }
            len++;
        }
    }

    // Returns the number of occurrences of a prime factor in a single digit
    private int getFactor(int num, int prime) {
        int count = 0;
        while (num > 0 && num % prime == 0) {
            count++;
            num /= prime;
        }
        return count;
    }

    // Calculates the absolute minimum number of digits required to satisfy the constraints
    private int minDigitsNeeded(int r2, int r3, int r5, int r7) {
        int ans = r5 + r7; // 5 and 7 cannot combine with any other digits
        int minMix = 999;
        
        // Greedily find combinations of 9, 8, 6, 4, 3, 2 that cover remaining 2s and 3s
        for (int c9 = 0; c9 <= r3 / 2 + 1; c9++) {
            for (int c8 = 0; c8 <= r2 / 3 + 1; c8++) {
                for (int c6 = 0; c6 <= 1; c6++) {
                    for (int c4 = 0; c4 <= 1; c4++) {
                        for (int c3 = 0; c3 <= 1; c3++) {
                            for (int c2 = 0; c2 <= 1; c2++) {
                                int twos = c8 * 3 + c6 + c4 * 2 + c2;
                                int threes = c9 * 2 + c6 + c3;
                                if (twos >= r2 && threes >= r3) {
                                    minMix = Math.min(minMix, c9 + c8 + c6 + c4 + c3 + c2);
                                }
                            }
                        }
                    }
                }
            }
        }
        return ans + minMix;
    }

    // Digit-by-digit construction to secure the absolute lexicographically smallest suffix
    private String getExactMinSuffix(int r2, int r3, int r5, int r7, int length) {
        if (minDigitsNeeded(r2, r3, r5, r7) > length) {
            return null;
        }
        
        StringBuilder sb = new StringBuilder();
        int curr2 = r2, curr3 = r3, curr5 = r5, curr7 = r7;
        
        int[][] digitFactors = {
            {0,0,0,0}, // 0 (unused)
            {0,0,0,0}, // 1
            {1,0,0,0}, // 2
            {0,1,0,0}, // 3
            {2,0,0,0}, // 4
            {0,0,1,0}, // 5
            {1,1,0,0}, // 6
            {0,0,0,1}, // 7
            {3,0,0,0}, // 8
            {0,2,0,0}  // 9
        };

        for (int l = length; l > 0; l--) {
            for (int d = 1; d <= 9; d++) {
                int next2 = Math.max(0, curr2 - digitFactors[d][0]);
                int next3 = Math.max(0, curr3 - digitFactors[d][1]);
                int next5 = Math.max(0, curr5 - digitFactors[d][2]);
                int next7 = Math.max(0, curr7 - digitFactors[d][3]);
                
                if (minDigitsNeeded(next2, next3, next5, next7) <= l - 1) {
                    sb.append(d);
                    curr2 = next2;
                    curr3 = next3;
                    curr5 = next5;
                    curr7 = next7;
                    break;
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        SmallestDivisibleDigitProductII solver = new SmallestDivisibleDigitProductII();
        
        // Your failing testcase
        String num = "12";
        long t = 1968750;
        
        String result = solver.smallestNumber(num, t);
        
        System.out.println("Input num: " + num);
        System.out.println("Input t  : " + t);
        System.out.println("Output   : " + result);
        System.out.println("Expected : 255555579");
    }
}
