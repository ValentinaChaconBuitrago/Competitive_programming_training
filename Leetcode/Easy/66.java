class Solution {
    public int[] plusOne(int[] digits) {
        for(int i=digits.length-1;i>=0;i--){
            if((digits[i]+1)<10){
                digits[i]++;
                return digits;
            }
            else{
                digits[i]=0;
            }
        }
        int[] total = new int[digits.length+1];
        total[0]=1;
        return total;
    }
}