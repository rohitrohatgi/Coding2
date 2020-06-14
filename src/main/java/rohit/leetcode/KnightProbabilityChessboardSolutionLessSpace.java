package rohit.leetcode;

/**
 * Created by Rohit on 14-06-2020.
 * This code is only used for learning purpose.
 */
public class KnightProbabilityChessboardSolutionLessSpace {
    public double knightProbability(int N, int K, int r, int c) {
        int[][] directions = {
                {-2,1},
                {-2,-1},
                {2,1},
                {2,-1},
                {-1,2},
                {1,2},
                {-1,-2},
                {1,-2}
        };

        double result = 0.0;
        double[][] dp2 = new double[N][N];
        double[][] dp = new double[N][N];

        dp2[r][c] = 1;
        for(int k = 1; k <= K; k++){
            dp = new double[N][N];
            for(int i = 0; i < N; i++){
                for(int j= 0; j < N; j++){
                    for(int d = 0; d < directions.length; d++){
                        int prevRow = i - directions[d][0];
                        int prevCol = j - directions[d][1];
                        if(prevCol >= 0 && prevRow >=0 && prevCol < N && prevRow < N){

                            dp[i][j] = dp[i][j] + 0.125 * dp2[prevRow][prevCol];
                        }

                    }
                }
            }
            dp2 = dp;
        }

        for(double[] rows : dp2){
            for(double value : rows){
                result+=value;
            }
        }
        return result;

    }

}
