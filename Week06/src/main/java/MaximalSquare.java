/**
 * @author： chenr
 * @date： Created on 2020/7/19 17:28
 * @version： v1.0
 * @modified By:
 * 最大正方形
 */
public class MaximalSquare {
    public static void main(String[] args) {
        char [][] matrix = {{'1','0','1', '0', '0'},{'1', '0', '1', '1', '1'},{'1', '1', '1', '1', '1'},{'1', '0', '0', '1', '0'}};
        System.out.println(new MaximalSquare().maximalSquare(matrix));
    }
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length <1 || matrix[0].length<1) {
            return  0;
        }
        int height = matrix.length;
        int width = matrix[0].length;
        int maxSide = 0;
        int [][] dp = new int[height+1][width+1];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (matrix[i][j] == '1') {
                    dp[i+1][j+1] = Math.min(Math.min(dp[i+1][j],dp[i][j+1]),dp[i][j])+1;
                    maxSide = Math.max(maxSide,dp[i+1][j+1]);
                }
            }
        }
        return maxSide*maxSide;
    }
}
