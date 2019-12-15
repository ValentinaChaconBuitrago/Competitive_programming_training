class Solution {
    public void moveZeroes(int[] nums) {
        
        for(int i=0;i<nums.length;++i){
            if(nums[i]!=0){
               // System.out.println("numero distinto a cero: " + nums[i]);
                for(int j = i;j>0;j--){
                    //System.out.println("Numero actual: " + nums[j] + " numero anterior: " + nums[j-1]);
                    if(nums[j-1]==0 && nums[j]!=0){
                        //System.out.println("los puedo intercambiar");
                        nums[j-1] = nums[j];
                        nums[j]=0;
                    }
                    else break;
                    //System.out.println("Nuevo numero actual: " + nums[j] + " numero anterior: " + nums[j-1]);
                }
            }
        }
        
    }
}