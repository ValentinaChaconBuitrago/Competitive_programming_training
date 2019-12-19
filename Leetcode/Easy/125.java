class Solution {
    public boolean isValid(char c){
        if((c-'a'< 26 && c-'a'>=0)||(c-'0'< 10 && c-'0'>=0)) return true;
        return false;
    }
    
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int left = 0;
        int right = s.length()-1;
        
        boolean palindrome = true;
        while(left<right){
            if(isValid(s.charAt(left)) && isValid(s.charAt(right))){
                if(s.charAt(left)!=s.charAt(right)) return false;
                left++;
                right--;
            }
            else if(!isValid(s.charAt(left))) left++;
            else if(!isValid(s.charAt(right))) right--;
        }
        
        return true;
    }
}