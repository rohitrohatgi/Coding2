package rohit.leetcode;



/**
 * Created by rohit on 12/6/20.
 */
public class SubArraysWithKDistinctSolution {
    public int subarraysWithKDistinct(int[] A, int K) {
        int prefix = 0;
        int counter = 0;
        int result = 0;
        int[] m = new int[A.length + 1];

        for(int i = 0,  j = 0; i < A.length ; i++){
            if(m[A[i]]++ == 0)
                counter++;

            if(counter > K){
                --m[A[j++]];
                --counter;
                prefix = 0;
            }

            while (m[A[j]] > 1){
                prefix++;
                --m[A[j++]];
            }

            if(counter == K) result += (prefix + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        SubArraysWithKDistinctSolution subarraysWithKDistinctSolution = new SubArraysWithKDistinctSolution();
        int [] input = {1,2,1,2,3};
        System.out.println(subarraysWithKDistinctSolution.subarraysWithKDistinct(input,2));

    }
}
