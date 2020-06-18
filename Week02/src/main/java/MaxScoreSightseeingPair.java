/**
 * @author： chenr
 * @date： Created on 2020/6/17 22:18
 * @version： v1.0
 * @modified By:
 *  最佳观光组合
 */
public class MaxScoreSightseeingPair {
    public static void main(String[] args) {
        int [] array = {8,1,5,2,6};
        int total = new MaxScoreSightseeingPair().maxScoreSightseeingPair(array);
        int total2 = new MaxScoreSightseeingPair().maxScoreSightseeingPair2(array);
        int total3 = new MaxScoreSightseeingPair().maxScoreSightseeingPair3(array);
        System.out.println(total);
        System.out.println(total2);
        System.out.println(total3);

    }
    // 暴力破解 O(n^2) 超时
    public int maxScoreSightseeingPair(int[] A) {
        int score =0;
        for (int i=0; i<A.length-1; i++) {
            for (int j=i+1; j<A.length; j++){
                score = Math.max(score,A[i]+A[j]+i-j);

            }
        }
        return score;
    }
    // 枚举   a[j] -j 值固定, 需找出 a[i]+i 最大值 与 a[i]-i 遍历取 和最大值;
    public int maxScoreSightseeingPair2(int[] A) {
        int score =0;
        int max= A[0] + 0;
        for (int i=1; i<A.length; i++) {
            score = Math.max(score,max+A[i]-i);
            max = Math.max(max,A[i]+i);
        }
        return score;
    }
    // 打boss 保留最大buff 求最大buff 的值
    public int maxScoreSightseeingPair3(int[] A) {
        int score =0;
        int max= A[0];
        for (int i=1; i<A.length; i++) {
            max--;
            score = Math.max(score,max+A[i]);
            max = Math.max(max,A[i]);

        }
        return score;
    }
}
