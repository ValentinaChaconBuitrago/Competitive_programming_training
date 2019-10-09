#include <bits/stdc++.h>

using namespace std;
int find_valid(int ori, int ab1, int ab2, int ab3, int ab4){
	for(int i=ori;i<53;++i){
		if(i!=ab1 && i!=ab2 && i!=ab3 && i!= ab4) return i;
	}
	return -1;
}
bool verify(vector<int>pri,vector<int>sis){

	for(int i=0;i<3;++i){
		int a = pri[i];
		int b = sis[i];
		if(a<b){
			return false;
		}
	}
	return true;
}

int main(){
	
	int a, b, c, x, y;
	cin >> a >> b >> c >> x >> y;
	while(a!=0 && b!=0){
		vector<int> sis;
		vector<int> pri;
		sis.push_back(a);sis.push_back(b);sis.push_back(c);
		pri.push_back(x);pri.push_back(y);
		sort(sis.rbegin(),sis.rend());
		sort(pri.rbegin(),pri.rend());
		cout << "sis" << endl;
		for(int i=0;i<3;++i){
		    cout << sis[i] << " ";
		}
		cout << " " << endl;
		cout << "---------"<<endl;
		cout << "pri" << endl;
	    for(int i=0;i<2;++i){
		    cout << pri[i] << " ";
		}
		cout << " " << endl;
		cout << "---------"<<endl;

		// Case 1: evaluate the largest card
		int ans = -1;
		if(pri[0]<sis[0]){
		    cout << "caso 1" << endl;
			int num = sis[0]+1;
			cout << "valid num " << num << endl;
			if(num>52) ans = -1;
			else{
				pri.push_back(num);
				sort(pri.rbegin(),pri.rend());
				if(verify(pri,sis))ans=num;
				else ans = -1;
			}
		}
		else if(pri[1]<sis[1]){
		    cout << "caso 2" << endl;
			int num = find_valid(sis[1]+1,sis[0],0,pri[1],pri[0]);
			cout << "valid num " << num << endl;
			if(num==-1)ans = -1;
			else{
				pri.push_back(num);
				sort(pri.rbegin(),pri.rend());
				if(verify(pri,sis))ans=num;
				else ans = -1;
			}
		}
		else{
		    cout << "caso 3" << endl;
			int num=find_valid(sis[2]+1,sis[1],sis[0],pri[1],pri[0]);
			cout << "valid num " << num << endl;
			if(num==-1)ans = -1;
			else{
				pri.push_back(num);
				sort(pri.rbegin(),pri.rend());
				if(verify(pri,sis))ans=num;
				else ans = -1;
			}
		}
		cout << ans << endl;

	cin >> a >> b >> c >> x >> y;
	}
	return 0;
}