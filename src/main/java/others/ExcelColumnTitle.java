package others;

public class ExcelColumnTitle {
    // name for a given column number
    private static String printString(int columnNumber) {
        StringBuffer sb = new StringBuffer();
        while (columnNumber > 0){
            int rem = columnNumber%26;
            if(rem == 0){
                sb.insert(0,'Z');
                columnNumber = columnNumber /26 -1;
            }else {
                sb.insert(0,(char)('A' +rem - 1));
                columnNumber = columnNumber /26 ;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(printString(26));
        System.out.println(printString(27));
        System.out.println(printString(52));
        System.out.println(printString(676));
        System.out.println(printString(705));
    }
}
