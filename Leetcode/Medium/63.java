class Solution {

    public int uniquePathsWithObstacles(int[][] grid) {

        //Determine the seed
        if(grid[0][0]==0)grid[0][0]=1;
        else return 0;

        //Step 1: fill in the left side
        int m = grid.length;

        for(int i=1;i<m;i++){
            if(grid[i][0]==1)
                grid[i][0]=0;
            else
                grid[i][0]=grid[i-1][0];
        }
        //Step 2: fill in the top side
        int n = grid[0].length;
        for(int j=1;j<n;j++){
            if(grid[0][j]==1)
                grid[0][j]=0;
            else
                grid[0][j]=grid[0][j-1];
        }

        //Step 3: iterate over rows and colums adding paths
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(grid[i][j]==1) grid[i][j]=0;
                else{
                    grid[i][j]+=grid[i-1][j];
                    grid[i][j]+=grid[i][j-1];
                }

            }
        }
        return grid[m-1][n-1];
    }
}