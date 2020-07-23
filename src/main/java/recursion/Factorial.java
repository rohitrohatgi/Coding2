package recursion;

public class Factorial {
    public static int getFactorial(int number){
        if(number < 2)
            return 1;
        return number * getFactorial(number - 1);
    }

    public static void main(String[] args) {
        System.out.println(getFactorial(4));
    }
}
