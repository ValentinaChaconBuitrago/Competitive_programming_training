class Solution {
    public double[] sampleStats(int[] count) {
        double[] statistics = new double[5];
              
        //Step 1: get all calculated values
        double totalSamples = 0;
        double value = 0;
        double min = -1;
        double max = 0;
        int mode = 0;
    
        for(int i=0;i<=255;++i){
           
            if(count[i]!=0 && min==-1)min=i;
            else if(count[i]!=0 && i>max) max = i;
               
            if(count[i]>count[mode])mode = i;
            
            value+=(i*count[i]);
            totalSamples+=count[i];
        }
        
        //Step 2: get median
        double median = 0;
        if(totalSamples%2!=0){
            int mid1 = (int)totalSamples/2 + 1;
            int totSamp = 0;
            for(int i=0;i<255;++i){
                totSamp+=count[i];
            
                if(mid1<=totSamp){
                     median+=i;
                     break;
                }      
            }
        }
        else{
            int mid1 = (int)totalSamples/2 ;
            int mid2 = (int)totalSamples/2 + 1;
            
            int totSamp = 0;
            boolean first = false;
            for(int i=0;i<=255;++i){
                totSamp+=count[i];
    
                if(mid1<=totSamp && !first){
                    median+=i;
                    first = true;
                }
                if(mid2<=totSamp){
                    median+=i;
                    break;
                }
            }
            median = median/(double)2;
        }
        
        
        //Step 3: store values in the array
        statistics[0]=min;
        statistics[1]=max;
        statistics[2]=value/totalSamples;
        statistics[3]=median;
        statistics[4]=(double)mode;
        return statistics;
    }
}