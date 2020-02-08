class Solution {


    public int binarySearch(int[] nums, int left, int right, int target){
        while(left<=right){
            int mid = left + (right - left)/2;
            if(nums[mid]==target)return mid;
            else if(nums[mid]>target) right = mid-1;
            else if(nums[mid]<target) left = mid+1;
        }
        return -1;
    }

    public int search(int[] nums, int target) {
        if(nums.length==0)return -1;

        //Step 1: find the pivot

        /*
        RULES:
        **left>mid && right>mid --> pivot located at left
        **left<mid && right<mid --> pivot located at right
        */

        int left=0,right=nums.length-1;
        while(left<=right){
            int mid = left + (right-left)/2;

            if(mid==right || mid==left)break;

            if(nums[left]>=nums[mid] && nums[right]>=nums[mid])right=mid;
            else if(nums[left]<=nums[mid] && nums[right]<=nums[mid])left=mid;
            else if(nums[left]<=nums[mid] && nums[mid]<=nums[right])break;
        }

        //Step 2: Do binary search on each half

        int before = binarySearch(nums,0,left,target);
        int after = binarySearch(nums,left+1,nums.length-1, target);

        if(before!=-1) return before;
        else return after;
    }
}