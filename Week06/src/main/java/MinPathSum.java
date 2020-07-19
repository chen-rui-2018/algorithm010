/**
 * @author： chenr
 * @date： Created on 2020/7/16 15:32
 * @version： v1.0
 * @modified By:
 * 最小路径和
 */
public class MinPathSum  {
    public static void main(String[] args) {
        int [][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        int minValue = new MinPathSum().minPathSum(grid);
        System.out.println(minValue);
    }
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0;  j < col; j++) {
                if(i==0 && j!=0) {
                    grid[i][j] = grid[i][j] + grid[i][j - 1];
                }
                else if(j==0 && i != 0) {
                    grid[i][j] = grid[i][j] + grid[i - 1][j];
                }
                else if(j !=0 && i !=0) {
                    grid[i][j] = grid[i][j] + Math.min(grid[i - 1][j], grid[i][j - 1]);
                }
            }
        }
        return grid[row-1][col-1];
    }
}
