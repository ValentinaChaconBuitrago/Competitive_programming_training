#include <bits/stdc++.h>

using namespace std;

int digits[10];

bool works(int x){
	bool is = true;
	while(x){
		int d = x%10;
		if(digits[d]==1){
			is = false;
			break;
		}
		x/=10;
	}
	return is;
}

int main(){
	int n,k;
	cin >> n >> k;

	while(k--){
		int c;
		cin >> c;
		digits[c] = 1;
		//cout << "se marco el digito " << c << endl;
	}
	bool found = false;
	while(!found){
		if(works(n))break;
		else{
			n++;
		}
	}
	cout << n << endl;

	return 0;
}