package rohit.leetcode;

/**
 * Created by rohit on 14/6/20.
 * Symbol       Value
 I             1
 V             5
 X             10
 L             50
 C             100
 D             500
 M             1000
 */
public class IntToRomanSolution {
    public String intToRoman(int num) {
        int [] nums = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String  [] str = {"M","CM","D","CD",
                "C","XC","L","XL","X",
                "IX","V","IV","I"};
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < nums.length ; i++){
            while(num >= nums[i]){
                sb.append(str[i]);
                num-=nums[i];
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        IntToRomanSolution intToRomanSolution = new IntToRomanSolution();
        System.out.println(intToRomanSolution.intToRoman(3999));
    }

}
