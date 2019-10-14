#include<bits/stdc++.h>

using namespace std;

int main(){
	int tc;
	cin >> tc;
	while(tc--){
		int L,v,l,r;
		cin >> L >> v >> l >> r;
		int lanterns = L/v;
		
		//Step 1: get the total number of lanterns that are less or equal to right
		int right = r/v;
		//Step 2: get the total number of lanterns that are less than left
		int left = (l-1)/v;
		
		int tot_eliminate = right - left;
		cout << lanterns - tot_eliminate << endl;
	}

return 0;
}
