class Solution {
    public int minSubArrayLen(int s, int[] nums) {
      
        int minLength = Integer.MAX_VALUE;
        int k=0;
        int total=0;
        for(int i=0;i<nums.length;i++){
            total+=nums[i];
            while(k<nums.length && total>=s){
                minLength = Math.min(minLength,i-k+1);
                total-=nums[k];
                k++;
            }
        }
        return minLength==Integer.MAX_VALUE?0:minLength;
    }
}