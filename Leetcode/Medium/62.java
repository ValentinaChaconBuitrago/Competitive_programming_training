class Solution {
    public int uniquePaths(int m, int n) {
        int[][] grid = new int[m][n];
        //Step 1: calculate unique paths downwards
        for(int i=0;i<m;i++){
            grid[i][0]=1;
        }

        //Step 2: calculate unique paths sideways
        for(int j=0;j<n;j++){
            grid[0][j]=1;
        }

        //Step 3: calculate unique paths to finish
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                grid[i][j]=grid[i][j-1] + grid[i-1][j];
            }
        }
        return grid[m-1][n-1];
    }
}