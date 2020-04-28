class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] numCoins = new int[amount+1];
        //I don't need any coins to reach amount 0
        numCoins[0]=0;


        //Because we are looking for the minimum, initialize all number of coins to max
        for(int i=1;i<=amount;i++){
            //If we use Integer.MAX_VALUE there will be overflow
            numCoins[i]=amount+1;
        }


        for(int i=1;i<=amount;i++){
            for(int j=0;j<coins.length;j++){
                int index = i-coins[j];
                if(index>=0){
                    //To reach the current amount I need to add a new coin
                    numCoins[i] = Math.min(numCoins[i],numCoins[index]+1);
                }
            }
        }
        return numCoins[amount]>amount?-1:numCoins[amount];
    }
}