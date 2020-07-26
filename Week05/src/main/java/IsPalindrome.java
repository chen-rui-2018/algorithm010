/**
 * @author： chenr
 * @date： Created on 2020/7/10 10:45
 * @version： v1.0
 * @modified By:
 * 回文数
 */
public class IsPalindrome {
    public static void main(String[] args) {
        int x = 123321;
        boolean result = new IsPalindrome().isPalindrome(x);
        System.out.println(result);
    }
    public boolean isPalindrome(int x) {
        if (x < 0 || (x%10 == 0 && x >0)) {
            return false;
        }
        int temp = 0;
        while ( x > temp) {
            temp = temp * 10 + x%10;
            x /= 10;
        }

        return x == temp || x == temp/10;
    }
}
