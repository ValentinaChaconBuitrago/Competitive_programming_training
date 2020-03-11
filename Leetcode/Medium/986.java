class Solution {
    public boolean inBetween(int x, int y, int c){
        if(c>=x && c<=y) return true;
        return false;
    }
    public int[][] intervalIntersection(int[][] A, int[][] B) {

        List<int[]> intervals = new ArrayList<>();

        int i=0,k=0;
        while(i<A.length && k<B.length){
            //Step 1: get data
            int startA = A[i][0];
            int endA = A[i][1];

            int startB = B[k][0];
            int endB = B[k][1];

            //Step 2: find interval bounds
            int sInterval = Math.max(startA,startB);
            int eInterval = Math.min(endA,endB);

            //Step 3: check if there's an interval
            if(inBetween(startA,endA,sInterval) && inBetween(startB,endB,sInterval)){
                int[] ans = new int[2];
                ans[0] = sInterval;
                ans[1] = eInterval;
                intervals.add(ans);
            }

            //Step 4: move to the next interval
            if(endA>endB) k++;
            else i++;
        }
        int[][] data = new int[intervals.size()][2];
        for(int j=0;j<intervals.size();j++){
            data[j] = intervals.get(j);
        }
        return data;
    }
}