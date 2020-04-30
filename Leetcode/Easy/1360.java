class Solution {
    public int getDays(String date){
        String[] data = date.split("-");
        int year = Integer.parseInt(data[0]);
        int month = Integer.parseInt(data[1]);
        int day = Integer.parseInt(data[2]);

        int[] daysInMonth = {31,28,31,30,31,30,31,31,30,31,30,31};

        int totalDays = 0;
        //Step 1: add days of all previous years
        for(int i=1971;i<year;i++){
            totalDays+=isLeap(i)?366:365;
        }
        //Step 2: add days of previous months
        for(int i=0;i<month-1;i++){
            if(i==1 && isLeap(year)) totalDays++;
            totalDays+=daysInMonth[i];
        }
        //Step 3: add days prior to current
        totalDays+=day;

        return totalDays;
    }

    public boolean isLeap(int year){
        //A leap year is a multiple of 1, a multiple of 400 but not a multiple of 100
        return (year%4==0 && year%100!=0) || year%400==0;
    }

    public int daysBetweenDates(String date1, String date2) {
       return Math.abs(getDays(date1) - getDays(date2));
    }
}