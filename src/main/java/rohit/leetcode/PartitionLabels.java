package rohit.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rohit on 22/6/20.
 * A string S of lowercase English letters is given.
 * We want to partition this string into as many parts as possible so that each letter appears in at most one part,
 * and return a list of integers representing the size of these parts.
 */
public class PartitionLabels {

    public List<Integer> partitionLabels(String S) {

        int[] alphabet =  new int[26];
        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < S.length(); i++){
            alphabet[S.charAt(i) - 'a'] = i;
        }

        int max = 0;
        int x = 0;

        for(int i = 0; i < S.length(); i++){
            max = Math.max(max, alphabet[S.charAt(i)- 'a']);
            if(i == max){
                result.add( i - x + 1);
                x = i + 1;
            }
        }

        return result;
    }
}


