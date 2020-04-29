class Solution {

    private int[][] graph;
    public int minDistance(int[] finalSet, int[] dist){
        int minDistance = Integer.MAX_VALUE;
        int minIndex = 0;
        for(int i=0;i<dist.length;i++){
            if(dist[i]<minDistance && finalSet[i]==0){
                minDistance = dist[i];
                minIndex = i;
            }
        }
        return minIndex;
    }
    public int[] dijkstra(int numVertices, int source){
        int[] dist = new int[numVertices];

        for(int i=0;i<numVertices;i++){
            dist[i]=Integer.MAX_VALUE;
        }
        dist[source] = 0;

        int[] finalSet = new int[numVertices];
        for(int i=0;i<numVertices-1;i++){
            int u = minDistance(finalSet, dist);
            finalSet[u] = 1;

            for(int j=0;j<graph[u].length;j++){
                if(graph[u][j]!=0 && finalSet[j]==0 && dist[j]>dist[u]+graph[u][j]){
                    if(graph[u][j]==-1) dist[j] = dist[u];
                    else dist[j]=dist[u] + graph[u][j];
                }
            }

        }
        return dist;
    }
    public int networkDelayTime(int[][] times, int N, int K) {
        graph = new int[N][N];
        for(int i=0;i<times.length;i++){
            int from = times[i][0] - 1;
            int to = times[i][1] -1 ;
            int weight = times[i][2];
            if(weight==0) weight=-1;
            graph[from][to] = weight;
        }
        int[] allTimes = dijkstra(N,K-1);
        int maxTime = 0;
        for(int i=0;i<allTimes.length;i++){
            maxTime = Math.max(maxTime, allTimes[i]);
        }
        return maxTime==Integer.MAX_VALUE?-1:maxTime;
    }
}