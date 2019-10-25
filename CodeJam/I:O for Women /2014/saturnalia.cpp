#include <bits/stdc++.h>

using namespace std;

int main(){
    int t;
    cin >> t;
    int testCase = 1;
    cin >> ws;
    while(t--){
        string word;
        getline(cin,word);
        cout << "Case #" << testCase << ":"<< endl;
        string init = "+"+string(word.size()+2,'-') + "+";
        cout << init << endl;
        string mid = "| " + word + " |";
        cout << mid << endl;
        cout << init << endl;
        testCase++;
    }

    return 0;    
}