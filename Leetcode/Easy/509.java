class Solution {
    public int fib(int N) {
        int minus1=1;
        int minus2=0;
        int current=0;
        if(N<2)return N;
        for(int i=2;i<=N;i++){
            current=minus1+minus2;
            minus2=minus1;
            minus1=current;
        }
        return current;
    }
}