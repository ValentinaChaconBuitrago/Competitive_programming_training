class Solution {
    private ArrayList<Integer>[] graph;
    private int[] visited;
    private int[] recStack;

    public boolean hasCycle(int node){
        //Step 1: check if node is present in recursion stack
        if(recStack[node]==1) return true;

        //Step 2: check if node has been visited
        if(visited[node]==1) return false;

        //Step 3: visit and add node to recursion stack
        visited[node]=1;
        recStack[node]=1;

        //Step 4: go over node's children
        for(int i=0;i<graph[node].size();i++){
            int child = graph[node].get(i);
            if(hasCycle(child)) return true;
        }

        //Step 5: remove current node from recursion stack
        recStack[node]=0;
        return false;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //Step 1: initialize tools/helpers
        recStack = new int[numCourses];
        visited = new int[numCourses];
        graph = new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++) graph[i] = new ArrayList<>();

        //Step 2: add edges to the graph
        for(int i=0;i<prerequisites.length;i++){
            int origin = prerequisites[i][0];
            int destination = prerequisites[i][1];

            graph[origin].add(destination);
        }

        //Step 3: check if there are any cycles in the graph
        for(int i=0;i<numCourses;i++){
            if(visited[i]==0 && hasCycle(i))return false;
        }
        return true;
    }
}