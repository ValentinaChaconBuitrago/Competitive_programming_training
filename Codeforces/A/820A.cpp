#include <bits/stdc++.h>

using namespace std;

int main(){
	int c, v0, v1, a, l;
	cin >> c >> v0 >> v1 >> a >> l;
	int day = 0;

	while(c>0){
		int pages_day = v0 + (a*day);
		
		//Option 1: i'm reading less pages than allowed
		if(pages_day<=v1){
		    if(day!=0)pages_day-=l;
			c-=pages_day;
		}
		//Option 2: i can only read the maximum number of pages allowed
		else{
			int max_read = v1-l;
			c-=max_read;
		}
		day++;
	}
    cout << day << endl;
	return 0;
}