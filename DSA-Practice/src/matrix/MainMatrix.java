package matrix;

public class MainMatrix {

    //63. Unique Paths II
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if (obstacleGrid[0][0] == 1) return 0;
        obstacleGrid[0][0] = 1;

        for (int i = 1; i < m; i++) {
            obstacleGrid[i][0] = (obstacleGrid[i][0] == 0 && obstacleGrid[i - 1][0] == 1) ? 1 : 0;
        }
        for (int j = 1; j < n; j++) {
            obstacleGrid[0][j] = (obstacleGrid[0][j] == 0 && obstacleGrid[0][j - 1] == 1) ? 1 : 0;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) obstacleGrid[i][j] = 0;
                else obstacleGrid[i][j] = obstacleGrid[i-1][j] + obstacleGrid[i][j-1];
            }
        }

        return obstacleGrid[m-1][n-1];
    }
//    private  static int dfs(int[][] grid, int i, int j, int m, int n) {
//        if( i >= m || j >= n || grid[i][j] == 1) return 0;
//        if (i == m -1 && j == n - 1) return 1;
//        return dfs(grid, i + 1, j,m,n) + dfs(grid, i, j+1, m,n);
//    }


    public static void main(String[] args) {
        int [][] a = new int[][]{{0,0,0},{0,1,0},{0,0,0},{0,0,0}};
        System.out.println(uniquePathsWithObstacles(a));
    }
}
