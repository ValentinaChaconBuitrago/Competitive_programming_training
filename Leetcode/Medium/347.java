class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> ans = new ArrayList<>();
        if(nums.length==0)return null;

        HashMap<Integer,Integer> freq = new HashMap<>();
        int maxElement = 0;
        for(int i=0;i<nums.length;i++){
            freq.put(nums[i],freq.getOrDefault(nums[i],0)+1);
            maxElement = Math.max(maxElement, freq.get(nums[i]));
        }

        HashMap<Integer,List<Integer>> rep = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(freq.containsKey(nums[i])){
                List<Integer> list = rep.getOrDefault(freq.get(nums[i]), new ArrayList<>());
                list.add(nums[i]);
                rep.put(freq.get(nums[i]),list);
                freq.remove(nums[i]);
            }
        }

        while(k>0){
            while(!rep.containsKey(maxElement)){
                maxElement--;
            }
            List<Integer> list = rep.get(maxElement);
            for(int i=0;i<list.size();i++){
                ans.add(list.get(i));
            }
            rep.remove(maxElement);
            k-=list.size();
        }
        return ans;
    }
}