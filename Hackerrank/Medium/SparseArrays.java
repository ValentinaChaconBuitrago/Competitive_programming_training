    static int[] matchingStrings(String[] strings, String[] queries) {

        HashMap<String,Integer> data = new HashMap<>();
        for(int i=0;i<strings.length;++i){
            data.put(strings[i],data.getOrDefault(strings[i], 0) + 1);
        }
        int[] ans = new int[queries.length];
        for(int i=0;i<queries.length;++i){
            if(data.containsKey(queries[i])) ans[i]=data.get(queries[i]);
        }
        return ans;
    }