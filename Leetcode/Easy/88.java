class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        m--;
        n--;
        for(int k=nums1.length-1;k>=0;k--){
            if(m>=0 && n>=0){
                if(nums1[m]>nums2[n]){
                    nums1[k]=nums1[m];
                    m--;
                }
                else{
                    nums1[k]=nums2[n];
                    n--;
                }
            }
            else if(m>=0){
                nums1[k] = nums1[m];
                m--;
            }
            else if(n>=0){
                nums1[k] = nums2[n];
                n--;
            }
        }
    }
}