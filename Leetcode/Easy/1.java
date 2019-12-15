class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        int[] indexes = new int[nums.length];
        System.arraycopy(nums,0,indexes,0,nums.length);
        
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length-1;
        int[] digits = new int[2];
        while(left<right){
            int add = nums[left] + nums[right];
            if(add==target){
                digits[0]=nums[left];
                digits[1]=nums[right];
                System.out.println("Pareja: " + nums[left] + ", " + nums[right]);
                break;
            }
            else if(add>target){
                right--;
            }
            else{
                left++;
            }
        }
        int[] ans = new int[2];
        for(int i=0;i<indexes.length;++i){
            if(indexes[i]==digits[0]){
                System.out.println("primer digito en: " + i);
                ans[0]=i;
                digits[0]=-1;
            }
            if(indexes[i]==digits[1]){
                System.out.println("segundo digito en: " + i);
                ans[1]=i;
            }
        }
        Arrays.sort(ans);
        return ans;
    }
}