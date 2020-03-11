class Solution {
    public int longestOnes(int[] A, int K) {
        int i=0,j=0;
        int total = 0;
        for(;i<A.length;i++){
            if(A[i]==0)K--;
            if(K<0){
                total = Math.max(total,i-j);
                while(K<0){
                    if(A[j]==0)K++;
                    j++;
                }
            }
        }
        return Math.max(i-j,total);
    }
}