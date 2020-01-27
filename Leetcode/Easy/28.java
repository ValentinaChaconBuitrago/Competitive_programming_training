class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.isEmpty()) return 0;
    
        int j=0;
        for(int i=0;i<haystack.length()-needle.length()+1;i++){
            int pointer = i;
            while(j<needle.length() && haystack.charAt(pointer)==needle.charAt(j)){
                j++;
                pointer++;
            }
            if(j==needle.length()) return i;
            else j=0;
        }
        return -1;
    }
}