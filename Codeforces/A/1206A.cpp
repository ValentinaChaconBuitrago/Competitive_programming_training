#include <iostream>

using namespace std;

int main(){
	int a;
	cin >> a;
	int max1 = 0;
	while(a--){
		int f;
		cin >> f;
		if(f>max1)max1=f;
	}
	int b;
	cin >> b;
	int max2 = 0;
	while(b--){
		int g;
		cin >> g;
		if(g>max2)max2=g;
	}
	cout << max1 << " " << max2 << endl;
	return 0;
}