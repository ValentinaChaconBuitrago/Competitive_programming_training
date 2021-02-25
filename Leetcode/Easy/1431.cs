public class Solution {
    public IList<bool> KidsWithCandies(int[] candies, int extraCandies) {

        IList<bool> ans = new bool[candies.Length];

        int max_num = 0;
        for(int i=0;i<candies.Length;i++){
            if(candies[i]>max_num)max_num=candies[i];
        }

        for(int i=0;i<candies.Length;i++){
            int total_candies = candies[i] + extraCandies;
            if(total_candies>=max_num){
                ans[i]=true;
            }
            else{
                ans[i]=false;
            }
        }
        return ans;
    }
}