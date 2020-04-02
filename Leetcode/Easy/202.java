class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> nums = new HashSet<>();
        while(n!=1){
            int total = 0;
            while(n!=0){
                int digit = n%10;
                total+=(digit*digit);
                n/=10;
            }
            if(nums.contains(total)) return false;
            nums.add(total);
            n=total;
        }
        return true;
    }
}