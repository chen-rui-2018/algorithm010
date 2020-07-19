import java.util.Arrays;

/**
 * @author： chenr
 * @date： Created on 2020/7/14 15:04
 * @version： v1.0
 * @modified By:
 * 不同路径 II
 */
public class UniquePathsWithObstacles {
    public static void main(String[] args) {
        int [] [] arr = new int[3][3];
        Arrays.fill(arr[0],0);
        Arrays.fill(arr[1],0);
        Arrays.fill(arr[2],0);
        arr[1][1] = 1;
        int result = new UniquePathsWithObstacles().uniquePathsWithObstacles(arr);
        System.out.println(result);
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int w = obstacleGrid.length;
        int h = obstacleGrid[0].length;
        int[] dp = new int[h+1];
        dp[1] = 1;

        for (int i = 1; i <= w; i++) {
            for (int j = 1; j <= h; j++) {
                dp[j] = obstacleGrid[i - 1][j - 1] == 1 ? 0 : dp[j] + dp[j - 1];
            }
        }
        return dp[h];
    }
}
