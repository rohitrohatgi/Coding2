package rohit.leetcode;

import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * Created by rohit on 11/6/20.
 */
public class HighFiveSolution {
    public int[][] highFive(int[][] items) {
        TreeMap<Integer,PriorityQueue<Integer>> map = new TreeMap<>();

        for(int[] item : items){
            map.computeIfAbsent(item[0],f -> new PriorityQueue<Integer>()).add(item[1]);
        }

        int[][] result = new int[map.keySet().size()][2];
        int index = 0;
        for (Integer i: map.keySet()){
            PriorityQueue<Integer> pq = map.get(i);
            int count = pq.size();
            int sum = 0;
            while (!pq.isEmpty()){
                sum += pq.poll();
            }
            result[index++] = new int[]{i, sum / count};
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] input = {{1,91},{1,92},{2,93},{2,99},{2,98},{2,97},{1,60},{1,58},{2,100},{1,61}};
        HighFiveSolution highFiveSolution = new HighFiveSolution();

        System.out.println(highFiveSolution.highFive(input));
    }
}
