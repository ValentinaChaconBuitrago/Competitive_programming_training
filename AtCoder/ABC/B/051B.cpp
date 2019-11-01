#include <bits/stdc++.h>

using namespace std;

int main(){
	int k, s;
	cin >> k >> s;

	int total_ways = 0;
	for(int i=0;i<=k;++i){
		for(int j = 0;j<=k;++j){
		    int miss = s-i-j;
		    if(miss <= k && miss >= 0)total_ways++;
		}
	}

	cout << total_ways << endl;
	return 0;
}