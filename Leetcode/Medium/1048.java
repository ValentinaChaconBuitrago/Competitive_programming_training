class Solution {
    ArrayList<Integer>[] graph;
    public int longest(int node, int path){
        //System.out.println("Node: " + node + " path: " + path);
        if(graph[node].size()==0) return path;
        int max=1;
        for(int i=0;i<graph[node].size();i++){
            int child = graph[node].get(i);
            //System.out.println("child of: " + node + " is: " + child);
            max = Math.max(max, longest(child, path+1));
        }
        return max;
    }


    public int longestStrChain(String[] words) {
        //Step 1: initialize all tools/helpers
        graph = new ArrayList[words.length];
        for(int i=0;i<words.length;i++){
            graph[i] = new ArrayList<>();
        }
        HashMap<String, Integer> indices = new HashMap<>();


        //Step 2: store the index of each word as an identifier for the node
        for(int i=0;i<words.length;i++){
            indices.put(words[i],i);
        }

        //Step 3: define the edges in the graph
        for(int i=0;i<words.length;i++){
            String s = words[i];
            for(int j=0;j<s.length();j++){
                String result = s.substring(0,j) + s.substring(j+1);
                if(indices.containsKey(result)){
                    graph[indices.get(result)].add(i);
                }
            }
        }
        //Step 4: find the longest path
        int maxPath = 0;
        for(int i=0;i<words.length;i++){
            maxPath = Math.max(maxPath,longest(i,1));
        }

        return maxPath;
    }
}