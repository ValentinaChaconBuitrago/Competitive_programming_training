class Solution {
    private int[][] visited;

    public void dfs(int i, int j, char[][] grid){

        //Step 1: check if it was previously visited
        if(visited[i][j]==1) return;
        visited[i][j]=1;


        //Step 2: check connections in all four directions
        //Up
        if(i-1>=0 && grid[i-1][j]=='1') dfs(i-1,j,grid);
        //Down
        if(i+1<grid.length && grid[i+1][j]=='1') dfs(i+1,j,grid);
        //Left
        if(j-1>=0 && grid[i][j-1]=='1') dfs(i,j-1,grid);
        //Right
        if(j+1<grid[0].length && grid[i][j+1]=='1') dfs(i,j+1,grid);
    }

    public int numIslands(char[][] grid) {
        if(grid.length==0) return 0;
        visited = new int[grid.length][grid[0].length];

        int totalIslands = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(visited[i][j]==0 && grid[i][j]=='1'){
                    totalIslands++;
                    dfs(i, j, grid);
                }
            }
        }
        return totalIslands;
    }
}