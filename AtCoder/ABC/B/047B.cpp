#include <bits/stdc++.h>

using namespace std;

int main(){
	int W,H,N;
	cin >> W >> H >> N;

	int right, left, top, down;
	left=0;
	down=0;
	right=W;
	top=H;

	while(N--){
		int x,y,a;
		cin >> x >> y >> a;
		if(a==1){
			left = max(left,x);
		}
		else if(a==2){
			right = min(right,x);
		}
		else if(a==3){
			down = max(down,y);
		}
		else if(a==4){
			top = min(top,y);
		}
	}
	//There can be a case where both subtractions when calculating the area are negative and the multiplication ends up in a positive number
	if(down>=top || left>=right)
		cout << 0 << endl;
	else{
		int area = (top - down) * (right-left);
		cout << max(area,0) << endl;
	}
return 0;
}