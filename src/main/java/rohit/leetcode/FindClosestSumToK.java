package rohit.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Given 2 lists a and b. Each element is a pair of integers where the first integer represents the unique id and the second integer represents a value.
Your task is to find an element from a and an element form b such that the sum of their values is less or equal to target and as close to target as possible.
Return a list of ids of selected elements. If no pair is possible, return an empty list.

this is the simpler version: https://leetcode.com/problems/two-sum-less-than-k/

 */
public class FindClosestSumToK {
    private List<int[]> getPairs(List<int[]> a, List<int[]> b, int target) {
        Collections.sort(a,(x,y) -> x[1] - y[1] );
        Collections.sort(b,(x,y) -> x[1] - y[1] );
        int m = a.size();
        int n = b.size();

        int i = 0;
        int j = n-1;
        int maxSum = Integer.MIN_VALUE;
        List<int[]> result = new ArrayList<>();
        while(i<m && j>=0){
            int sum = a.get(i)[1] + b.get(j)[1];
            if(sum > target){
                j--;
            }else{
                if(maxSum <= sum) {
                    if (sum > maxSum) {
                        maxSum = sum;
                        result.clear();
                    }
                    result.add(new int[]{a.get(i)[0], b.get(j)[0]});
                    int index = j-1;
                    while(index >=0 && b.get(index)[1] == b.get(index+1)[1]) {
                        result.add(new int[]{a.get(i)[0], b.get(index--)[0]});
                    }
                }
                i++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<int[]> a = new ArrayList<>();
        a.add(new int[]{1,1});
        a.add(new int[]{2,1});
        a.add(new int[]{3,1});
        List<int[]> b = new ArrayList<>();
        b.add(new int[]{1,1});
        b.add(new int[]{2,1});
        b.add(new int[]{3,1});

        FindClosestSumToK findClosestSumToK = new FindClosestSumToK();
        List<int[]> result = findClosestSumToK.getPairs(a,b,2);

        for(int[] item : result){
            System.out.println(item[0] + " : " + item[1]);
        }
    }
}
