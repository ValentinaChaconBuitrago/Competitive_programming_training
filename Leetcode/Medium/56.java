class Solution {
    private class timeCompare implements Comparator<int[]>{
        @Override
        public int compare(int[] a, int[]b){
            if(a[0]<b[0]) return -1;
            else if(a[0]==b[0]) return 0;
            return 1;
        }
    }
    public int[][] merge(int[][] intervals) {

        Collections.sort(Arrays.asList(intervals), new timeCompare());
        ArrayList<int[]> merged = new ArrayList<>();

        for(int i=0;i<intervals.length;i++){
            if(i==0 || merged.get(merged.size()-1)[1]<intervals[i][0])
                merged.add(intervals[i]);
            else
                merged.get(merged.size()-1)[1]=Math.max(merged.get(merged.size()-1)[1],intervals[i][1]);
        }

        return merged.toArray(new int[merged.size()][]);
    }
}