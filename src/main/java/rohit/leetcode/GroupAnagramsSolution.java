package rohit.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by rohit on 14/6/20.
 */
public class GroupAnagramsSolution {
    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, ArrayList<String>> map = new HashMap<>();

        for(String str : strs){
            char[] ca = str.toCharArray();
            Arrays.sort(ca);

            String key = String.valueOf(ca);
            if(!map.containsKey(key))
                map.put(key,new ArrayList<>());
            map.get(key).add(str);

        }

        return new ArrayList(map.values());

    }
}
