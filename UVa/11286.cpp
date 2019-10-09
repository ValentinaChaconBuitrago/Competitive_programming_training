#include <bits/stdc++.h>

using namespace std;

int main(){
	int n;
	while(scanf("%d",&n),n){
		//if(n==0) break;
		map<vector<int>,int> courses;
		while(n--){
			//Step 1: store classes as keys of the map and increase frequency once a key is repeated
			vector<int> nums;
			for(int i=0;i<5;++i){
				int c;
				scanf("%d",&c);
				nums.push_back(c);
			}
			sort(nums.begin(),nums.end());
			courses[nums]++;
		}

		//Step 2: identify the maximum number
		int max_rep = 0;
		for(auto it = courses.begin(); it!=courses.end();++it){
			max_rep = max(max_rep,it->second);	
		}

		//Step 3: get the total number of students that have a popular selection of classes
		int tot_popular = 0;
		for(auto it = courses.begin(); it!=courses.end();++it){
			if(it->second==max_rep)tot_popular+=it->second;
		}
		cout << tot_popular << endl;
	}
	return 0;
}