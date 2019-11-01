#include<bits/stdc++.h>

using namespace std;

typedef long long ll;

int main(){
	ll a,b,x;
	cin >> a >> b >> x;
    cout << (a==0?b/x + 1:b/x-(a-1)/x) << endl;
	return 0;
}