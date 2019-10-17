#include<bits/stdc++.h>

using namespace std;

int main(){
	int n;
	while(cin >> n && n){
		
		//I want to minimize the cost that I have to "carry arround", because cost get accumulated in each operation
		//I want to get the smallest numbers first, this way accumulating less cost
		priority_queue <int, vector<int>, greater<int>> gq;
		while(n--){
			long long c;
			cin >> c;
			gq.push(c);
		}
		long long total = 0;
		while(gq.size()>1){
			int t = gq.top();
			gq.pop();
			
			int s = gq.top();
			gq.pop();
			
			int sum = t + s;
			gq.push(sum);
			total += sum;
		}
		cout << total << endl;
	}
	return 0;
}