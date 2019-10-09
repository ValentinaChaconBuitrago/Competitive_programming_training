#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main(){
	int n;
	vector<int>weights;
	while(n--){
		int c;
		cin >> c;
		weights.push_back(c);
	}
	
	sort(weights.begin(),weights.end());

	int nums[150005] = {0};
	int team = 0;
	for(int i=0;i<weights.size();++i){
		int c = weights[i];
		if(nums[c]==0){
			nums[c]++;
			teams++;
		}
		else if(nums[c-1]==0 && c-1>0){
			nums[c-1]++;
			teams++;
		}
		else if(nums[c+1]==0){
			nums[c+1]++;
			temas++;
		}
	}

	cout << teams << endl;

	return 0;
}