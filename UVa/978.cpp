#include <bits/stdc++.h>

using namespace std;

int main(){
	int tc;
	scanf("%d",&tc);
	for(int tt=0; tt<tc; tt++) {
	    if(tt > 0) cout << '\n';
	    
		int b, ga, ba;
		scanf("%d %d %d", &b, &ga, &ba);

		multiset<int,greater<int>> green;
		multiset<int,greater<int>> blue;
        
		while(ga--){
			int c;
			scanf("%d",&c);
			green.insert(c);
		}
		while(ba--){
			int c;
			scanf("%d",&c);
			blue.insert(c);
		}


		//Repeat certain number of times the battle
		while(green.size()>0 && blue.size()>0){

			vector<int> gre,blu;
			int min_quantity = min(green.size(),blue.size());
			int fights = min(b,min_quantity);


			//Evaluate the battles that the blue and green soldiers are participating in
			for(int i=0;i<fights;++i){
			    
			    auto it1 = green.begin();
			    auto it2 = blue.begin();
			
				int gr = *it1;
				int bl = *it2;
			
				green.erase(it1);
				blue.erase(it2);


				if(gr > bl){
					gr-=bl;
					gre.push_back(gr);

				}
				else if(bl > gr){
					bl-=gr;
					blu.push_back(bl);
				}
			}
			//Include new elements in the set after a round of battles
			for(auto i: gre) green.insert(i);
			for(auto i:blu) blue.insert(i);
		}
		

		if(green.size()==0 && blue.size()==0){
			cout << "green and blue died" << endl;
		}
		else if(blue.size()>0){
			//cout << "CASO2 -> valor de blue: " << blue.size() << " valor de green: " << green.size() << endl;
			cout << "blue wins" << endl;
			for(auto it=blue.begin();it!=blue.end();++it){
				cout << *it << endl;
			} 
		}
		else if(green.size()>0){
			//cout << "CASO2 -> valor de blue: " << blue.size() << " valor de green: " << green.size() << endl;
			cout << "green wins" << endl;
			for(auto it=green.begin();it!=green.end();++it){
				cout << *it << endl;
			} 
		}
	}
	return 0;
}