static int equalStacks(int[] h1, int[] h2, int[] h3) {
    int totalh1 = 0;
    for(int i=0;i<h1.length;i++) totalh1+=h1[i];
    int totalh2 = 0;
    for(int j=0;j<h2.length;j++) totalh2+=h2[j];
    int totalh3 = 0;
    for(int k=0;k<h3.length;k++) totalh3+=h3[k];

    int i=0,j=0,k=0;
    while(totalh1!=totalh2 || totalh1!=totalh3 || totalh2!=totalh3){
        if(totalh1>totalh2 || totalh1>totalh3){
            totalh1-=h1[i];
            i++;
        }
        if(totalh2>totalh1 || totalh2>totalh3){
            totalh2-=h2[j];
            j++;
        }
        if(totalh3>totalh1 || totalh3>totalh2){
            totalh3-=h3[k];
                k++;
        }
    }
    return totalh1;
}