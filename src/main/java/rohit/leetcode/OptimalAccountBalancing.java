package rohit.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
A group of friends went on holiday and sometimes lent each other money. For example, Alice paid for Bill's lunch for $10.
Then later Chris gave Alice $5 for a taxi ride.
We can model each transaction as a tuple (x, y, z) which means person x gave person y $z.
Assuming Alice, Bill, and Chris are person 0, 1, and 2 respectively (0, 1, 2 are the person's ID), the transactions can be represented as [[0, 1, 10], [2, 0, 5]].
Given a list of transactions between a group of people, return the minimum number of transactions required to settle the debt.

Note:
    A transaction will be given as a tuple (x, y, z). Note that x ≠ y and z > 0.
    Person's IDs may not be linear, e.g. we could have the persons 0, 1, 2 or we could also have the persons 0, 2, 6.

Example 1:
Input:
[[0,1,10], [2,0,5]]
Output:
2

Explanation:
Person #0 gave person #1 $10.
Person #2 gave person #0 $5.

Two transactions are needed. One way to settle the debt is person #1 pays person #0 and #2 $5 each.

 */
public class OptimalAccountBalancing {
    public int minTransfers(int[][] transactions) {
        int result = 0;
        Map<Integer,Integer> summary = new HashMap<>();
        for(int[] t : transactions){
            summary.put(t[0],summary.getOrDefault(t[0],0) + t[2]);
            summary.put(t[1],summary.getOrDefault(t[1],0) - t[2]);
        }

       // List<Integer> list = summary.values().stream().filter(x -> x != 0).collect(Collectors.toList());
        System.out.println(summary);
       // System.out.println(list);
        result = minTransfers(new ArrayList<>(summary.values()),0);
        return result;
    }

    private int minTransfers(List<Integer> list, int start) {
        while(start < list.size() && list.get(start) == 0){
            start++;
        }
        int r = Integer.MAX_VALUE;
        if (start == list.size())
            return 0;
        for(int i = start + 1; i < list.size();i++){
            if(list.get(i) * list.get(start) < 0){
                list.set(i,list.get(i) + list.get(start));
                r = Math.min(r,1 + minTransfers(list,1 + start));
                list.set(i,list.get(i) - list.get(start));
            }
        }
        return r;
    }

    public static void main(String[] args) {
        OptimalAccountBalancing optimalAccountBalancing = new OptimalAccountBalancing();
        int[][] input = {{0,1,10}, {2,0,5},{1,0,5}};

        System.out.println(optimalAccountBalancing.minTransfers(input));
    }
}
