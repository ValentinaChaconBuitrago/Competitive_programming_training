long repeatedString(string s, long n) {
    int originalNum = 0;
    for(int i=0;i<s.size();++i){
        if(s[i] == 'a')originalNum++;
    }

    long entireStringReapeated = n/s.size();
    long ans = originalNum * entireStringReapeated;

    int lettersRemaining = n%s.size();
    for(int i=0;i<lettersRemaining;++i){
        if(s[i]=='a')ans++;
    }
    
    return ans;
}