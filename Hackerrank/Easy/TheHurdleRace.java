static int hurdleRace(int k, int[] height) {
    int maxHurdle = 0;
    for(int i=0;i<height.length;i++)
        maxHurdle = Math.max(maxHurdle,height[i]);
    return Math.max(0,maxHurdle - k);
}