package rohit.leetcode;



/**
 * Created by rohit on 12/6/20.
 */
public class SubArraysWithKDistinctSolution {
    public int subarraysWithKDistinct(int[] A, int K) {
        int prefix = 0;
        int counter = 0;
        int result = 0;
        //since number in array start with 1 till length we will use length + 1
        int[] m = new int[A.length + 1];
        //Run the loop from start to end
        for(int i = 0,  j = 0; i < A.length ; i++){
            //if this is the first time number is coming we increase the counter
            if(m[A[i]]++ == 0)
                counter++;

            if(counter > K){
                --m[A[j++]]; //reduce counter for A[j] and move J
                --counter;   //reduce counter
                prefix = 0;  //prefix is reset as sequence is broken
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
