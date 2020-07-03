package rohit.leetcode;

import java.util.Arrays;

public class SmallerNumbersThanCurrentSolution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] response = new int[nums.length];
        int[] count = new int[101];
        for(int num : nums){
            count[num]++;
        }
        for(int i =1; i< count.length; i++){
            count[i] = count[i] + count[i - 1];
        }
        for (int i = 0; i < nums.length; i++){
            if(nums[i] == 0)
                response[i] =0;
            else
                response[i] = count[nums[i] - 1];

        }
        return response;
    }

    public static void main(String[] args) {
        SmallerNumbersThanCurrentSolution smallerNumbersThanCurrentSolution = new SmallerNumbersThanCurrentSolution();

        int[] input = new int[]{1,23,4,6,5};

        int[] output = smallerNumbersThanCurrentSolution.smallerNumbersThanCurrent(input);

        Arrays.stream(output).forEach(System.out::println);

    }
}
