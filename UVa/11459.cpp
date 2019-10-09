#include <iostream>
#include <vector>

using namespace std;

int main(){
	int tc;
	scanf("%d",&tc);
	while(tc--){
		vector<int>grid(101,0);
		int a,b,c; scanf("%d %d %d", &a, &b, &c);
		vector<int>players_position(a,1);
		while(b--){
			int entry,exitsq;scanf("%d %d", &entry, &exitsq);
			grid[entry]=exitsq;
		}
		bool finish =false;
		for(int i=0;i<c;++i){
			int player = i%a;
			int pos; scanf("%d",&pos);
			if(!finish){
				players_position[player]+=pos;
				while(grid[players_position[player]]!=0 && players_position[player]<100)players_position[player]=grid[players_position[player]];
				if(players_position[player]>=100){
					finish=true;
					players_position[player]=100;
				}
			}
		}
		for(int i=0;i<a;++i){
			cout << "Position of player " << i+1 << " is " << players_position[i] << ".\n";
		}
	}  
	return 0;
}