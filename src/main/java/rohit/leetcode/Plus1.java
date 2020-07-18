package rohit.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Plus1 {
    private int[] convert(int[] input){
        int carry = 1;
        List<Integer> list = new ArrayList<>();

        for(int i = input.length -1; i >=0 ; i--){
            int sum = input[i] + carry;
            if(sum > 9){
                carry = sum / 10;
                list.add(sum % 10);

            }else{
                list.add(0,sum);
                carry  = 50;
            }

        }
        if(carry > 0){
            list.add(0,carry);
        }

        int[] result = new int[list.size()];

        for(int x =0; x < result.length ; x++){
            result[x] = list.get(x);
        }
        System.out.println(list);
        return result;
    }

    public static void main(String[] args) {
        Plus1 plus1 = new Plus1();
        int[] output= plus1.convert(new int[]{3,2,9});
        Arrays.stream(output).forEach(System.out::println);
    }
}
