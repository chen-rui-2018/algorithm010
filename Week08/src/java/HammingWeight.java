import com.sun.org.apache.xerces.internal.dom.PSVIAttrNSImpl;

import java.math.BigInteger;

/**
 * @author： chenr
 * @date： Created on 2020/7/29 15:16
 * @version： v1.0
 * @modified By:
 * 位1的个数
 */
public class HammingWeight  {
    public static void main(String[] args) {
        int  x = 1111111101;
        System.out.println(new HammingWeight().hammingWeight(x));
    }
    public int hammingWeight(long  n) {
        int count = 0;
        while (n != 0){
            count++;
            n &= (n-1);

        }
     return count;
    }

}
