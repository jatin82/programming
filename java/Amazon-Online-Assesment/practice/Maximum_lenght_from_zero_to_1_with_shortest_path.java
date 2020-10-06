import java.util.*;

class Solution {

    public static void main(String[] args) {

        /*

        Maximum of all distances to the nearest 1 cell from any 0 cell in a Binary matrix

        https://www.geeksforgeeks.org/find-the-maximum-of-all-distances-to-the-nearest-1-cell-from-any-0-cell-in-a-binary-matrix/


         */

        int ans = new Solution().maxDistance(new int[][]{
                { 0, 1, 1 },
                { 0, 0, 1 },
                { 0, 0, 0 } });
        System.out.println(ans);
    }

    public int maxDistance(int [][] grid)
    {
        if (grid.length==0)
            return -1;
        int N = grid.length;

        int INF = 1000000;

        grid[0][0] = grid[0][0] == 1 ? 0 : INF;

        // Set up top row and left column
        for (int i = 1; i < N; i++)
            grid[0][i] = grid[0][i] == 1 ? 0 : grid[0][i - 1] + 1;

        for (int i = 1; i < N; i++)
            grid[i][0] = grid[i][0] == 1 ? 0 : grid[i - 1][0] + 1;

        // Pass one: top left to bottom right
        for (int i = 1; i < N; i++) {
            for (int j = 1; j < N; j++) {
                grid[i][j] = grid[i][j] == 1 ? 0 : Math.min(grid[i - 1][j], grid[i][j - 1]) + 1;
            }
        }

        // Check if there was no "One" Cell
        if (grid[N - 1][N - 1] >= INF)
            return -1;

        // Set up top row and left column
        int maxi = grid[N - 1][N - 1];

        for (int i = N - 2; i >= 0; i--) {
            grid[N - 1][i] = Math.min(grid[N - 1][i], grid[N - 1][i + 1] + 1);
            maxi = Math.max(grid[N - 1][i], maxi);
        }

        for (int i = N - 2; i >= 0; i--) {
            grid[i][N - 1] = Math.min(grid[i][N - 1], grid[i + 1][N - 1] + 1);
            maxi = Math.max(grid[i][N - 1], maxi);
        }

        // Past two: bottom right to top left
        for (int i = N - 2; i >= 0; i--) {
            for (int j = N - 2; j >= 0; j--) {
                grid[i][j] = Math.min(grid[i][j], Math.min(grid[i + 1][j] + 1, grid[i][j + 1] + 1));
                maxi = Math.max(grid[i][j], maxi);
            }
        }

        return maxi==0 ? -1 : maxi;
    }
}
