package rohit.leetcode;

import java.util.Arrays;
// 12564
// 6254321

// 6354221
public class NextGreaterElement {
    public int nextGreaterElement(int n) {

        char[] c =  (n + "").toCharArray();
        int length = c.length;
        int i = length -2;
        while(i >= 0 && c[i] >= c[i+1]){
            i--;
        }

        if(i < 0)
            return  -1;

        int j= length-1;
        while(j >= 0 && c[j] <=  c[i]){
            j--;
        }
        System.out.print(i + "  "+j);
        char temp = c[j];
        c[j] = c[i];
        c[i] = temp;

       // Arrays.sort(c,i+1,length);

        for(int l = i+1, k = length-1; l<k ;l++,k--){
            char ctemp = c[l];
            c[l] = c[k];
            c[k] = ctemp;
        }

        long val = Long.parseLong(new String(c));
        return (val <= Integer.MAX_VALUE) ? (int) val : -1;
    }


    public static void main(String[] args) {
        NextGreaterElement nextGreaterElement = new NextGreaterElement();
        System.out.println(nextGreaterElement.nextGreaterElement(1235421));
        System.out.println(nextGreaterElement.nextGreaterElement(11));

    }


}
