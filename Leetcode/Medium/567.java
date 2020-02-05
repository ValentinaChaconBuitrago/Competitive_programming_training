class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character,Integer> alph = new HashMap<>();
        for(int i=0;i<s1.length();i++){
            alph.put(s1.charAt(i),alph.getOrDefault(s1.charAt(i),0)+1);
        }

        int k=0,i=0;
        int total=s1.length();
        while(i<s2.length()){
            if(!alph.containsKey(s2.charAt(i))){
                    while(k<i){
                        if(alph.containsKey(s2.charAt(k))){
                            alph.put(s2.charAt(k),alph.get(s2.charAt(k))+1);
                            total++;
                        }
                        k++;
                    }
            }
            else if(alph.containsKey(s2.charAt(i))){
                alph.put(s2.charAt(i),alph.get(s2.charAt(i))-1);
                if(alph.get(s2.charAt(i))>=0) total--;

                if(total==0) return true;

                //Found a repeated character need to move on
                if(alph.get(s2.charAt(i))<0){

                    boolean found=false;
                    while(k<i && !found){
                        if(alph.containsKey(s2.charAt(k))){
                            alph.put(s2.charAt(k),alph.get(s2.charAt(k))+1);
                            if(s2.charAt(i)==s2.charAt(k)) found=true;
                            else total++;
                        }
                        k++;
                    }
                }
            }
            i++;
        }
        return false;
    }
}