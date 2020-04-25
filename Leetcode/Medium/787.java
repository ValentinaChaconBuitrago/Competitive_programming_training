class Solution {
    private int minPath;
    private int[][] graph;
    private int[] visited;


    public void findPath(int src, int target, int K, int n, int cost){

        if(src==target){
            minPath = Math.min(minPath,cost);
            return;
        }
        if(K<0) return;

        for(int i=0;i<n;i++){
            if(graph[src][i]!=0 && visited[i]==0){
                visited[i]=1;
                if(cost+graph[src][i]<minPath) findPath(i,target,K-1,n,cost+graph[src][i]);
                visited[i]=0;
            }
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        minPath=Integer.MAX_VALUE;
        visited= new int[n];
        //Step 1: build graph
        graph = new int[n][n];

        for(int i=0;i<flights.length;i++){
            int from = flights[i][0];
            int to = flights[i][1];
            int weight = flights[i][2];
            graph[from][to]=weight;
        }

        findPath(src,dst,K,n,0);
        if(minPath==Integer.MAX_VALUE)return -1;
        return minPath;
    }
}