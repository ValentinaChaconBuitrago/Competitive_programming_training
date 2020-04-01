class Solution {
	/*
	XOR Bit Operator:
	- a ^ 0 = a
	- a ^ a = 0
	- a ^ b ^ a = (a ^ a) ^ b = 0 ^ b = b
	*/
    public int singleNumber(int[] nums) {
        int ans = nums[0];
        for(int i=1;i<nums.length;i++){
            ans ^= nums[i];
        }
        return ans;
    }
}