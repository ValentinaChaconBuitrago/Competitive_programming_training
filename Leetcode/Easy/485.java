class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxConsecutive = 0;
        int temp=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                maxConsecutive = Math.max(maxConsecutive,temp);
                temp=0;
            }else temp++; 
        }
        return  Math.max(maxConsecutive,temp);
    }
}