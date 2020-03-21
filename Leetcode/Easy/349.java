class Solution {
    public int[] intersectionNoMemory(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i=0,j=0;
        ArrayList<Integer> ans = new ArrayList<>();
        while(i<nums1.length && j<nums2.length){
            if(nums1[i]==nums2[j]){
                int c = nums1[i];
                ans.add(c);
                while(i<nums1.length && nums1[i]==c)i++;
                while(j<nums2.length && nums2[j]==c)j++;
            }
            else if(nums1[i]>nums2[j])j++;
            else if(nums1[i]<nums2[j])i++;
        }
        int[] intersect = new int[ans.size()];
        for(int k=0;k<ans.size();k++){
            intersect[k] = ans.get(k);
        }

        return intersect;
    }

    public int[] intersectionWithMemory(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> nums = new HashMap<>();
        for(int i=0;i<nums1.length;i++){
          nums.put(nums1[i],0);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<nums2.length;i++){
          int c = nums2[i];
          if(nums.containsKey(c) && nums.get(c)==0){
            list.add(c);
            nums.put(c,1);
          }
        }

       int[] ans = new int[list.size()];
      for(int i=0;i<list.size();i++){
        ans[i] = list.get(i);
      }
      return ans;
    }
}