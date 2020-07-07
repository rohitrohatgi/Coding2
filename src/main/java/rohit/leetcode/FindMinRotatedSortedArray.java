package rohit.leetcode;

public class FindMinRotatedSortedArray {

    public int find(int[] nums){
        // 456789123
        int min = 0;
        int max = nums.length - 1;
        while(min < max){
            int mid = min + (max -min)/2;
            if(nums[mid] >nums[min]){
                min = mid +1;
            }else{
                max = mid;
            }
        }

        return nums[min];
    }
}
