package rohit.leetcode;
/**
 * Created by rohit on 17/6/20.
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        int result = 0;
        if(height.length <= 2){
            return result;
        }
        int left = 0;
        int right = height.length - 1;

        int leftMax = height[left];
        int rightMax = height[right];

        while(left + 1 < right){
            leftMax = Math.max(leftMax,height[left]);
            rightMax = Math.max(rightMax,height[right]);
            int current = Math.min(leftMax,rightMax);

            if(leftMax < rightMax){
                current -= height[leftMax + 1];
                left++;
            }else{
                current -= height[rightMax - 1];
                right--;
            }

            if(current > 0){
                result += current;
            }

        }
        return result;
    }
}