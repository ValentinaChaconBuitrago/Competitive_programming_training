import java.io.*;  
import java.util.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        //Step 1: Identify the level in which each node is located. 
        //Step 2: Iterate over the array of levels to identify the ones that are equal to the given numbers
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nodes = Integer.parseInt(br.readLine());
        
        boolean[] visited = new boolean[nodes+5];
        int[] level = new int[nodes+5];
        
        
        //Initialize all lists representing the nodes in the graph
        LinkedList<Integer>[] graph = new LinkedList[nodes+5];
        for(int i=0;i<nodes+5;++i){
            graph[i] = new LinkedList<>();
        }
        
        //Identify the edges of each vertex
        while(nodes>1){
            String[] nums = br.readLine().split(" ");
            int u = Integer.parseInt(nums[0]);
            int v = Integer.parseInt(nums[1]);
            graph[u].add(v);
            graph[v].add(u);
            --nodes;
        }
        
        //Queue used to store order of visited nodes
        LinkedList<Integer> nodeQueue = new LinkedList<>();
        
        //Source: Root of the tree which in this case represents node 1;
        //Mark the source node as visited and add it to the queue 
        level[1]=1;
        visited[1]=true;
        nodeQueue.add(1);
        
        while(nodeQueue.size()!=0){
            int s = nodeQueue.poll();
            Iterator<Integer> i = graph[s].listIterator();
            while(i.hasNext()){
                int n = i.next();
                if(!visited[n]){
                    visited[n]=true;
                    nodeQueue.add(n);
                    level[n]=level[s]+1;
                }
            }
        }
        int x = Integer.parseInt(br.readLine());
        int tot = 0;
        for(int i=0;i<level.length;++i){
            if(level[i]==x)++tot;
        }
        
     System.out.println(tot); 

    }
}