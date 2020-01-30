class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left=0,right=numbers.length-1;
        int[] ans = new int[2];
        while(left<right){
            int total = numbers[left]+numbers[right];
            if(total==target){
                ans[0]=left+1;
                ans[1]=right+1;
                return ans;
            }
            else if(total>target)right--;
            else left++;
        }
        return ans;
    }
}