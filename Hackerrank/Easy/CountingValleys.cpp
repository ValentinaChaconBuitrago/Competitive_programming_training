int countingValleys(int n, string s) {
    int totalSteps = 0;
    int totalVal = 0;
    for(int i=0;i<n;++i){
        if(s[i]=='D')totalSteps--;
        else totalSteps++;
        
        if(totalSteps==0 && s[i]=='U') totalVal++;    
    }
    return totalVal;
}