package rohit.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);
Example 1:

Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
Example 2:

Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:

P     I    N
A   L S  I G
Y A   H R
P     I
 */
public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        List<StringBuffer> list = new ArrayList<>();

        for(int i = 0; i < numRows ; i++){
            list.add(new StringBuffer());
        }

        int currentRow = 0;
        boolean downward = false;

        for(char c: s.toCharArray()){
            list.get(currentRow).append(c);
            if(currentRow == 0 || currentRow == numRows -1) downward = !downward;
            currentRow += (downward) ? 1 : -1;
            // System.out.println(currentRow);
        }
        // System.out.println(list);
        StringBuffer result = new StringBuffer();
        for(StringBuffer sb : list){
            result.append(sb.toString());
        }
        return result.toString();
    }
}
