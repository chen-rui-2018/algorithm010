import java.util.Arrays;

/**
 * @author： chenr
 * @date： Created on 2020/7/19 18:05
 * @version： v1.0
 * @modified By:
 */
public class LeastInterval {
    public static void main(String[] args) {
        char [] chars = {'A','A','A','B','B','B'};
        int n = 2;
        System.out.println(new LeastInterval().leastInterval(chars,n));
    }
    public int leastInterval(char[] tasks, int n) {
        if (tasks == null || tasks.length < 1 || n < 1) {
            return 0;
        }
        int [] arr = new int [26];
        for (int i = 0; i < tasks.length; i++) {
            arr[tasks[i]-'A']++;
        }
        Arrays.sort(arr);
        int maxCount = arr[25];
        int retCount = (maxCount-1) * (n+1) + 1;
        int i = arr.length-2;
        while (i > 0 && arr[i] == maxCount){
            retCount++;
            i--;
        }
      return Math.max(retCount,tasks.length);
    }
}
