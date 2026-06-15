package Day6.Pow;

class Solution {
    public double myPow(double x, int n) {
        long N=n;
        double ans=1d;

        if(N<0){        //Check if power is negative or not.
            x=1/x;
            N=-1*N;
        }

        while(N>0){
            if(N%2==1){     //if N is odd then once multiply it so that power becomes even
                ans*=x;
            }
            x=x*x;      //for even power (base*base)**N/2
            N/=2;
        }
        return ans;
        
    }
}

public class Optimal {
    public static void main(String[] args) {
        Solution sol = new Solution();
        // Output: 1024.0000
        System.out.printf("%.4f\n", sol.myPow(2.0000, 10));
        // Output: 0.2500 
        System.out.printf("%.4f\n", sol.myPow(2.0000, -2));
    }
}
