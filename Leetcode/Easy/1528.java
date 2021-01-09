class Solution {
    public String restoreString(String s, int[] indices) {
        char[] word = new char[indices.length];

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            int index = indices[i];
            word[index] = c;
        }

        return new String(word);
    }
}