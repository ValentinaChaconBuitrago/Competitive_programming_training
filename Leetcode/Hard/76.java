class Solution {
    public String minWindow(String s, String t) {
        if(t.length()>s.length()) return "";
        
        int minLength = Integer.MAX_VALUE;
        //Step 1: create hashmap with t characters as the alphabet
        HashMap<Character,Integer> alphabet = new HashMap<>();
        for(int i=0;i<t.length();i++){
            alphabet.put(t.charAt(i),alphabet.getOrDefault(t.charAt(i),0)+1);
        }
        
        //Step 2: determine the number of characters in the alphabet
        int missingCharacters = alphabet.size();
        int startingPosition=0;
        int k=0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(alphabet.containsKey(c)){
                alphabet.put(c,alphabet.get(c)-1);
                if(alphabet.get(c)==0){
                    missingCharacters--;
                }
                while(k<=i && missingCharacters==0){
                    char g = s.charAt(k);
                    if(alphabet.containsKey(g)){
                        alphabet.put(g,alphabet.get(g)+1);
                        if(alphabet.get(g)>0)
                            missingCharacters++;
                    }
                    if(i-k<minLength){
                        startingPosition=k;
                        minLength=i-k+1;
                    }
                    k++;
                }
            }
        }
        if(minLength==Integer.MAX_VALUE)return "";
        return s.substring(startingPosition,startingPosition+minLength);
    }
}