#include <iostream>
#include <vector>
#include <iostream>

using namespace std;

int main(){
	int t;
	cin >> t;
	while(t--){

		int num_rect;
		cin >> num_rect;

		//Step 1: get all given dimensions
		vector <int> dimensions;
		while(num_rect--){
			int dim;
			cin >> dim;
			dimensions.push_back(dim);
		}

		//Step 2: sort given dimension
		sort(dimensions.start(),dimensions.start());

		int dim = dimensions.size()-1;
		int area = 0;
		int num_rectangles = 0;
			for(int i=0;i<dimensions.size()/2;++i){

				int min1 = dimensions[i];
				int min2 = dimensions[i+1];

				int max1 = dimensions[dim];
				int max2 = dimensions[dim-1];

				if(min1==min2 && max1==max2){
					int temp_area = min1*max1;
					if(i==0){
						area = temp_area;
					}
					if(area!=temp_area)break;
					else num_rectangles++;
				}
				dim--;
			}

			if(num_rectangles==num_rect)cout << "YES" << endl;
			else cout << "NO" << endl;

	}
	return 0;
}