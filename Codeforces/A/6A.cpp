#include <iostream>

using namespace std;

int main(){
	int a, b, c, d;
	cin >> a >> b >> c >> d;
	int comb[12] = {a,b,c,a,c,d,d,c,b,d,b,a};
	string ans = "IMPOSSIBLE";
	for(int i=0;i<12;i+=3){
		int o1 = comb[i];
		int o2 = comb[i+1];
		int o3 = comb[i+2];
		if(o1+o2>o3 && o2+o3>o1 && o1+o3>o2){
			ans = "TRIANGLE";
			break;
		}
		else if(o1+o2==o3 || o2+o3==o1 || o1+o3==o2)ans = "SEGMENT";
	}
	cout << ans << endl;
	return 0;
}