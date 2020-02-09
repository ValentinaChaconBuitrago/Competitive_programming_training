class Solution {
    public int mySqrt(int x) {
        if(x==0 || x==1) return x;
        int left = 1;
        int right = x/2;
        while(left<=right){
            int mid=left + (right-left)/2;
            int y = x/mid;
            if(y==mid)return mid;
            else if(y>mid)left=mid+1;
            else if(y<mid)right=mid-1;
        }
        return right;
    }
}