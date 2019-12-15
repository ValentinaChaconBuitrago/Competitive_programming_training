class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length()) return false;
        
        HashMap<Character,Character> alphabet = new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(!alphabet.containsKey(s.charAt(i))){
                if(!alphabet.containsValue(t.charAt(i)))
                    alphabet.put(s.charAt(i),t.charAt(i));
                else return false;
            }
            else{

                if(alphabet.get(s.charAt(i))!=t.charAt(i)) return false;
            }
        }
        return true;
    }
    
}