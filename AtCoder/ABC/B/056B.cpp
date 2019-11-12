#include<bits/stdc++.h>
using namespace std;

int main(){
	int w, a, b;
	cin >> w >> a >> b;
	//The lower rectangle goes before
	int dif;
	if(a+w<=b)dif = b-(a+w);
	else if(b+w<=a)dif = a-(b+w);
	
	cout << dif << endl;
	return 0;
}