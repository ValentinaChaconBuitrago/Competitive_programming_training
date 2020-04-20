class Solution {
    public int reverse(int x) {
        long ans=0;
        while(x!=0){
            int digit=x%10;
            x/=10;

            ans*=10;
            ans+=digit;
            if(ans>=Integer.MAX_VALUE || ans<=Integer.MIN_VALUE)return 0;
        }
        return (int)ans;
    }
}