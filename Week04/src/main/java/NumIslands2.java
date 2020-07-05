import java.util.LinkedList;
import java.util.Queue;

/**
 * @author： chenr
 * @date： Created on 2020/7/4 17:04
 * @version： v1.0
 * @modified By:
 * 岛屿数量
 */
public class NumIslands2 {
    public static void main(String[] args) {

    }
    /** 深度优先搜索 */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int row = grid.length;
        int column = grid[0].length;
        int numIslands = 0;
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < column; c++) {
                if (grid[r][c] == '1') {
                    numIslands++;
                    dfs(grid,r,c);
                }
            }
        }
        return numIslands;
    }

    private void dfs(char[][] grid, int r, int c) {
        int row = grid.length;
        int column = grid[0].length;
        if (r < 0 || c < 0 || r >= row ||  c >= column || grid[c][r] == '0') {
            return;
        }
        grid[r][c] = '0';
        dfs(grid,r-1,c);
        dfs(grid,r+1,c);
        dfs(grid,r,c-1);
        dfs(grid,r,c+1);

    }
    public int numIslands1(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int row = grid.length;
        int column = grid[0].length;
        int numIslands = 0;
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < column; c++) {
                if (grid[r][c] == '1') {
                    numIslands++;
                    grid[r][c] = '0';
                    Queue<Integer> neighbors = new LinkedList<>();
                     neighbors.add(r*column+c);
                    while (!neighbors.isEmpty()) {
                        int id = neighbors.remove();
                        int row1 =  id / column;
                        int col = id % column;
                        if ( row1 - 1 >= 0 && grid[row1-1][col] == '1') {
                            neighbors.add((row1-1)*column + col);
                            grid[row1-1][col] = '0';
                        }
                        if ( row1 + 1 < row  && grid[row1+1][col] == '1') {
                             neighbors.add((row1+1)*column + col);
                            grid[row1+1][col] = '0';
                        }
                        if ( col - 1 >= 0 && grid[row1][col-1] == '1') {
                             neighbors.add((col-1) + column * row1);
                            grid[row1][col-1] = '0';
                        }
                        if ( col + 1 < column && grid[row1][col+1] == '1') {
                             neighbors.add((col+1) + column * row1);
                            grid[row1][col+1] = '0';
                        }

                    }
                }
            }
        }

        return numIslands;
    }
}
