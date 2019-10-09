#include <bits/stdc++.h>

using namespace std;

#define M 32 

int main(){
	int n;
	while(scanf("%d",&n)){
		if(n==0) break;
		bitset<M> a (n);
		bitset<M> b (n);
		//cout << "valor a " << a << endl;
		//cout << "valor b " << b << endl;
		bool eve = true;
		for(int i=0;i<a.size();++i){
			if(a.test(i)==1){
				if(eve){
					b.flip(i);
					//cout << "valor actualizado b " << b << endl;
					eve = false;
				}
				else{
					a.flip(i);
					//cout << "valor actualizado a " << a << endl;
					eve = true;
				}
			}
		}
		int a_number = (int)(a.to_ulong());
		int b_number = (int)(b.to_ulong());
		cout << a_number << " " << b_number << endl; 
	}
	return 0;
}