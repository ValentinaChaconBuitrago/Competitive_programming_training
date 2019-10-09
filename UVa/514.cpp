#include<bits/stdc++.h>

using namespace std;

int main(){
	int n;
	while(scanf("%d",&n)){
		if(n==0) break;

		int first;
		cin >> first;
		
		while(first!=0){
			vector<int> permutation;
			permutation.push_back(first);
			int miss = n - 1;
			while(miss--){
			    int c;
			    cin >> c;
			    permutation.push_back(c);    
			}
			stack<int> station;
			int current = 0;
			string ans = "Yes";
			for(int i=0;i<permutation.size();++i){
				int looking = permutation[i];
				//Case 1: looking is greater than current, need to add to the stack
				if(current<looking){
					while(current<looking){
						current++;
						station.push(current);
					}
					//Delete items that are the same in stack and in the permutation
					station.pop();
				}
				//Case 2: looking is greater than current, it's already in stack
				else if(current>looking){
					//Both items in the stack and permutation are the same
					if(station.top()==looking){ 
					    station.pop();
					}
					else{
						ans = "No";
						break;
					}
				}
			}
			cout << ans << endl; 
			cin >> first;
		}
        cout << "\n";
	}
	return 0;
}