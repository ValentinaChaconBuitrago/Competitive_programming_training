class Solution {
    public double angleClock(int hour, int minutes) {
        double minute = minutes*6;

        if(hour==12) hour=0;
        double hours = hour*30 + (minutes/(double)60)*30;

        double mini = Math.min(hours,minute);
        double max = Math.max(hours,minute);

        double option1 = 360-max+mini;
        double option2 = max - mini;

        return Math.min(option1,option2);
    }
}