int jumpingOnClouds(vector<int> c) {
    int i = 0;
    int num_jumps = 0;
    while(i<c.size()-1){
        if(i<c.size()-2 && c[i+2]==0)
            i+=2;
        else i++;
        num_jumps++;
    }
    return num_jumps;
}