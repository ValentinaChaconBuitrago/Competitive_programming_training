class Solution {
    public String longestPalindrome(String s) {
        if(s.isEmpty()) return "";
        
        int n = s.length();
        int longest = 0, startIndex = 0, endIndex = 0;
        boolean[][] palindrome = new boolean[n][n];
        
        for(int j=0;j<n;j++){
            palindrome[j][j]=true;
            for(int i=0;i<j;i++){
                if(s.charAt(i)==s.charAt(j)&&(j-i<=2||palindrome[i+1][j-1])){
                    palindrome[i][j]=true;
                    if(j-i+1>longest){
                        longest = j-i+1;
                        startIndex = i;
                        endIndex = j;
                    }
                }
                    
                
            }
        }
       return s.substring(startIndex,endIndex+1); 
    }
}