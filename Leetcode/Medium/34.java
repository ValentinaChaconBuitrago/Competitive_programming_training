class Solution {

    public int binarySearch(int[] nums, int target, boolean isRight){
        int left=0,right=nums.length-1;
        int index=-1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(nums[mid]==target){
                index=mid;
                if(isRight) left=mid+1;
                else right=mid-1;
            }
            else if(nums[mid]>target)right = mid-1;
            else if(nums[mid]<target)left = mid+1;
        }
        return index;
    }

    public int[] searchRange(int[] nums, int target) {
        //Goal, find leftmost and rightmost positions of the target
        int[] range = new int[2];
        range[0] = binarySearch(nums,target,false);
        range[1] = binarySearch(nums,target,true);

        return range;
    }
}