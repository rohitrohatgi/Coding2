package rohit.leetcode;

import java.util.*;

/*
There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you.
You receive a list of non-empty words from the dictionary, where words are sorted lexicographically by the rules of this new language.
Derive the order of letters in this language.

Input:
[
  "wrt",
  "wrf",
  "er",
  "ett",
  "rftt"
]
 */
public class AlienDictionary {
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> map = new HashMap<>();
        Map<Character,Integer> degree = new HashMap<>();
        StringBuffer result = new StringBuffer();
        if(words==null || words.length==0)
            return result.toString();
        for(String word : words){
            for(Character c : word.toCharArray()){
                degree.put(c,0);
            }
        }
        for(int i = 0 ; i < words.length -1 ;i++){
            String current = words[i];
            String next = words[i + 1];
            for(int j = 0 ; j < Math.min(current.length(),next.length()); j++){
                char c1 = current.charAt(j);
                char c2 = next.charAt(j);
                if(c1 != c2){
                    Set<Character> set = new HashSet<>();
                    if(map.containsKey(c1))
                        set =  map.get(c1);

                    if(!set.contains(c2)) {
                        map.computeIfAbsent(c1, f -> new HashSet<>()).add(c2);
                        degree.put(c2, degree.get(c2) + 1);
                    }
                    break;
                }
            }
        }
        Queue<Character> queue = new LinkedList<>();

        for(char c : degree.keySet()){
            if(degree.get(c) == 0 )
                queue.add(c);

        }
        while (!queue.isEmpty()){
            char c = queue.poll();
            result.append(c);
            if(map.containsKey(c)){
                for(char c1 : map.get(c)){
                    degree.put(c1,degree.get(c1) - 1);
                    if(degree.get(c1) == 0)
                        queue.add(c1);
                }
            }
        }
        return result.toString();

    }


}
