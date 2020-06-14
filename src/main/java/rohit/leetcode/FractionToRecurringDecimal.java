package rohit.leetcode;

import java.util.HashMap;

/**
 * Created by rohit on 14/6/20.
 */
public class FractionToRecurringDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0) return "0";


        StringBuffer sb = new StringBuffer();
        //if only one of them is negative - XOR
        if(numerator < 0 ^ denominator < 0)
            sb.append("-");

        //making number long and also abs as sign is already taken care
        long longNumerator = Math.abs((long) numerator);
        long longDenominator = Math.abs(((long) denominator));

        sb.append(longNumerator/longDenominator);


        if(longNumerator % longDenominator == 0){ //seems there is no decimal fraction so return
             return sb.toString();
        }
        sb.append(".");

        HashMap<Long,Integer> map = new HashMap<>();
        long remainder;
        remainder = longNumerator % longDenominator;
        map.put(remainder,sb.toString().length());

        while(remainder != 0){
            remainder *= 10;
            sb.append(remainder/longDenominator);
            remainder%=longDenominator;
            if(map.containsKey(remainder)){
                //we have detected the repetition and hence we need to add a bracket at the position of first occurrence
                sb.insert(map.get(remainder),"(");
                sb.append(")");
                return sb.toString();
            }
            map.put(remainder,sb.toString().length());

        }

        return sb.toString();
    }

    public static void main(String[] args) {
        FractionToRecurringDecimal fractionToRecurringDecimal = new FractionToRecurringDecimal();
        System.out.println(fractionToRecurringDecimal.fractionToDecimal(13,6));
        System.out.println(fractionToRecurringDecimal.fractionToDecimal(-50,8));
    }
}
