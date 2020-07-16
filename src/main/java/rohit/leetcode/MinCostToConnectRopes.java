package rohit.leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

/*
You have some sticks with positive integer lengths.

You can connect any two sticks of lengths X and Y into one stick by paying a cost of X + Y.  You perform this action until there is one stick remaining.

Return the minimum cost of connecting all the given sticks into one stick in this way.



Example 1:

Input: sticks = [2,4,3]
Output: 14

Example 2:

Input: sticks = [1,8,3,5]
Output: 30

 */
public class MinCostToConnectRopes {
    public int connectSticks(int[] sticks) {
        Queue<Integer> queue = new PriorityQueue<>();
        for(int stick : sticks){
            queue.offer(stick);
        }
        int cost = 0;
        while(!queue.isEmpty() && queue.size() > 1){
            int first = queue.poll();
            int second = queue.poll();
            cost += (first + second);
            if(!queue.isEmpty())
                queue.offer(first + second);
            else
                break;
        }
        return cost;
    }
}
