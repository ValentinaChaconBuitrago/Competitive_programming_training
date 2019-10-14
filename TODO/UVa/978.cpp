#include <bits/stdc++.h>

using namespace std;

int main(){
	int tc;
	scanf("%d",&tc);
	while(tc--){
		int b, ga, ba;
		scanf("%d %d %d", &b, &ga, &ba);
		vector<int> green;
		while(ga--){
			int c;
			scanf("%d",&c);
			green.push_back(c);
		}
		sort(green.begin(), green.end(), greater<int>());

		vector<int> blue;
		while(ba--){
			int c;
			scanf("%d",&c);
			blue.push_back(c);
		}
		sort(blue.begin(), blue.end(), greater<int>());
		int tot_green = green.size();
		int tot_blue = blue.size();
		//Repeat certain number of times the battle
		while(tot_green>0 && tot_blue>0){
			
			for(int i=0;i<b;++i){
				int g;
				int b;
				//There is a green  and blue soldier for the battle field
				if(i < tot_green && i < tot_blue){
					g = green[i];
					b = blue[i];
				}
				else
					break;


				//TODO: IF CON LAS CONDICIONES DE ELIMINACION DE LOS GUERREROS
				if(g > b){
					blue[i] = -1;
					green[i] = -1;
					g-=b;
					green.push_back(g);
					//Lost a blue soldier
					tot_blue--;
				}
				else if(b > g){
					blue[i] = -1;
					green[i] = -1;
					b-=g;
					blue.push_back(b);

					//Lost a green soldier
					tot_green--; 
				}
				else{
					blue[i] = -1;
					green[i] = -1;
					tot_green--;
					tot_blue--;
				}
				sort(green.begin(), green.end(), greater<int>());
				sort(blue.begin(), blue.end(), greater<int>());

			}

		}

		if(tot_green==0 && tot_blue==0){
			cout << "green and blue died" << endl;
		}
		else if(tot_blue>0){
			cout << "CASO2 -> valor de blue: " << blue.size() << " valor de green: " << green.size() << endl;
			cout << "blue wins" << endl;
			for(int i=0;i<tot_blue;++i){
				cout << blue[i] << endl;
			} 
		}
		else if(tot_green>0){
			cout << "CASO2 -> valor de blue: " << blue.size() << " valor de green: " << green.size() << endl;
			cout << "green wins" << endl;
			for(int i=0;i<tot_green;++i){
				cout << green[i] << endl;
			} 
		}
		cout << "\n";
	}
	return 0;
}