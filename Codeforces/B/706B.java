import java.io.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		String[] data = br.readLine().split(" ");
		int[] prices = new int[100002];
		for(int i=0;i<data.length;i++){
			prices[Integer.parseInt(data[i])]++;
		}
		for(int i=1;i<prices.length;i++){
			prices[i]+=prices[i-1];
		}

		int q = Integer.parseInt(br.readLine());
		while(q>0){
			int m = Integer.parseInt(br.readLine());
			if(m>=100000) System.out.println(prices[100000]);
			else System.out.println(prices[m]);
			q--;
		}
	}
}