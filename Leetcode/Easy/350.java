class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> repetitions = new HashMap<>();

        int[] small = null;
        int[] large = null;
        if(nums1.length<nums2.length){
            small = nums1;
            large = nums2;
        }else{
            small = nums2;
            large = nums1;
        }

        for(int i=0;i<small.length;i++){
            repetitions.put(small[i],repetitions.getOrDefault(small[i],0)+1);
        }

        List<Integer> repeated = new ArrayList<>();

        for(int i=0;i<large.length;i++){
            if(repetitions.containsKey(large[i])){
                int left = repetitions.get(large[i])-1;
                if(left==0)repetitions.remove(large[i]);
                else repetitions.put(large[i],left);

                repeated.add(large[i]);
            }
        }

        int[] ans = new int[repeated.size()];
        for(int i=0;i<repeated.size();i++){
            ans[i] = repeated.get(i);
        }

        return ans;
    }
}