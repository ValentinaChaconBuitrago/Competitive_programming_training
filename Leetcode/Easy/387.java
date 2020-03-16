class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> repeated = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            repeated.put(c,repeated.getOrDefault(c,0)+1);
        }
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(repeated.get(c)==1)return i;
        }
        return -1;
    }
}