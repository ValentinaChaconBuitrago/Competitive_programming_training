#include <iostream>
#include <vector>
#include<algorithm>
 
using namespace std;
 
int main(){
	int tc;
	cin >> tc;
	while(tc--){
		int n;
		cin >> n;
		vector <int> candies(n+1,0);
		while(n--){
			int c;
			cin >> c;
			candies[c]++;
		}
		sort(candies.rbegin(),candies.rend());
 
		int ans = candies[0];
		int last = candies[0];
		for(int i=1;i<=candies.size();++i){
			if(last==0) break;
			if(candies[i]>=last){
				ans+=last-1;
				last--;
			}
			else{
				ans+=candies[i];
				last=candies[i];
			}
		}
		cout << ans << endl;
	}
	return 0;
}