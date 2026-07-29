package Random_Problems;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        
        List<List<Integer>> result=new ArrayList<>();

        if(nums.length==0 || nums.length<4) return result;
        Arrays.sort(nums);
        int n=nums.length;

        //selecting first number
        for(int i=0;i<n-3;i++){

            //skip duplicates for num 1
            if(i>0 && nums[i]==nums[i-1])   continue;

            //selecting second number
            for(int j=i+1;j<n-2;j++){

                //skip duplicates for number 2
                if(j>i+1 && nums[j]==nums[j-1]) continue;

                int left=j+1;
                int right=n-1;

                //selecting 3rd Number
                while(left<right){
                    long sum=(long)nums[i]+nums[j]+nums[left]+nums[right];

                    if(sum==target){

                        result.add(new ArrayList<>(List.of(nums[i],nums[j],nums[left],nums[right])));

                        //skip duplicates for 3rd number
                        while(left<right && nums[left]==nums[left+1])   left++;

                        //skip duplicates for 4th Element
                        while(left<right && nums[right]==nums[right-1]) right--;

                        left++;
                        right--;
                    }else if(sum>target){
                        right--;
                    }else{
                        left++;
                    }
                }
            }
        }
        return result;
}
    


    // VS Code execution entry point
    public static void main(String[] args) {
        FourSum solver = new FourSum();

        // Testing the exact integer overflow case you encountered
        int[] case1Nums={1,0,-1,0,-2,2};
        int case1Target = 0;

        System.out.println("--- Running Case 1 ---");
        List<List<Integer>> output = solver.fourSum(case1Nums, case1Target);
        System.out.println("Output: " + output); 

    
    }
}
