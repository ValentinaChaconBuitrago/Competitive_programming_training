/* IMPORTANT: Multiple classes and nested static classes are supported */


import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;


// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class TestClass {
    private static LinkedList<Integer>[] graph;
    private static int n;
    
    public static int BFS(int source, int levelF){
        int[] visited = new int[n+5];
        int[] level = new int[n+5];
        Queue<Integer> queue = new LinkedList<>();
        
        visited[source] = 1;
        level[source] = 0;
        queue.add(source);
        int totalLevel = 0;
        while(queue.size()>0){
            int current = queue.poll();
            for(int i=0;i<graph[current].size();i++){
                int c = graph[current].get(i);
                if(visited[c]==0){
                    visited[c]=1;
                    level[c]=level[current] + 1;
                    queue.add(c);
                    if(level[c]==levelF)totalLevel++;
                }
            }
        }
        
        return totalLevel;
        
    }
    public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nums = br.readLine().split(" ");
        n = Integer.parseInt(nums[0]);
        int e = Integer.parseInt(nums[1]);
        
        //Initialize the graph
        graph = new LinkedList[n+5];
        for(int i=0;i<n+5;i++){
            graph[i] = new LinkedList<>();
        }
        
        while(e>0){
            String[] conn = br.readLine().split(" ");
            int u = Integer.parseInt(conn[0]);
            int v = Integer.parseInt(conn[1]);
            graph[u].add(v);
            graph[v].add(u);
            e--;
        }
        
        int m = Integer.parseInt(br.readLine());
        while(m>0){
            String[] data = br.readLine().split(" ");
            int source = Integer.parseInt(data[0]);
            int distance = Integer.parseInt(data[1]);
            System.out.println(BFS(source,distance));
            m--;
        }

    }
}
