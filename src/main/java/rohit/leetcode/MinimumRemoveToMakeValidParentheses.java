package rohit.leetcode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class MinimumRemoveToMakeValidParentheses {

    public String minRemoveToMakeValid(String s) {
        Set<Integer> skipList = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        for(int i = 0 ; i < s.length() ; i++){
            char c = s.charAt(i);
            if(c == '('){
                stack.push(i);
            }else if (c == ')'){
                if(!stack.isEmpty()){
                    stack.pop();
                }else{
                    skipList.add(i);
                }
            }
        }
        while(!stack.isEmpty()){
            skipList.add(stack.pop());
        }
        StringBuffer sb = new StringBuffer();
        for(int i = 0 ; i < s.length() ; i++){
            if(!skipList.contains(i)){
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }
}
