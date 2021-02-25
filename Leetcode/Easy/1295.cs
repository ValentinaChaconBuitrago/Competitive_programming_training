public class Solution {
    public int FindNumbers(int[] nums) {
        int total_even = 0;
        for(int i=0;i<nums.Length;i++){
            int length = (int)Math.Floor(Math.Log10(nums[i])) + 1;
            if(length%2==0)total_even++;
        }
        return total_even;
    }
}