#include <bits/stdc++.h>

using namespace std;
bool is_lucky(int x){
	while(x!=0){
		int d = x%10;
		if(d!=4 && d!=7){
			return false;
		}
		x/=10;
	}
	return true;
}

int main(){
	int n;
	cin >> n;
	string ans = "NO";
	for(int i=1;i<=n;++i){
	    if(is_lucky(i) && n%i==0){
	        ans = "YES";
	        break;
	    }
	}
    cout << ans << endl;
	return 0;
}