/**
 * @author： chenr
 * @date： Created on 2020/7/30 15:52
 * @version： v1.0
 * @modified By:
 * 颠倒二进制位
 */
public class ReverseBits  {
    public static void main(String[] args) {
        System.out.println( new ReverseBits().reverseBits(43261596));
    }

    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1;
            result +=  n&1;
            n >>= 1;
        }
        return result;
    }

}
