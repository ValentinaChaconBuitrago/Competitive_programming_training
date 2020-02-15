#include <bits/stdc++.h>

using namespace std;

int main(){
        ios::sync_with_stdio(0);
        cin.tie(0);
    	int n;
    	cin >> n;
    	long long prices[n+1] = {0};
    	long long orderedPrices[n+1] = {0};

    	for(int i=0;i<n;i++){
    	    int k;
    	    cin >> k;
    	    prices[i+1]=k;
			orderedPrices[i+1]=k;
    	}

    	sort(orderedPrices,orderedPrices + (n+1));

    	//Step 2: Accumulate prices for each array
		for(int i=1;i<n+1;i++){
			prices[i]+=prices[i-1];
			orderedPrices[i]+=orderedPrices[i-1];
		}

		//Step 3: Answer queries
		int m;
		cin >> m;
		while(m--){
		    int type,l,r;
		    cin >> type >> l >> r;

		    if(type==1) cout << (prices[r]-prices[l-1]) << endl;
		    else cout << (orderedPrices[r]-orderedPrices[l-1]) << endl;
		}
    return 0;
}

