package rohit.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by rohit on 12/6/20.
 */
public class FindLongestWordSolution {
    public String findLongestWord(String s, List< String > d) {

        String result = "";
        //sort the list with length descending order and in natural order if length is same
        Collections.sort(d,(a,b) -> a.length() == b.length()? a.compareTo(b) : Integer.compare(b.length(),a.length()));

        System.out.println(d);

        for(String item : d){
            if(match(s,item)){
                return item;
            }
        }
        return result;
    }

    private boolean match(String s, String item) {
        int j = 0;
        for(int i = 0; i < s.length();i++){
            if(item.charAt(j) == s.charAt(i)) {
                j++;
                if(j == item.length()){
                    break;
                }
            }
        }
        return (j == item.length());
    }

    public static void main(String[] args) {
        FindLongestWordSolution findLongestWordSolution = new FindLongestWordSolution();

        System.out.println(findLongestWordSolution.findLongestWord("abpcplea", Arrays.asList("ale","apple","monkey","plea","aaaa")));
    }
}
