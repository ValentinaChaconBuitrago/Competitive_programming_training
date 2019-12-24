    static int sherlockAndAnagrams(String s) {
        HashMap<String,Integer> data = new HashMap<>();

        for(int i=0;i<s.length();i++){
            String ans = ""+s.charAt(i);
            for(int j=i;j<s.length();j++){
                if(i==j) data.put(ans,data.getOrDefault(ans,0)+1);
                else{
                    ans+=s.charAt(j);
                    char[] letters = ans.toCharArray();
                    Arrays.sort(letters);

                    String info = new String(letters);
                    data.put(info,data.getOrDefault(info,0)+1);
                }
            }
        }
        int count = 0;
        for(int value: data.values()){
            //Binomial Coefficient
            count+=(value*(value-1))/2;
        }
        return count;
    }