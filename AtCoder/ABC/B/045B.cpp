#include<bits/stdc++.h>

using namespace std;

typedef queue<char> Q;

int main(){
	string alice,bob,charlie;
	cin >> alice >> bob >> charlie;

	//Step 1: store each deck of cards in a queue
	Q a;
	for(int i=0;i<alice.size();++i){
		a.push(alice[i]);
	}
	Q b;
	for(int i=0;i<bob.size();++i){
		b.push(bob[i]);
	}
	Q c;
	for (int i=0;i<charlie.size();++i){
		c.push(charlie[i]);
	}

	//Step 2: take card from decks until one of them is empty
	char init = 'a';

	while(true){
		if(init=='a'){
			if(!a.empty()){
				init = a.front();
				a.pop();
			}
			else{
				cout << "A" << endl;
				break;
			}
		}
		else if(init=='b'){
			if(!b.empty()){
				init = b.front();
				b.pop();
			}
			else{
				cout << "B" << endl;
				break;
			}
		}
		else if(init=='c'){
			if(!c.empty()){
				init = c.front();
				c.pop();
			}
			else{
				cout << "C" << endl;
				break;
			}
		}
	}
	return 0;
}