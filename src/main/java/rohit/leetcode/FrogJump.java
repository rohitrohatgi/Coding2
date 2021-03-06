package rohit.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FrogJump {
    public boolean canCross(int[] stones) {
        Map<Integer, HashSet<Integer>> map = new HashMap<>();
        for(int i = 0; i < stones.length ; i++){
            map.put(stones[i],new HashSet<Integer>());
        }
        map.get(0).add(1);
        for(int i = 0 ; i < stones.length ; i++){
            int stone = stones[i];
            for(int step : map.get(stones[i])){
                int reach = step + stone;
                if(reach == stones[stones.length - 1])
                    return true;
                Set set = map.get(reach);
                if(set != null){
                    set.add(step);
                    if(step - 1 > 0) set.add(step - 1);
                    set.add(step + 1);
                }
            }
        }
        System.out.println(map);
        return false;
    }

    public static void main(String[] args) {
        FrogJump frogJump = new FrogJump();

        int[] input = {0,1,3,5,6,8,12,17};

        System.out.println(frogJump.canCross(input));
    }
}
