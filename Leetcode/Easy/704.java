class Solution {
    public int search(int[] nums, int target) {
        int left=0, right=nums.length-1;
        int mid=(left+right)/2;
        while(left<=right){
            if(nums[mid]==target)return mid;

            if(nums[mid]>target)right=mid-1;
            else if(nums[mid]<target)left=mid+1;

            mid=(left+right)/2;
        }

        return -1;
    }
}