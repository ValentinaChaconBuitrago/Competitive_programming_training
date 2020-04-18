class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int satisfied=0;
        for(int i=0;i<customers.length;i++){
            if(grumpy[i]==0)satisfied+=customers[i];
        }

        int i=0,j=0;
        int totalVisited=0;
        int maxCustomers=0;
        int currentCustomers=0;
        while(i<customers.length){
            while(totalVisited<X){
                if(grumpy[i]==1)currentCustomers+=customers[i];
                i++;
                totalVisited++;
            }
            if(totalVisited==X){
                maxCustomers=Math.max(maxCustomers,currentCustomers);
                totalVisited--;
                if(grumpy[j]==1){
                    currentCustomers-=customers[j];
                }
                j++;
            }
        }
        return satisfied+maxCustomers;
    }
}