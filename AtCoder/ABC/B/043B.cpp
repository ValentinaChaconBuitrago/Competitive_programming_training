#include<bits/stdc++.h>

using namespace std;

int main(){
	string s;
	cin >> s;

	string ans = "";
	for(int i=0;i<s.size();++i){
		char c = s[i];
		cout << "asi va la respuesta " << ans << endl;
		if(c == 'B'){
			if(ans.size()>0)
				ans = ans.str(ans.begin(),ans.size()-1);
		}
		else{
			ans+=c;
		}
	}

	return 0;
}