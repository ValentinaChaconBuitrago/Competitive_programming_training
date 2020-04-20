class Solution {
    public int compress(char[] chars) {
        int k=0;
        for(int i=0;i<chars.length;i++){
            char current = chars[i];
            int j=i+1;
            int total=1;
            while(j<chars.length && chars[j]==current){
                total++;
                j++;
            }
            i=j-1;

            chars[k]=current;
            if(total!=1){
                String tots = ""+total;
                for(int v=0;v<tots.length();v++){
                    chars[k+1]=tots.charAt(v);
                    k++;
                }
            }
            k++;
        }
        return k;
    }
}