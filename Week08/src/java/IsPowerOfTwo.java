/**
 * @author： chenr
 * @date： Created on 2020/7/29 15:54
 * @version： v1.0
 * @modified By:
 */
public class IsPowerOfTwo {
    public static void main(String[] args) {
        int n =128;
        System.out.println( new IsPowerOfTwo().isPowerOfTwo(n));
    }
    public boolean isPowerOfTwo(int n) {
        int count = 0;
        if (n == 0) {
            return false;
        }
        return count == (n & (n-1));
    }
}
