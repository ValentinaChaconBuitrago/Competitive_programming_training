#include<bits/stdc++.h>

using namespace std;

int main(){
	int tc;
	scanf("%d" , &tc);
	while(tc--){
		int n;
		scanf("%d", &n);
		vector<int> flakes;
		//Keep track of the number of times the flake has appeared
		while(n--){
			int c;
			scanf("%d",&c);
			flakes.push_back(c);
		}
		//Key: type of flake; Value: index where it was last seen
		map<int,int> position;
		int max_length = 0;
		int i=0,j=0;
		while(i<=j && j<flakes.size()){
			//O(LogN) for lookups
			auto it = position.find(flakes[j]);
			
			//Case 1: the map does not contain the flake -> add it and save its position
			if(it==position.end()){
				position.insert({flakes[j],j});
			}

			//Case 2: the map contains the flake -> remove flake by updating the value of i;
			else if(it!=position.end()){
				i = max(i,position[flakes[j]]+1);
				position[flakes[j]] = j;
			}
			max_length = max(max_length,j+1-i);
			++j;
		}
		cout << max_length << endl;
	}
	return 0;
}