class Solution {
    private ArrayList<Integer>[] graph;
    private int[] visited;
    private int[] recStack;
    private Stack<Integer> stack;

    public boolean hasCycle(int node){
        if(recStack[node]==1)return true;
        if(visited[node]==1)return false;

        visited[node]=1;
        recStack[node]=1;
        for(int i=0;i<graph[node].size();i++){
            int child = graph[node].get(i);
            if(hasCycle(child)) return true;
        }
        recStack[node]=0;
        stack.push(node);
        return false;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //Step 1: initialize tools/helpers
        int[] ans = new int[numCourses];
        stack = new Stack<>();
        recStack = new int[numCourses];
        visited = new int[numCourses];
        graph = new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++)graph[i]=new ArrayList<>();

        //Step 2: add edges to the graph
        for(int i=0;i<prerequisites.length;i++){
            int destination = prerequisites[i][0];
            int origin  = prerequisites[i][1];

            graph[origin].add(destination);
        }

        //Step 3: check if there is a cycle in the graph
        for(int i=0;i<numCourses;i++){
            if(visited[i]==0){
                if(hasCycle(i)) return new int[0];
            }
        }

        //Step 4: move elements from the stack to the array
        for(int i=0;i<numCourses;i++){
            int current = stack.pop();
            ans[i] = current;
        }

        return ans;
    }
}