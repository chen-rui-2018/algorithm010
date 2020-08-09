/**
 * @author： chenr
 * @date： Created on 2020/8/3 18:16
 * @version： v1.0
 * @modified By:
 * 字符串相加
 */
public class AddStrings  {
    public static void main(String[] args) {
        String num1 = "999";
        String num2 = "999";
        System.out.println(new AddStrings().addStrings(num1,num2));
    }
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int num1Length = num1.length()-1;
        int num2Length = num2.length()-1;
        int add = 0;
        while (num1Length >= 0 || num2Length >= 0 || add != 0) {
            int x =  num1Length >= 0 ? num1.charAt(num1Length--)-'0' : 0;
            int y =  num2Length >= 0 ? num2.charAt(num2Length--)-'0' : 0;
            int result = x + y + add;
            sb.append(result%10);
            add = result /10;
        }
        sb.reverse();
        return sb.toString();
    }
}
