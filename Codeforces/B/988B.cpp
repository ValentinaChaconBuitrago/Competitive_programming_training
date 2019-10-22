#include<bits/stdc++.h>

using namespace std;

int main(){
	int n;
	cin >> n;
	//cout << "valor de n: " << n << endl;
	multimap<int,string> words;
	while(n--){
		string w;
		cin >> w;
		//cout << "palabra actual "<< w << endl;
		words.insert({w.size(),w});
	}


	bool ans = true;
	auto it = words.begin();
	string prev = it -> second;
	
	string curr;
	it++;
	while(it!=words.end()){
		curr = it -> second;
		//cout << "prev: " << prev << " current: "  << curr << endl;
		if(curr.find(prev)==string::npos){
			ans = false;
			break;
		}
		prev = curr;
		it++;
	}
	
	if(ans){
		cout << "YES" << endl;
		for(auto it=words.begin();it!=words.end();it++){
			cout << it -> second << endl;
		}
	}	
	else{
		cout << "NO" << endl;
	}
	return 0;
}