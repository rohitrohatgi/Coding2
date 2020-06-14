package rohit.leetcode;

/**
 * Created by Rohit on 14-06-2020.
 * This code is only used for learning purpose.
 */
public class GCD {
    public static void main(String[] args) {
        System.out.println(gcd(10,25));
    }
    private static int gcd(int a, int b){
        return a == 0 ? Math.abs(b) : gcd(b%a,a);
    }
}

