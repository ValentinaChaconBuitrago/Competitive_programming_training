#include<bits/stdc++.h>

using namespace std;

int main(){
	string s;
	cin >> s;

	string word = "hello";
	int i=0;
	for(int j=0;j<s.size();++j){
		if(s[j]==word[i]){
		    //cout << "comparando " << s[j] << " " << word[i] << endl;
			i++;
		}
	}
	//cout << "valor de i " << i << endl;
	if(i==word.size())
		cout << "YES" << endl;
	else 
		cout << "NO" << endl;	
	return 0;
}