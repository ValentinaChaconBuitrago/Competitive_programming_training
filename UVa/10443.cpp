#include <bits/stdc++.h>

using namespace std;

char get_winner(char c){
	char ans;
	if(c=='R')
		ans = 'P';
	else if(c=='P')
		ans = 'S';
	else if(c=='S')
		ans = 'R';
	return ans;
}

bool in_matrix(int i, int j, int rows, int columns){
	
	if(i>=0 && i<rows && j>=0 && j<columns)
		return true;
	return false;
}

int main(){
	
	int t;
	cin >> t;
	while(t--){
		int r, c, n;
		cin >> r >> c >> n;
		char matrix[r][c];
		//Step 1: fill in the original Matrix
		int counter = 0;
		while(counter < r){
			string word;
			cin >> word;
			for(int i=0;i<c;++i){
				matrix[counter][i] = word[i];
			}
			counter++;
		}
	
		//Step 2: go over the matrix and identify changes, saving the result in an auxiliary matrix
		char temp_matrix[r][c];
		while(n--){
			for(int i=0;i<r;i++){
				for(int j=0;j<c;++j){
					char owner = matrix[i][j];
					char winner = get_winner(owner);
					//Check down
					if(in_matrix(i+1,j,r,c) && matrix[i+1][j] == winner){
						temp_matrix[i][j]=winner;
					}
					// Check up
					else if(in_matrix(i-1,j,r,c) && matrix[i-1][j] == winner){
						temp_matrix[i][j]=winner;
					}
					// Check right
					else if(in_matrix(i,j+1,r,c) && matrix[i][j+1] == winner){
						temp_matrix[i][j]=winner;
					}
					// Check left
					else if(in_matrix(i,j-1,r,c) && matrix[i][j-1] == winner){
						temp_matrix[i][j]=winner;
					}
					//No neighbor is better
					else{
						temp_matrix[i][j]=owner;
					}
				}
			}
			for(int i=0;i<r;++i){
			    for(int j=0;j<c;++j){
			        matrix[i][j]=temp_matrix[i][j];
			    }
			}
		}
		for(int i=0;i<r;++i){
			for(int j=0;j<c;++j){
				cout << matrix[i][j];
			}
			cout << "\n";
		}
		if(t>0)
		    cout << endl;
	}
	return 0;
}