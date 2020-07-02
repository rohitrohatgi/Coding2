package rohit.leetcode;

public class LongestSubstringWithAtLeastKRepeatingCharacters {
    public int longestSubstring(String s, int k) {
        System.out.println(s +" "+ k);
        int result = 0;
        if(s == null || s.isEmpty() || s.length() < k)
            return result;

        int[] alphabets = new int[26];

        for(char c: s.toCharArray()) {
            alphabets[c - 'a']++;
        }
        boolean flag = true;
        for (int i = 0; i < alphabets.length; i += 1) {
            if (alphabets[i] < k && alphabets[i] > 0) flag = false;
        }
        // return the length of string if this string is a valid string
        if (flag == true) return s.length();

        int cur = 0;
        int end = 0;
        while (end < s.length()){
            if(alphabets[s.charAt(end) - 'a'] < k){
                result = Math.max(result,longestSubstring(s.substring(cur,end),k));
                cur = end+1;
            }
            end++;
        }
        result = Math.max(result, longestSubstring(s.substring(cur), k));
        return result;

    }
}
