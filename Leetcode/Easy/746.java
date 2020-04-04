class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if(cost.length==2)return Math.min(cost[0],cost[1]);

        int n = cost.length+1;
        int[] steps = new int[n];

        for(int i=0;i<cost.length;i++){
            steps[i]=cost[i];
        }
        for(int i=2;i<n;i++){
            steps[i] += Math.min(steps[i-1],steps[i-2]);
        }
        return steps[n-1];
    }
}