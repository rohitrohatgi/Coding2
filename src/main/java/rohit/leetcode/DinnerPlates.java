package rohit.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class DinnerPlates {
    Map<Integer, Stack<Integer>> map;
    int cap = 0;
    int left = 0;
    int right = 0;
    public DinnerPlates(int capacity) {
        map = new HashMap<>();
        this.cap = capacity;
    }

    public void push(int val) {
        while(map.containsKey(left) && map.get(left).size() == cap) left++;
        map.computeIfAbsent(left,f -> new Stack<>()).add(val);
        right = Math.max(left,right);
        //System.out.println(map);
    }

    public int pop() {
        while(map.containsKey(right) && map.get(right).size() == 0) right--;


        left = Math.min(left,right);

        if(!map.containsKey(right) || map.get(right).size() == 0) {
            return -1;

        }
        return map.get(right).pop();
    }

    public int popAtStack(int index) {
        if(!map.containsKey(index) || map.get(index).size() == 0) {
            return -1;

        }
        left = Math.min(left, index);
        return map.get(index).pop();
    }
}

/**
 * Your DinnerPlates object will be instantiated and called as such:
 * DinnerPlates obj = new DinnerPlates(capacity);
 * obj.push(val);
 * int param_2 = obj.pop();
 * int param_3 = obj.popAtStack(index);
 */
