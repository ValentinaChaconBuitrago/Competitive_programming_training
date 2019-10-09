#include <bits/stdc++.h>

using namespace std;

int main(){
	int n;
	cin >> n;
	vector<int> connections;
	while(n--){
		int c;
		cin >> c;
		connections.push_back(c);
	}
	string ans = "NO";
	for(int i=0;i<connections.size();++i){
		if(connections[connections[connections[i]-1]-1] = i+1){
			ans = "YES";
			break;
		}
	}
	cout << ans << endl;
	return 0;
}
