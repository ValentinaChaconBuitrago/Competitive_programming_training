#include<bits/stdc++.h>

using namespace std;

typedef vector<int> vii;
typedef long long ll;

int main(){

	int n;
	cin >> n;
	vii times;
	ll total_time = 0;
	while(n--){
		int t;
		cin >> t;
		total_time+=t;
		times.push_back(t);
	}
	int m;
	cin >> m;
	for(int i=0;i<m;++i){
		int p, x;
		cin >> p >> x;
		cout << total_time-times[p-1]+x<< endl;
	}

	return 0;
}