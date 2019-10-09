#include <iostream>
#include <cstring>
#include <string>
#include <vector>

using namespace std;

int uf[100000];
int friends[100000];

void initialize_uf(int n){
	for(int i=0;i<=n;++i){
		uf[i]=i;
		friends[i]=1;
	}
}

int findSet(int a){
	if(uf[a]==a)
		return a;
	else
		return uf[a]=findSet(uf[a]);
}

void connect(int a, int b){
	int parentA = findSet(a);
	int parentB = findSet(b);
	
	if(parentA!=parentB){
	   if(friends[parentA]>friends[parentB]){
	    uf[parentB] = parentA;
	    friends[parentA]+=friends[parentB];
	    }
	    else{
		uf[parentA] = parentB;
		friends[parentB]+=friends[parentA];
	    }
	}
}

int main(){
	int n,m;
	cin >> n >> m;
	initialize_uf(n);
	while(m--){
		int a, b;
		cin >> a >> b;
		connect(a,b);
	}
	for(int i=1;i<=n;++i){
	    int root = findSet(i);
	    cout << friends[root]-1<< " ";
	}
	return 0;
}