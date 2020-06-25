package rohit.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        HashMap<Character, Integer> lastPosition = new HashMap();

        for(int i =0;i < s.length();i++){
            lastPosition.put(s.charAt(i),i);
        }

        Stack<Character> stack = new Stack<>();

        HashSet<Character> seen = new HashSet<>();

        for(int i =0;i < s.length();i++){
            char c  = s.charAt(i);
            if(!seen.contains(c)){
                while(!stack.isEmpty() && c < stack.peek() &&  lastPosition.get(stack.peek()) > i ) {
                    seen.remove(stack.pop());

                }

                seen.add(c);
                stack.push(c);


            }

        }
        StringBuilder sb = new StringBuilder();
        for (Character c : stack)
            sb.append(c.charValue());
        return sb.toString();

    }
}
