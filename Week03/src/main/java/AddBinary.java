/**
 * @author： chenr
 * @date： Created on 2020/6/23 9:46
 * @version： v1.0
 * @modified By:
 * 二进制求和
 */
public class AddBinary {
    public static void main(String[] args) {
        String a = "1010";
        String b = "1011";
//        String a = "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101";
//        String b = "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011";


        System.out.println(new AddBinary().addBinary1(a,b));
    }

    /**
     * 字符串过长则不适用
     * 字符串转10进制 再转二进制
     * @param a
     * @param b
     * @return
     */
    public String addBinary(String a, String b) {
        return Integer.toBinaryString(
                Integer.parseInt(a, 2) + Integer.parseInt(b, 2)
        );
    }

    /**
     * 模拟, 模拟十进制数列式相加
     * @param a
     * @param b
     * @return
     */
    public String addBinary1(String a, String b) {
        StringBuilder stringBuilder = new StringBuilder();
        int n = Math.max(a.length(),b.length());
        int carry = 0;
        for (int i = 0; i < n; i++) {
            carry += i < a.length() ? (a.charAt(a.length()-i-1)-'0') : 0;
            carry += i < b.length() ? (b.charAt(b.length()-i-1)-'0') : 0;
            stringBuilder.append((char) (carry%2+'0'));
            // 是否进位
            carry /= 2;
        }
        if (carry > 0) {
            stringBuilder.append('1');
        }
        stringBuilder.reverse();
        return stringBuilder.toString();
    }
}
