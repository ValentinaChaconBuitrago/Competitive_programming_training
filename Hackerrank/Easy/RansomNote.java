 static void checkMagazine(String[] magazine, String[] note){
        HashMap<String,Integer> mag = new HashMap<>();
        for(int i=0; i<magazine.length;i++){
            mag.put(magazine[i],mag.getOrDefault(magazine[i],0)+1);
        }
        String ans = "Yes";
        for(int i=0;i<note.length;i++){
            if(!mag.containsKey(note[i]) || mag.get(note[i])==0){
                ans = "No";
                break;
            }
            else{
                mag.put(note[i],mag.get(note[i])-1);
            }
        }
        
        System.out.println(ans);
   }