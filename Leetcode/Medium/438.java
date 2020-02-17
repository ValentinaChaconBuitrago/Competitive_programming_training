class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        HashMap<Character,Integer>  alph= new HashMap<>();
        for(int i=0;i<p.length();i++){
            char c = p.charAt(i);
            alph.put(c,alph.getOrDefault(c,0)+1);
        }


        int counter = alph.size();
        int k=0;

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(alph.containsKey(c)){
                alph.put(c,alph.getOrDefault(c,0)-1);
                if(alph.get(c)==0) counter--;

                //found all characters, reduce substring
                if(counter==0){
                    while(counter==0){
                        char t = s.charAt(k);
                        if(alph.containsKey(t)){
                            alph.put(t,alph.getOrDefault(t,0)+1);
                            if(alph.get(t)>0)counter++;
                        }
                        k++;
                    }
                    if(i-k+2==p.length())
                        list.add(k-1);
                }
            }
        }

        return list;
    }
}