class Solution {
    public int countServers(int[][] grid) {
        int[] rows = new int[grid.length];
        int[] columns = new int[grid[0].length];
        int numServers = 0;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    numServers++;
                    rows[i]++;
                    columns[j]++;
                }
            }
        }

        for(int i=0;i<grid.length;i++){
            if(rows[i]==1){
                for(int j=0;j<grid[0].length;j++){
                    if(grid[i][j]==1 && columns[j]==1) numServers--;
                }
            }
        }
        return numServers;
    }
}