package rohit.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rohit on 15/6/20.
 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if(matrix.length == 0)
            return result;
        int rowBegin =  0;
        int rowEnd = matrix.length -1;
        int colBegin =  0;
        int colEnd = matrix[0].length -1;
        while (rowBegin <= rowEnd && colBegin <= colEnd){
            for(int i = colBegin; i <= colEnd ; i++){
                result.add(matrix[rowBegin][i]);
            }
            rowBegin++;
            for(int i = rowBegin; i <= rowEnd ; i++){
                result.add(matrix[i][colEnd]);
            }
            colEnd--;

            if((rowBegin <= rowEnd && colBegin <= colEnd)){

                for(int i = colEnd; i >= colBegin ; i--){
                    result.add(matrix[rowEnd][i]);
                }
                rowEnd--;
                for(int i = rowEnd; i >= rowBegin ; i--){
                    result.add(matrix[i][colBegin]);
                }
                colBegin++;
            }
        }
        return result;

    }

    public static void main(String[] args) {

    }
}
