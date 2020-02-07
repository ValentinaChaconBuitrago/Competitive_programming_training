class Solution {
    public int removeDuplicates(int[] nums) {
        int currentNumber = Integer.MIN_VALUE;
        int k=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=currentNumber){
                currentNumber=nums[i];
                nums[k]=currentNumber;
                k++;
            }
        }
        return k;
    }
}