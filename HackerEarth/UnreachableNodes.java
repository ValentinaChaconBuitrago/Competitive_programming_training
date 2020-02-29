//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;


// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class TestClass {
    public static void dfs(int[] visited, ArrayList<Integer>[] graph, int index){
        if(visited[index]==1)return;

        visited[index]=1;
        ArrayList<Integer> nodes = graph[index];
        for(int i=0;i<nodes.size();i++){
            if(visited[nodes.get(i)]==0){
                dfs(visited,graph,nodes.get(i));
            }
        }
    }
    public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] data = br.readLine().split(" ");
        int n = Integer.parseInt(data[0]);
        int m = Integer.parseInt(data[1]);

        //Step 1: Define and initialize the graph
        ArrayList<Integer>[] graph = new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i]=new ArrayList<>();
        }

        //Step 2: Add edges to the graph
        while(m>0){
            String[] edge = br.readLine().split(" ");
            int u = Integer.parseInt(edge[0])-1;
            int v = Integer.parseInt(edge[1])-1;
            graph[v].add(u);
            graph[u].add(v);
            m--;
        }

        //Step 3: Visit all nodes that are reachable to the head node
        int headIndex = Integer.parseInt(br.readLine())-1;
        int[] visited = new int[n];
        dfs(visited,graph,headIndex);

        //Step 4: Identify which nodes were unreachable
        int total = 0;
        for(int i=0;i<n;i++){
            if(visited[i]==0)total++;
        }
        System.out.println(total);
    }
}