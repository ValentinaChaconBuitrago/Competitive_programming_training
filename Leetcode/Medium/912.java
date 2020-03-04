//QuickSort
class Solution {
    public int partition(List<Integer> nums, int l, int r){
        int pivot = nums.get(l);
        int i=l,j=r;
        while(i<j){
            while(nums.get(i)<=pivot){
                i++;
            }
            while(nums.get(j)>pivot){
                j--;
            }
            if(i<j){
                int temp = nums.get(i);
                nums.set(i,nums.get(j));
                nums.set(j,temp);
            }
        }
        nums.set(l,nums.get(j));
        nums.set(j,pivot);
        return j;
    }


    public void quickSort(List<Integer> list, int l, int r){
        if(l<r){
            int posPivot = partition(list,l,r);
            quickSort(list,posPivot+1,r);
            quickSort(list,l,posPivot-1);
        }
    }

    public List<Integer> sortArray(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            ans.add(nums[i]);
        }
        ans.add(Integer.MAX_VALUE);
        quickSort(ans,0,ans.size()-1);
        ans.remove(ans.size()-1);
        return ans;
    }
}