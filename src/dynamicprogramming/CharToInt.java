package dynamicprogramming;

public class CharToInt {
    public static void main(String[] args) {
        char a = '8';
        int d = a - '0';
        System.out.println("隐式类型转换："+d);
        System.out.println("Character："+Character.getNumericValue(a));
        System.out.println("Integer:"+Integer.parseInt( String.valueOf(a) ));
    }
}
