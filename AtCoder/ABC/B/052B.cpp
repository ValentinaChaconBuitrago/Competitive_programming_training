#include<bits/stdc++.h>

using namespace std;

int main(){
	int n; 
	string s;
	cin >> n >> s;
	int x = 0;
	int max_x = 0;
	for(int i=0;i<n;++i){
		if(s[i]=='I')x++;
		else x--;
		max_x = max(max_x,x);
	}
	cout << max_x << endl;
	return 0;
}