#include<bits/stdc++.h>

using namespace std;

#define mods 1000000000+7;
typedef long long ll; 

int main(){

	int n;
	cin >> n;
	ll power = 1;
	for(int i=1; i<=n;++i){
		power*=i;
		power%=mods;
	}
	cout << power << endl;
	return 0;
	 
}