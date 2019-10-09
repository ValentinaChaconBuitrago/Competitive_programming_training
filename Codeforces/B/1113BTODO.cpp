#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

#define MAX 200005
int verify(int num){
    int num_div = 0;
    int max_div = 1;
    for(int i=1;i<=num/2;++i){
        if(num%i==0){
            num_div++;
            max_div = i;
        }
    }
    
    if(num_div!=2)return max_div;
    else
        //if prime
        return -1;
}

int main(){
	int n;
	cin >> n;
	vector <int> machines;
	long long tots = 0;
	for(int i = 0;i<n;++i){
	    int c; cin >> c; machines.push_back(c);
	    tots+=c;
	}
	
	sort(machines.begin(),machines.end());
	
	bool have = false;
	int pos = machines.size()-1;

	while(!have){
	    //falta revisar el caso donde se repite el numero de maquinas: Se puede solucionar con un arreglo
	    int ans = verify(machines[pos]);
	    if (ans!=-1){
	        tots-=machines[0];
	        tots+=(machines[0]*ans);
	        tots-=machines[pos];
	        tots+=(machines[pos]/ans);
	        have = true;
	    }
	    pos--;
	}
	cout << tots << endl;
	return 0;
}