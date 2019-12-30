#include<bits/stdc++.h>
 
using namespace std;
 
int main(){
	int tc;
	cin >> tc;
	while(tc--){
		int h,m;
		cin >> h >> m;
		int rem_min = 60-m;
		int rem_hour = 24 - (h+1);
		rem_hour*=60;
		cout << rem_min+rem_hour << endl;
	}
	return 0;
}