import java.util.Arrays;

/**
 * @author： chenr
 * @date： Created on 2020/7/9 14:29
 * @version： v1.0
 * @modified By:
 * 零钱兑换
 */
public class CoinChange {
    public static void main(String[] args) {
        int [] coins = { 186,419,83,408};

        int amount = 6249;
      int count =  new CoinChange().coinChange(coins,amount);
        System.out.println(count);
    }
    public int coinChange(int[] coins, int amount) {
        if (amount <= 0) {
            return 0;
        }
        Arrays.sort(coins);
        int n = coins.length-1;
        int count = 0;
       while(n >= 0){
           if (amount < coins[n]) {
                 n--;
           }
           if (n < 0) {
               break;
           }
           count +=  amount / coins[n];
           amount = amount % coins[n];
           if (amount == 0) {
               return count;
           }
        }
        return -1;
    }
}
