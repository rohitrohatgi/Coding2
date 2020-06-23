package rohit.leetcode;

import java.util.Arrays;

/**
 * Created by rohit on 23/6/20.
 * We have a list of points on the plane.  Find the K closest points to the origin (0, 0).
 */
public class KClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int K) {
        int[] distanceArray = new int[points.length];
        for(int i = 0; i < points.length ;  i++){
            distanceArray[i] = distance(points[i]);
        }

        Arrays.sort(distanceArray);

        distanceArray = Arrays.copyOfRange(distanceArray, 0, K);

        for(int x: distanceArray){
            System.out.println(x);
        }

        int[][] result = new int[distanceArray.length][2];
        int j = 0;

        for(int i = 0; i < points.length ;  i++){
            if(distance(points[i]) <= distanceArray[distanceArray.length -1] ){
                result[j] = points[i];
                j++;
            }
        }

        return result;

    }

    private int distance(int[] p){
        return (p[0] * p[0] + p[1] * p[1]);
    }
}
