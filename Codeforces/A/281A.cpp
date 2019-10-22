#include<bits/stdc++.h>

using namespace std;

int main(){
	string word;
	cin >> word;
	char up = toupper(word[0]);
	string ans = up + word.substr(1,word.size()-1);
	cout << ans << endl;
	return 0;
}