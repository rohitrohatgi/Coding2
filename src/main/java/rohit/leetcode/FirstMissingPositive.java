package rohit.leetcode;

/**
 * Created by rohit on 23/6/20.
 */
public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {

        int n = nums.length;
        int oneCount = 0;

        for(int i = 0 ; i < n ; i++){
            if(nums[i] == 1)
                oneCount++;
        }

        if(oneCount == 0)
            return 1;

        if(n == 2)
            return 2;

        for(int i = 0 ; i < n ; i++){
            if(nums[i] <= 0 || nums[i] > n){
                nums[i] = 1;
            }
        }

        for(int i = 0 ; i < n ; i++){
            int x = Math.abs(nums[i]);

            if(x == n)
                nums[0] = -Math.abs(nums[0]);
            else
                nums[x] = -Math.abs(nums[x]);
        }

        for(int i = 1 ; i < n ; i++){
            if(nums[i] > 0)
                return i;
        }

        if (nums[0] > 0)
            return n;

        return n+1;
    }
}
