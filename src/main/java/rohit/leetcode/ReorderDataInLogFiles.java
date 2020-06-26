package rohit.leetcode;

import java.util.Arrays;

public class ReorderDataInLogFiles {
    public String[] reorderLogFiles(String[] logs) {

        Arrays.sort(logs,(a,b) ->{
            String[] str1 = a.split(" ",2);
            String[] str2 = b.split(" ",2);
            boolean isDigit1 = Character.isDigit(str1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(str2[1].charAt(0));
            if(!isDigit1 && !isDigit2){
                int result = str1[1].compareTo(str2[1]);
                return result == 0?str1[0].compareTo(str2[0]) : result;
            }


            return isDigit1 && isDigit2 ? 0 : isDigit1 ? -1 : 1;
            });

        return logs;
    }
}
