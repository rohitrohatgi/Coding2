package others;

public class TestEnum {
    private String  msg(MyEnum myEnum){
        switch (myEnum) {
            case HIGH:
                return "High";
            case LOW:
                return "Low";
            case MEDIUM:
                return "Med";
        }
        return null;
    }

    public static void main(String[] args) {
        TestEnum testEnum = new TestEnum();
        System.out.println(testEnum.msg(MyEnum.HIGH));
        System.out.println(testEnum.msg(MyEnum.LOW));
        System.out.println(testEnum.msg(MyEnum.MEDIUM));

    }
}
