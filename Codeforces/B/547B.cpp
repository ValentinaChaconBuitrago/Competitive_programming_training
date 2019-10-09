#include <iostream>
#include <string>
#include <cstring>

using namespace std;

int uf[100000];
int heights[100000];
void initialice_uf(int n){
	for(int i=0;i<=n;++i){
		uf[i]=1;
	}
}

int main(){
	int n;
	cin >> n;
	int counter = 0;
	int max = 0;
	while(counter<n){
		int c;
		cin >> c;
		heights[counter]=c;

		if(c>max)max=c;
		counter++;
	}
	//Case 1: groups of size 1
	cout << max << " ";


	//Case 2: groups of size 2
	int group = 2;
	while(group<=n){
		initialice_uf(n);

		//juntar de acuerdo al tamaño de los grupos con el height disponible mas bajito









		group++;
	}


	return 0;
}