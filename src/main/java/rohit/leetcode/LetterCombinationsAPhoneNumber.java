package rohit.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinationsAPhoneNumber {
    HashMap<String, String> map = new HashMap<>();


    private List<String> output = new ArrayList<>();

    public List<String> letterCombinations(String digits) {

        map.put("2","abc");
        map.put("3","def");
        map.put("4","ghi");
        map.put("5","jkl");
        map.put("6","mno");
        map.put("7","pqrs");
        map.put("8","tuv");
        map.put("9","wxyz");
        if (digits.length() != 0)
            backtrack("",digits);


        return output;
    }

    private void backtrack(String combination, String digits){

        if(digits.equals("")){
            output.add(combination);
        }else{
            String digit = digits.substring(0,1);
            String value = map.get(digit) ;
            for(int i = 0; i < value.length(); i++){
                char letter = value.charAt(i);
                backtrack(combination+letter,digits.substring(1));
            }
        }


    }
}
