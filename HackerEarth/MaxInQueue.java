import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class TestClass {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] nums = br.readLine().split(" ");
        
        PriorityQueue<Integer> pQueue = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<n;++i){
            pQueue.add(Integer.parseInt(nums[i]));
        }
        
        int q = Integer.parseInt(br.readLine());
        while(q>0){
            String[] query = br.readLine().split(" ");
            //type 2 query
            if(query.length==2){
                pQueue.add(Integer.parseInt(query[1]));
            }
            else if(query.length==1){
                System.out.println(pQueue.peek());
            }
            q--;
        }

    }
}