class Solution {

    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int temp_max = 0;
        for(int i=0;i<nums.length;i++){
            temp_max = Math.max(nums[i],temp_max+nums[i]);
            max = Math.max(max, temp_max);
        }
        return max;
    }

}