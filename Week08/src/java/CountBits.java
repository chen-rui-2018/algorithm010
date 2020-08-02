/**
 * @author： chenr
 * @date： Created on 2020/7/30 16:00
 * @version： v1.0
 * @modified By:
 * 比特位计数
 */
public class CountBits {
    public static void main(String[] args) {
      int [] result =    new CountBits().countBits(5);
      System.out.println( );
    }
    public int[] countBits(int num) {

        int [] result = new int [num+1];
        for (int i = 0; i < result.length; i++) {
            int count = 0;
            int n = i;
            while (n != 0 ) {
                count++;
                n = n&(n-1);
            }
            result[i] = count;
        }

        return result;
    }
}
