class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> orderedStones = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<stones.length;i++){
            orderedStones.add(stones[i]);
        }
        while(orderedStones.size()>1){
            int first = orderedStones.poll();
            int second = orderedStones.poll();
            int result = Math.abs(first-second);
            orderedStones.add(result);
        }
        return orderedStones.poll();
    }
}