package rohit.leetcode;

import javax.swing.plaf.nimbus.AbstractRegionPainter;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if(s == null)
            return "";
        if(s.length() < 2)
            return s;

        int low = 0,max = 0;

        for(int i = 0; i < s.length() - 1;i++){
            int x = expand(s,i,i);
            int y = expand(s,i,i + 1);
            if (max < Math.max(x, y)) {
                low = (x > y) ? (i - x / 2) : (i - y / 2 + 1);
                max = Math.max(x, y);
            }
        }

        return s.substring(low,low+max);
    }

    private int expand(String s, int i, int j) {
        for( ; j <= s.length() && i >= 0 ;i--,j++) {
            if (s.charAt(i) != s.charAt(j)) {
                break;
            }
        }
        return j - i - 1;
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();
        System.out.println(longestPalindromicSubstring.longestPalindrome("cbbd"));
    }
}
