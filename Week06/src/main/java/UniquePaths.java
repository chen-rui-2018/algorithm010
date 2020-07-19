import java.util.Arrays;

/**
 * @author： chenr
 * @date： Created on 2020/7/14 9:32
 * @version： v1.0
 * @modified By:
 * 不同路径
 */
public class UniquePaths {
    public static void main(String[] args) {
        int m = 3, n = 2;
        int result =  new UniquePaths().uniquePaths(m,n);
        int result1 =  new UniquePaths().uniquePaths2(m,n);
        int result2 =  new UniquePaths().uniquePaths3(m,n);
        System.out.println(result+","+result1+","+result2);
    }
    public int uniquePaths(int m, int n) {

        int [] [] grid = new int [m][n];
        for (int i = 0; i < m ; i++) {
            grid[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            grid[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] = grid [i][j-1] + grid[i-1][j];            }
        }
        return grid[m-1][n-1];
    }
    public int uniquePaths2(int m, int n) {

        int [] preLine = new int [n];
        int [] curLine = new int [n];
        Arrays.fill(preLine,1);
        Arrays.fill(curLine,1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
               curLine[j] = preLine[j] + curLine[j-1];
            }
            preLine = curLine.clone();
        }
        return curLine[n-1];
    }
    public int uniquePaths3(int m, int n) {
        int [] curLine = new int [n];
        Arrays.fill(curLine,1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
               curLine[j] += curLine[j-1];
            }
        }
        return curLine[n-1];
    }
}
