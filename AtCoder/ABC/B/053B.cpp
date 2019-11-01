#include<bits/stdc++.h>

using namespace std;

int main(){
	string z;
	cin >> z;

	int pos_a = -1;
	int pos_z = -1;
	for(int i=0;i<z.size();++i){
		if(z[i]=='A' && pos_a==-1)pos_a=i;
		if(z[i]=='Z' && i>pos_a)pos_z=i;
	}

	cout << (pos_z-pos_a+1) << endl;
	return 0;
}