package leetcode.huisu;

public class IslandNumber {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * 判断岛屿数量
     *
     * @param grid char字符型二维数组
     * @return int整型
     */
    public int solve(char[][] grid) {
        // write code here
        if (grid.length == 0) {
            return 0;
        }
        int cnt = 0;
        int row = grid.length;
        int colunm = grid[0].length;
        int visited[][] = new int[grid.length][grid[0].length];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < colunm; j++) {
                if (grid[i][j] == '1' && visited[i][j] == 0) {
                    cnt += 1;
                    dfs(grid, visited, i, j);
                }
            }
        }
        return cnt;


    }


    public void dfs(char[][] grid, int[][] visited, int i, int j) {
        visited[i][j] = 1;
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != '1') {
            return;
        }
        if (i - 1 >= 0 && visited[i - 1][j] == 0 && grid[i - 1][j] == '1') {
            dfs(grid, visited, i - 1, j);
        }
        if (i + 1 <= grid.length - 1 && visited[i + 1][j] == 0 && grid[i + 1][j] == '1') {
            dfs(grid, visited, i + 1, j);
        }
        if (j - 1 >= 0 && visited[i][j - 1] == 0 && grid[i][j - 1] == '1') {
            dfs(grid, visited, i, j - 1);
        }
        if (j + 1 <= grid[0].length - 1 && visited[i][j + 1] == 0 && grid[i][j + 1] == '1') {
            dfs(grid, visited, i, j + 1);
        }

    }
}
