package rohit.leetcode;

import java.util.ArrayList;
import java.util.List;

public class GeneralizedAbbreviation {
    public List<String> generateAbbreviations(String word){
        List<String> result = new ArrayList<>();
        backtrack(word,result,"",0,0);
        return result;
    }

    private void backtrack(String word, List<String> result, String current, int pos, int count) {
        if(pos == word.length()){
            if(count > 0) current += count;
            result.add(current);
        }else{
            backtrack(word,result,current,pos + 1,count + 1);
            backtrack(word,result,current + (count > 0 ? count : "") + word.charAt(pos),pos + 1,0);
        }
    }
}
