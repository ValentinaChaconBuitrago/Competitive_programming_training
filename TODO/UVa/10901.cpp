#include <bits/stdc++.h>

using namespace std;

string get_oposite(string x){
	string ans = "left";
	if(x=="left")
		ans = "right";
	return ans;
}

int main(){
	int tc;
	cin >> tc;
	while(tc--){
		int n,t,m;
		cin >> n >> t >> m;
		queue<int> left;
		queue<int> right;


		string current_side;
		bool has_start = false;
		while(m--){
			int time;
			string side;
			cin >> time >> side;
			if(side == "left")
				left.push(time);
			else
				right.push(time);

			if(!has_start){
				current_side = side;
				has_start = true;
			}
		}


		int prev_time = 0;
		while( !left.empty() || !right.empty()){
			int quantity = 0;
			while(current_side=="left" && !left.empty() && left.front() <= prev_time && quantity < n){
				int time = left.pop() + t + prev_time;
				cout << time << endl;
				current_side = "right";
				prev_time = 0;
				quantity ++;
			}
			if(current_side=="left" && left.empty()){
				prev_time += t;
				current_side = "right";
			}
			quantity = 0;
			while(current_side=="right" && !right.empty() && right.front()<=prev_time && quantity <n){
				int time = right.pop() + t + prev_time;
				cout << time << endl;
				current_side = "left";
				prev_time = 0;
				quantity++;
			}
			if(current_side=="right" && right.empty()){
				prev_time += t;
				current_side = "left";
			}

		}



	}
	return 0;
}