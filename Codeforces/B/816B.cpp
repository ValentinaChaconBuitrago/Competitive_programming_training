#include <iostream>
using namespace std;

#define MAX 200005

int main(){
	int temps[MAX] = {0};
	int n, k, q;
	cin >> n >> k >> q;

	while(n--){
		int l, r;
		cin >> l >> r;
		++temps[l]; --temps[r+1];
	}

	
	for (int i = 1; i <= MAX; ++i) temps[i] += temps[i - 1];
    
	for(int i=0;i<=MAX;++i){
	    if(temps[i]>=k)temps[i]=1;
	    else temps[i]=0;
	}

	for(int i=1;i<=MAX;++i)temps[i]+=temps[i-1];
	
	
	while(q--){
		int a, b;
		cin >> a >> b;
		int ans = temps[b] - temps[a-1];
		cout << ans << endl;
	}
	return 0;
}