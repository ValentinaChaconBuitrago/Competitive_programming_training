class Solution {
    public int islandPerimeter(int[][] grid) {
        int parameter = 0;
        int paramInCell = 4;
        for(int i=0;i<grid.length;++i){
            for(int j=0;j<grid[0].length;++j){
                //The cell belongs to the island
                paramInCell = 4;
                if(grid[i][j]==1){
                    if(i>0 && grid[i-1][j] == 1) paramInCell--;
                    if(i<grid.length-1 && grid[i+1][j] == 1) paramInCell--;
                    if(j>0 && grid[i][j-1] == 1) paramInCell--;
                    if(j<grid[0].length-1 && grid[i][j+1] == 1) paramInCell--;
                    parameter+=paramInCell;
                }
            }
        }
        return parameter;
    }
}