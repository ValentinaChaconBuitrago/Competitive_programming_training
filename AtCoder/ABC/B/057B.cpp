#include<bits/stdc++.h>
 
using namespace std;
typedef pair<int,int> pii;
typedef pair<int, long long> pil;
typedef long long ll;
 
int main(){
	int n,m;
	cin >> n >> m;
	vector<pii>students;
	while(n--){
		int a,b;
		cin >> a >> b;
		pii stud = {a,b};
		students.push_back(stud);
	}	
	vector<pii> checkpoints;
	while(m--){
		int c,d;
		cin >> c >> d;
		pii check = {c,d};
		checkpoints.push_back(check);
	}
	pii stud,check;
	pil min_manhattan = {-1,LONG_MAX};
	ll manhattan;
	for(int i=0;i<students.size();++i){
		stud = students[i];
		for(int j=0; j<checkpoints.size();++j){
			check = checkpoints[j];
			manhattan = abs(stud.first - check.first) + abs(stud.second - check.second);
			if(manhattan < min_manhattan.second) min_manhattan = {j+1,manhattan};
		}
		cout << min_manhattan.first << endl;
		min_manhattan = {-1,LONG_MAX};
	}
 
	return 0;
}