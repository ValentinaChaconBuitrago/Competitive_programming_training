class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0)return "";
        
        int minLength = Integer.MAX_VALUE;
        for(int i=0;i<strs.length;i++){
            minLength = Math.min(minLength,strs[i].length());
        }
        
        StringBuilder str = new StringBuilder();
        for(int i=0;i<minLength;i++){
            char c = strs[0].charAt(i);
            for(int j=0;j<strs.length;j++){
                if(strs[j].charAt(i)!=c) return str.toString();
            }
            str.append(c);
        }
        return str.toString();
    }
}