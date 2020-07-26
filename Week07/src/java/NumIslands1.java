/**
 * 岛屿数量
 */
public class NumIslands1 {
    public static void main(String[] args) {
        char [][] grid = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        System.out.println(new NumIslands1().numIslands(grid));
        ;
    }
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int numRow = grid.length;
        int numColumn = grid[0].length;
        int numIsLands = 0;
        for (int r = 0; r < numRow; r++  ) {
            for (int c = 0 ; c < numColumn; c ++) {
                if (grid[r][c] == '1') {
                    numIsLands++;
                    dfs(grid,r,c);
                }
            }
        }
        return numIsLands;
    }

    private void dfs(char[][] grid, int r, int c) {
        int numRow = grid.length;
        int numColumn = grid[0].length;
        if (r < 0 || c < 0 || r >= numRow || c >= numColumn || grid[r][c] == '0' ) {
            return;
        }
        grid[r][c] = '0';
        dfs(grid,r-1,c);
        dfs(grid,r+1,c);
        dfs(grid,r,c-1);
        dfs(grid,r,c+1);
    }

}
