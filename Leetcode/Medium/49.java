class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String,ArrayList<String>> data = new HashMap<>();
        for(int i=0;i<strs.length;++i){
            char[] r = strs[i].toCharArray();
            Arrays.sort(r);
            String w = String.valueOf(r);
            //System.out.println("ordered word: " + w + " original word: " + strs[i]);
            if(!data.containsKey(w)){
                //System.out.println("this is a new key: " + w);
                ArrayList<String> adding = new ArrayList<>();
                adding.add(strs[i]);
                data.put(w,adding); 
                //System.out.println(data.get(w));
            }
            else{
                //System.out.println("this is an old key: " + w);
                ArrayList<String> fi = data.get(w);
                fi.add(strs[i]);
                data.put(w,fi); 
                //System.out.println(data.get(w));
            }
        }

        //Another way of doing it that takes longer is -->  List<List<String>> ans = new ArrayList(data.values());
        List<List<String>> ans = new ArrayList<>();
        for(ArrayList<String> value: data.values()){
            ans.add(value);
        }

        return ans;
    }
}