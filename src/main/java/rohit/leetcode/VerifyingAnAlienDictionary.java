package rohit.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
In an alien language, surprisingly they also use english lowercase letters, but possibly in a different order. The order of the alphabet is some permutation of lowercase letters.

Given a sequence of words written in the alien language, and the order of the alphabet, return true if and only if the given words are sorted lexicographicaly in this alien language.

Example 1:

Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
Output: true
Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
Example 2:

Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
Output: false
Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], hence the sequence is unsorted.
 */
public class VerifyingAnAlienDictionary {
    Map<Character,Integer> orderMap = null;
    public boolean isAlienSorted(String[] words, String order) {
        orderMap = new HashMap<>();
        int counter = 1;
        for(char c :  order.toCharArray()){
            orderMap.put(c,counter++);
        }
        for(int i = 1; i < words.length ; i++){
            if(!isBigger(words[i],words[i-1])){
                return false;
            }
        }
        return true;
    }

    private boolean isBigger(String str1,String str2){
        int i = 0;
        while(i < str1.length() && i < str2.length()){
            int s1 = orderMap.get(str1.charAt(i));
            int s2 = orderMap.get(str2.charAt(i));
            if(s1 > s2){
                return true;
            }else if(s1 < s2){
                return false;
            }
            i++;
        }
        if(i < str2.length())
            return false;

        return true;
    }


}
