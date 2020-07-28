package rohit.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> input = new ArrayList<>();
        for(int num :  nums){
            input.add(num);
        }
        int end = input.size();
        backtrack(input,result,end,0);
        return result;
    }

    private void backtrack(List<Integer> input, List<List<Integer>> result, int end, int start) {
        if(start == end){
            result.add(new ArrayList<>(input));
        }else{
            for(int i = start; i < end ; i++){
                Collections.swap(input,start,i);
                backtrack(input,result,end,start+1);
                Collections.swap(input,start,i);
            }
        }
    }

    public static void main(String[] args) {
        Permutations permutations = new Permutations();
        List<List<Integer>> result = permutations.permute(new int[]{1,2,3});
        System.out.println(result);
    }
}
