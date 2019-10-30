#include<bits/stdc++.h>

using namespace std;
typedef vector<int> vii;

int main(){
	string w;
	cin >> w;
	vii letters(26,0);
	for(int i=0;i<w.size();++i){
	    int index = w[i] - 'a';
		letters[index]++;
	}
	bool even = true;
	for(int i=0;i<letters.size();++i){
	    if(letters[i]%2!=0){
	        even = false;
	        break;
	    } 
	}
	
	cout << (even==true?"Yes":"No") << endl;

	return 0;
}