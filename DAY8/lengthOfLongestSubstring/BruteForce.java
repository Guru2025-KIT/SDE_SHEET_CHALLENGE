package DAY8.lengthOfLongestSubstring;

import java.util.Arrays;

class Solution {
    public int longestNonRepeatingSubstring(String s) {
        
        int maxLen=0;
        for(int i=0;i<s.length();i++){
            int[] hash=new int[256];    //0-255 all characters-->store them in hash Array
            Arrays.fill(hash, 0);   //Make all the positions zero

            for(int j=i;j<s.length();j++){
                if(hash[s.charAt(j)]==1){   //check if that character is already present.
                    break;
                }
                hash[s.charAt(j)]=1;    //if not present mark it in hash
                int len=j-i+1;
                maxLen=Math.max(maxLen,len);
            }
        }
        return maxLen;
    
    }
    
}

// Separate main class
public class BruteForce {
    public static void main(String[] args) {
        String input = "cadbzabcd";

        Solution sol = new Solution();
        int length = sol.longestNonRepeatingSubstring(input);

        System.out.println("Length of longest substring without repeating characters: " + length);
    }
}