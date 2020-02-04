class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> alphabet = new HashSet<>();
        
        int longest = 0;
        
        int k=0,i=0;
        while(i<s.length()){
            char c = s.charAt(i);
            if(!alphabet.contains(c)){
                alphabet.add(c);
                longest = Math.max(longest,i-k+1);
                i++;
            }
            else{
                while(alphabet.contains(c)){
                    alphabet.remove(s.charAt(k));
                    k++;
                }
            }
        }
        return longest;
    }
}