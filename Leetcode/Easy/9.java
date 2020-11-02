class Solution {

    public boolean isPalindrome(int x) {
        int num = x;
        int comp = 0;

        while(x>0){
            comp*=10;
            int digit = x%10;
            comp+=digit;
            x/=10;
        }

        return num==comp;
    }
}