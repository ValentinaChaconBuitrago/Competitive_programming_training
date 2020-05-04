class Solution {
    int visited[];
    public void dfs(int i, int[][]M){

        if(visited[i]==1)return;
        visited[i]=1;

        for(int j=0;j<M[0].length;j++){
            if(M[i][j]==1)dfs(j,M);
        }
    }

    public int findCircleNum(int[][] M) {
        if(M.length==0)return 0;
        visited = new int[M.length];

        int numCircles=0;
        for(int i=0;i<M.length;i++){
            if(visited[i]==0){
                dfs(i,M);
                numCircles++;
            }
        }

        return numCircles;
    }
}