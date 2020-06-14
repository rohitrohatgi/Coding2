package rohit.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rohit on 13-06-2020.
 * This code is only used for learning purpose.
 */
public class FractionAdditionSubtraction {
    public String fractionAddition(String expression) {

        List<Character> sign = new ArrayList<>();
        //add or default first sign
        if(expression.charAt(0) != '-')
            sign.add('+');
        for(int i = 0;i<expression.length();i++){
            if(expression.charAt(i) == '+' || expression.charAt(i) == '-')
                sign.add(expression.charAt(i));
        }

        int prev_num = 0, prev_den = 1,i = 0;
        System.out.println(sign);
        for(String frac : expression.split("(\\+)|(-)")){
            if(frac.length() > 0){
                int num = Integer.valueOf(frac.split("/")[0]);
                int den = Integer.valueOf(frac.split("/")[1]);
                System.out.println(num +"   "+den);
                int g = Math.abs(gcd(den, prev_den));
                if(sign.get(i++) == '+'){
                    prev_num = prev_num * den / g + num * prev_den / g;
                }else{
                    prev_num = prev_num * den / g - num * prev_den / g;
                }
                prev_den = den * prev_den / g;
                g = Math.abs(gcd(prev_den, prev_num));
                prev_num /= g;
                prev_den /= g;
            }
        }
        return prev_num+"/"+prev_den;
    }


    private int gcd(int den, int prev_den) {

        while (prev_den != 0){
            int temp = prev_den;
            prev_den = den % prev_den;
            den = temp;
        }
        return den;
    }

    public static void main(String[] args) {
        FractionAdditionSubtraction fractionAdditionSubtraction = new FractionAdditionSubtraction();

        System.out.println(fractionAdditionSubtraction.fractionAddition("-1/2+-1/2+1/3"));
    }
}
