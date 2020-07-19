/**
 * @author： chenr
 * @date： Created on 2020/7/19 21:04
 * @version： v1.0
 * @modified By:
 * 矩形区域不超过 K 的最大数值和
 */
public class MaxSumSubmatrix {
    public static void main(String[] args) {
        int [][] matrix = {{1,0,1},{0,-2,3}};
        int k = 2;
       int result =   new MaxSumSubmatrix().maxSumSubmatrix(matrix,k);
        System.out.println(result);

    }
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int rows = matrix.length, cols = matrix[0].length, max = Integer.MIN_VALUE;
        for (int i1 = 1; i1 <= rows; i1++) {
            for (int j1 = 1; j1 <= cols; j1++) {
                // renew  // from (i1,j1) to (i2,j2)
                int[][] dp = new int[rows + 1][cols + 1];
                dp[i1][j1] = matrix[i1 - 1][j1 - 1];
                for (int i2 = i1; i2 <= rows; i2++) {
                    for (int j2 = j1; j2 <= cols; j2++) {
                        dp[i2][j2] = dp[i2 - 1][j2] + dp[i2][j2 - 1] - dp[i2 - 1][j2 - 1] + matrix[i2 - 1][j2 - 1];
                        if (dp[i2][j2] <= k && dp[i2][j2] > max) max = dp[i2][j2];
                    }
                }
            }
        }
        return max;

    }
}
