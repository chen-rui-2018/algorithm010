/**
 * @author： chenr
 * @date： Created on 2020/7/11 9:19
 * @version： v1.0
 * @modified By:
 *  罗马数字转整数
 */
public class RomanToInt {
    public static void main(String[] args) {
     String s = "MCMXCIV";
     int result =   new RomanToInt().romanToInt(s);
        System.out.println(result);

    }
    public int romanToInt(String s) {
        if (s.isEmpty()){
            return 0;
        }
        int result = 0;
        int preNum = getValue(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int num = getValue(s.charAt(i));
            if (num > preNum) {
                result -=  preNum;
            }else {
                result += preNum;
            }
            preNum = num;
        }
        result += preNum;
        return result;
    }

    private int getValue(char charAt) {
        switch (charAt){
            case 'I' : return 1;
            case 'V' : return 5;
            case 'X' : return 10;
            case 'L' : return 50;
            case 'C' : return 100;
            case 'D' : return 500;
            case 'M' : return 1000;
            default:return 0;
        }
    }


}
