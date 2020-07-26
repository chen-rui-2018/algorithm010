/**
 * @author： chenr
 * @date： Created on 2020/7/8 19:51
 * @version： v1.0
 * @modified By:
 * 跳水板
 */
public class DivingBoard {
    public static void main(String[] args) {
        int [] result =  new DivingBoard().divingBoard(1,1,0);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]+",");
        }

    }
    public int[] divingBoard(int shorter, int longer, int k) {
        if (k <= 0) {
            return new int[0];
        }
        if (shorter == longer) {
            int [] result = new int[1];
            result[1] = shorter*k;
            return result;
        }
       int [] result = new int[k+1];
        for (int i = 0; i < result.length; i++) {
            int length = i*longer + (k-i)*shorter;
            result[i] = length;
        }

        return  result;
    }
}
