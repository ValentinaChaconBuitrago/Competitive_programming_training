class Solution {
    public int dominantIndex(int[] nums) {
        int largestIndex = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>nums[largestIndex])largestIndex = i;
        }
        for(int i=0;i<nums.length;i++){
            if(i!=largestIndex && (nums[i]*2)>nums[largestIndex]) return -1;
        }
        return largestIndex;
    }
}