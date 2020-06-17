package rohit.leetcode;

import java.security.interfaces.RSAPublicKey;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * Created by rohit on 11/6/20.
 */
public class HighFiveSolution {
    public int[][] highFive(int[][] items) {

        TreeMap<Integer,PriorityQueue<Integer>> map = new TreeMap<>();
        for(int[] score : items){
            map.computeIfAbsent(score[0],f -> new PriorityQueue<Integer>()).add(score[1]);
            if(map.get(score[0]).size() > 5){
                map.get(score[0]).poll();
            }
        }

        int[][] result = new int[map.size()][2];
        int i = 0;
        for(int key : map.keySet()){
            PriorityQueue<Integer> queue = map.get(key);
            int total = 0;
            while (!queue.isEmpty()){
                total += queue.poll();
            }
            int avg = total/5;
            result[i] = new int[]{key,avg};
            i++;
        }
        Arrays.stream(result).forEach(o -> System.out.println(o[0] +" "+o[1]));
        return result;
    }

    public static void main(String[] args) {
        /*int[][] input = {{1,91},{1,92},{2,93},{2,99},{2,98},{2,97},{1,60},{1,58},{2,100},{1,61}};
        HighFiveSolution highFiveSolution = new HighFiveSolution();

        System.out.println(highFiveSolution.highFive(input));*/
        HighFiveSolution highFiveSolution = new HighFiveSolution();
        highFiveSolution.test();
    }

    public void test() {
        int i = (-66 - 67 + 68)/3;
        System.out.println(i);
    }
}
