#include<iostream>

using namespace std;

int main(){
	int a,b,c,x,y,z;
	cin >> a >> b >> c >> x >> y >> z;
	string ans = "NO";
	bool works = false;
	if(a<=x){
		x-=a;
		works=true;
	}
	int left = x+y;
	if(b<=left && works){
		left-=b;
		left+=z;
	}
	else works = false;
	if(c<=left && works) ans = "YES";
	cout << ans << endl;
	return 0;
}