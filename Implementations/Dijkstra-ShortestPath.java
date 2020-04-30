class Solution{

	private int[][] graph;

	public int minDistance(seenSet, dist){
		int minDist = Integer.MAX_VALUE;
		int minIndex = 0;
		for(int i=0;i<dist.length;i++){
			if(dist[i]<minDist && seenSet[i]==0){
				minDist = dist[i];
				minIndex = i;
			}
		}
		return minIndex;
	}

	//Using minDistance gives overall time complexity of O(V^2).
	//If instead a priorityQueue kept the distances overall time complexity would be O(VlogV)
	public int[] dijkstra(int numVertices, int source){
		int[] seenSet = new int[numVertices];
		int[] dist = new int[numVertices];
		for(int i=0;i<numVertices;i++){
			dist[i] = Integer.MAX_VALUE;
		}
		dist[source] = 0;

		//When searching for a specific target stop calculating once seenSet[target]==1
		for(int i=0;i<numVertices;i++){
			int u = minDistance(seenSet, dist);
			seenSet[u]=1;

			for(int j=0;j<numVertices;j++){
				if(graph[u][j]>0 && seenSet[j]==0 && dist[j]>dist[u]+graph[u][j]){
					dist[j]=dist[u]+graph[u][j];
				}
			}
		}
		return dist;
	}

}