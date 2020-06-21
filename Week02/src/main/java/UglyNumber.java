/**
 * @author： chenr
 * @date： Created on 2020/6/20 23:05
 * @version： v1.0
 * @modified By:
 * 丑数
 */
public class UglyNumber {
    public static void main(String[] args) {
     int num = 1690;
      System.out.println(new UglyNumber().nthUglyNumber(num));
    }

    public int nthUglyNumber(int n) {
        int [] array = new int[n];
        int a = 0;
        int b = 0;
        int c = 0;
        array[0] = 1;
        for (int i=1; i < n; i++) {
           int va = array[a]*2;
           int vb = array[b]*3;
           int vc = array[c]*5;
            array[i] = Math.min(Math.min(va,vb),vc);
            if (va == array[i]) {
                a++;
            }
            if (vb == array[i]) {
                b++;
            }
            if (vc == array[i]) {
                c++;
            }
        }

       return array[n-1];
    }
}
