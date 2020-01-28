static int utopianTree(int n) {

    int height = 1;
    int period = 1;
    while(period<=n){
        if(period%2==1) height*=2;
        else height++;
        period++;
    }
    return height;
}