class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character,Integer> letters = new HashMap<>();
        for(int i=0;i<magazine.length();i++){
            char c = magazine.charAt(i);
            letters.put(c,letters.getOrDefault(c,0)+1);
        }
        for(int i=0;i<ransomNote.length();i++){
            char c = ransomNote.charAt(i);
            if(!letters.containsKey(c)||letters.get(c)==0)return false;
            letters.put(c,letters.get(c)-1);
        }
        return true;
    }
}