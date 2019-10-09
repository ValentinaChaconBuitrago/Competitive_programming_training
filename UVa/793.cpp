#include <iostream>
#include<cstring>
#include<string>

using namespace std;
int uf[1000000000];
int rk[1000000000];

void init_array(int n){
	for(int i=1;i<=n;++i){
		uf[i]=i;
	}
}

int findSet(int i){
	if(uf[i]==i)
		return i;
	//Updating parents saves time later
	return uf[i] = findSet(uf[i]);
}

bool isSameSet(int a, int b){
	if(a==b)return true;
	return false;
}

void connect(int a, int b){
	int parentA = findSet(a);
	int parentB = findSet(b);

	if(parentA != parentB){
		if(rk[parentA]>rk[parentB]){
			uf[parentB] = parentA;
		}
		else{
			uf[parentA] = parentB;
			if(rk[parentA] == rk[parentB]) rk[parentB]++;
		}
	}
}


int main(){
	int tc;
	cin >> tc;
	while(tc--){
		memset(rk,0,sizeof(rk));
		int nc;
		init_array(nc);

		int successful = 0;
		int unSuccessful = 0;

		//Mientras no lea el espacio en blanco
		string blankline;
		while(getline(cin,blankline)){
			if(blankline.size() == 0)
				break;
			char c = blankline[0];
			string num = "";
			int a,b;
			for(int i = 2; i < blankline.size();++i){
				if(i == ' '){
					a = stoi(num);
					num = "";
				}
				else
					num += blankline[i];
			}

			b = stoi(num);

			if(c=='c'){
				connect(a,b);
			}
			else if(c=='p'){
				int set1 = findSet(a);
				int set2 = findSet(b);

				if(isSameSet(set1,set2))successful++;
				else unSuccessful++;
			}
		}

		cout << successful << "," << unSuccessful << endl;
	}
	return 0;
}







