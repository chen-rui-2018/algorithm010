/**
 * @author： chenr
 * @date： Created on 2020/7/24 10:06
 * @version： v1.0
 * @modified By:
 * 除数博弈
 */
public class DivisorGame {
    public static void main(String[] args) {

       boolean result =  new DivisorGame().divisorGame(4);
        System.out.println(result);
    }
    public boolean divisorGame(int N) {
       boolean [] f = new boolean[N+1];
       f[1] = false;
       f[2] = true;
        for (int i = 3; i <= N; i++) {
            for (int j = 1; j < i; j++) {
                if (i % j == 0 && !f[i-j] ) {
                    f[i] = true;
                    break;
                }
            }
        }
        return f[N];
     }
}
