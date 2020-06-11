package rohit.leetcode;

/**
 * Created by rohit on 9/6/20.
 */
public class MedianSortedArrays {
    public double findMedianSortedArrays(int[] A, int[] B) {
        /*[1,2] //
        3,4]*/

        int m,n;
        if(A.length > B.length){
            int[] temp = A;
            A = B;
            B = temp;
        }
        m = A.length;
        n = B.length;

        int half = (m + n + 1)/2;
        int min = 0;
        int max = m;

        while (min <= max){
            int i = ( max + min)/2;
            int j = half - i;
            if(i < max && B[j-1] > A[i]){
                min =  i + 1;
            }else if(i > min && A[i - 1] > B[j] ){
                max = i - 1;
            }else {
                int maxLeft = 0;
                if(i == 0)
                    maxLeft = B[j - 1];
                else if(j == 0)
                    maxLeft = A[i - 1];
                else
                    maxLeft = Math.max( B[j - 1], A[i - 1]);
                if((m + n) % 2 == 1)
                    return maxLeft;

                int minRight = 0;

                if(i == m)
                    minRight = B[j];
                else if(j == n)
                    minRight = A[i];
                else
                    minRight = Math.min( B[j], A[i]);
                System.out.println((maxLeft + minRight) / 2);
                return ((maxLeft + minRight ) / 2.0);

            }

        }

        return 0.0;

    }

    public static void main(String[] args) {
        MedianSortedArrays medianSortedArrays = new MedianSortedArrays();
        int[] first = {1,2};
        int[] second = {-1,3};


        System.out.println(medianSortedArrays.findMedianSortedArrays(first,second));
    }

}
