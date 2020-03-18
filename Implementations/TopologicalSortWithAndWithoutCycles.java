//Topological sort with and without cycle detection
class Solution {
    private ArrayList<Integer>[] graph;
    private int[] visited;
    private int[] recStack;
    private Stack<Integer> stack;

    //CASE 1: Topological sort in the case whith no cycles
    public void topologicalSort(int node){
        if(visited[node]==1) return;

        visited[node]=1;

        for(int i=0;i<graph[node].size();i++){
            int child = graph[node].get(i);
            topologicalSort(child);
        }
        stack.push(node);
    }

    public int[] findOrderNoCycles(int numCourses, int[][] prerequisites) {
        //Step 1: initialize helpers/tools
        visited = new int[numCourses];
        stack = new Stack<>();
        graph = new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++)graph[i] = new ArrayList<>();

        //Step 2: define edges
        for(int i=0;i<prerequisites.length;i++){
            int origin = prerequisites[i][1];
            int destination  = prerequisites[i][0];
            graph[origin].add(destination);
        }

        //Step 3: define topolofical sorting of nodes
        for(int i=0;i<numCourses;i++){
            if(visited[i]==0) topologicalSort(i);
        }
        int[] ans = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            ans[i]=stack.pop();
        }
        return ans;
    }




    //CASE 2: Topological sort with cycles
    public boolean hasCycle(int node){
        if(recStack[node]==1) return true;
        if(visited[node]==1) return false;

        recStack[node] = 1;
        visited[node] = 1;
        for(int i=0;i<graph[node].size();i++){
            int child = graph[node].get(i);
            //IMPORTANT: DO NOT CHECK HERE IF CHILD HAS BEEN VISITED
            if(hasCycle(child)) return true;
        }

        recStack[node]=0;
        stack.push(node);

        return false;
    }

    public int[] findOrderWithCycles(int numCourses, int[][] prerequisites) {
        //Step 1: initialize helpers/tools
        visited = new int[numCourses];
        recStack  = new int[numCourses];
        stack = new Stack<>();
        graph = new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++)graph[i] = new ArrayList<>();

        //Step 2: define edges
        for(int i=0;i<prerequisites.length;i++){
            int origin = prerequisites[i][1];
            int destination  = prerequisites[i][0];
            graph[origin].add(destination);
        }

        //Step 3: check if there is a cycle in the graph
        for(int i=0;i<numCourses;i++){
            if(visited[i]==0){
                if(hasCycle(i))return new int[0];
            }
        }

        //Step 4: get topological sorting of nodes
        int[] ans = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            ans[i] = stack.pop();
        }
        return ans;
    }
}