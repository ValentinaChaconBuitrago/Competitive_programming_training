#include<bits/stdc++.h>
 
using namespace std;
 
int main(){
	int tc;
	cin >> tc;
	while(tc--){
		int n,k;
		cin >> n >> k;
		int total = n/k * k;
		int rem = n%k;
		if(rem<=k/2){
		    total+=rem;
		}
		else total+=k/2;
		cout << total << endl; 
	}
 
	return 0;
}