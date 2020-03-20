class Solution {
    ArrayList<Integer>[] graph;
    int[] distance;
    public int longest(int node){
        if(distance[node]>0)return distance[node];
        distance[node]=1;
        for(int i=0;i<graph[node].size();i++){
            int child = graph[node].get(i);
            distance[node] = Math.max(distance[node], longest(child)+1);
        }

        return distance[node];
    }


    public int longestStrChain(String[] words) {
        //Step 1: initialize all tools/helpers
        distance = new int[words.length];
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
            maxPath = Math.max(maxPath,longest(i));
        }

        return maxPath;
    }
}