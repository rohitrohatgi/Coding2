package rohit.leetcode;

/**
 * Created by rohit on 17/6/20.
 */
public class ShuffleArraySolution {
    public int[] shuffle(int[] nums, int n) {
        int[] result = new int[n * 2];
        for(int i = 0, j = n, index = 0; index < nums.length; index++){
            if(index % 2 == 0)
                result[index] = nums[i++];
            else
                result[index] = nums[j++];
        }
        return result;
    }
}
