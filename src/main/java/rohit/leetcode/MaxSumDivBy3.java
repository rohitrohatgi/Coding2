package rohit.leetcode;

import java.util.Arrays;
/*3,6,5,1,8
dp [0,0,0] -> 3
dp2 [3,0,0]

dp [3,0,0]  -> 6
dp2 [9,0,0]

dp [9,0,0] -> 5
dp2 [9,0,5]

*/
public class MaxSumDivBy3 {
    public int maxSumDivThree(int[] A) {
      //  int[] dp = {0,Integer.MIN_VALUE,Integer.MIN_VALUE};
        int[] dp = new int[3];

        for(int a : A) {
            int[] dp2 = Arrays.copyOf(dp,3);
            for(int i = 0; i < 3; i++){
                int x = dp[i];
                dp2[(x + a) % 3]  =  Math.max(dp2[(x + a) % 3], x + a);
            }
            System.out.println(dp2[0] +"  "+dp2[1]+"  "+dp2[2]);
            dp = dp2;
        }
        return dp[0];
    }

    public static void main(String[] args) {
        MaxSumDivBy3 maxSumDivBy3 = new MaxSumDivBy3();
        int[] intput = {3,6,5,1,8};
        System.out.println(maxSumDivBy3.maxSumDivThree(intput));
    }
}
