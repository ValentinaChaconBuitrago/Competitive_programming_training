//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;


// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class TestClass {
    public static int totalNumberOfStations(int[] drain, int index, int total){
        if(total<=0){
            return index;
        }
        int left = total-drain[index];
        return totalNumberOfStations(drain,index+1,left);
    }
    public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] data = br.readLine().split(" ");
        int n  = Integer.parseInt(data[0]);
        int x = Integer.parseInt(data[1]);

        String[] nums = br.readLine().split(" ");
        int[] drain = new int[n];

        for(int i = 0;i<n;i++){
            drain[i] = Integer.parseInt(nums[i]);
        }

        System.out.println(totalNumberOfStations(drain,0,x));

    }
}