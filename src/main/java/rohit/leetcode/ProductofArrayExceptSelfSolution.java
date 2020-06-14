package rohit.leetcode;

/**
 * Created by Rohit on 14-06-2020.
 * This code is only used for learning purpose.
 */
public class ProductofArrayExceptSelfSolution {
    public int[] productExceptSelf(int[] nums) {
        //result to be returned
        int[] result = new int[nums.length];
        result[0] = 1;

        //loop left to right start populating 2nd element onwards
        for(int i = 0; i < nums.length -1; i++){
            result[i+1] = result[i] * nums[i];
        }

        //default 1 for right side
        int R = 1;
        for(int i = nums.length - 1; i >=0 ; i--){
            result[i] = result[i] * R;
            R*=nums[i];
        }
        return result;
    }
}
