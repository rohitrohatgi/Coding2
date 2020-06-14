package rohit.leetcode;

/**
 * Created by Rohit on 14-06-2020.
 * This code is only used for learning purpose.
 */
public class KnightProbabilityChessboardSolution {

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

        double[][][] dp = new double[K+1][N][N];

        dp[0][r][c] = 1;
        for(int k = 1; k <= K; k++){
            for(int i = 0; i < N; i++){
                for(int j= 0; j < N; j++){
                    for(int d = 0; d < directions.length; d++){
                        int prevRow = i - directions[d][0];
                        int prevCol = j - directions[d][1];
                        if(prevCol >= 0 && prevRow >=0 && prevCol < N && prevRow < N){

                            dp[k][i][j] = dp[k][i][j] + 0.125 * dp[k - 1][prevRow][prevCol];
                        }

                    }
                }
            }
        }

        for(double[] rows : dp[K]){
            for(double value : rows){
                result+=value;
            }
        }
        return result;

    }
}
