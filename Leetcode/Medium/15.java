class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();

        for(int i=0;i<nums.length;i++){
            if (i == 0 || (i > 0 && nums[i] != nums[i-1])) {
                int first = nums[i];
                int left = i+1;
                int right = nums.length-1;
                while(left<right){
                    int total = nums[i]+nums[left] + nums[right];
                    if(total==0){
                        ans.add(Arrays.asList(nums[i],nums[left],nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        right--;
                        left++;
                    }
                    else if(total>0)right--;
                    else left++;
                }
            }
        }
        return ans;
    }
}