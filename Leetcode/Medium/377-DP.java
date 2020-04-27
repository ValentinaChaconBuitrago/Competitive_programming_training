class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] combinations = new int[target+1];
        combinations[0]=1;
        for(int i=1;i<=target;i++){
            for(int j=0;j<nums.length;j++){
                int index=i-nums[j];
                if(index>=0){
                  combinations[i]+=combinations[index];
                }
            }
        }
        return combinations[target];
    }
}