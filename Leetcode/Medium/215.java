class Solution {
    public int findKthLargest(int[] nums, int k) {

        HashMap<Integer,Integer> numbers = new HashMap<>();
        int min=Integer.MAX_VALUE, max = 0;
        for(int i=0;i<nums.length;i++){
            numbers.put(nums[i],numbers.getOrDefault(nums[i],0)+1);
            if(nums[i]<min)min=nums[i];
            if(nums[i]>max)max=nums[i];
        }

        int total = 0;
        for(int i=max;i>=min;i--){
            if(numbers.containsKey(i)){
                while(numbers.get(i)>0){
                    total++;
                    numbers.put(i,numbers.get(i)-1);
                }
                if(total>=k) return i;
            }
        }
        return -1;
    }
}