package rohit.leetcode;

public class MaxSumDivBy3 {
    public int maxSumDivThree(int[] A) {
        int[] dp = {0,Integer.MIN_VALUE,Integer.MIN_VALUE};
        for(int a : A){
            int[] dp2 = new int[3];
            for(int i = 0; i < 3; i++){
                dp2[(a + i) % 3] = Math.max(dp[(a + i) % 3],dp[i] + a);
            }
            dp = dp2;
        }
        return dp[0];

    }

    public static void main(String[] args) {
        MaxSumDivBy3 maxSumDivBy3 = new MaxSumDivBy3();
        int[] intput = {5,4};
        System.out.println(maxSumDivBy3.maxSumDivThree(intput));
    }
}
