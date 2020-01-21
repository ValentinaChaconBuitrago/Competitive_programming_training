class Solution {
    public int pivotIndex(int[] nums) {
        int totalSum = 0;
        for(int i=0;i<nums.length;i++){
            totalSum+=nums[i];
        }
        int index = -1;
        int partialSum = 0;
        for(int i=0;i<nums.length;i++){
            totalSum-=nums[i];
            if(partialSum==totalSum){
                index = i;
                break;
            }
            partialSum+=nums[i];
        }
        
        return index;
    }
}