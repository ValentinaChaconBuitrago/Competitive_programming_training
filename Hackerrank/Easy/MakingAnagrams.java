    
    static int makeAnagram(String a, String b) {
        HashMap<Character,Integer> alphabetA = new HashMap<>();
        HashMap<Character,Integer> alphabetB = new HashMap<>();

        for(int i=0;i<a.length();i++){
            alphabetA.put(a.charAt(i),alphabetA.getOrDefault(a.charAt(i),0)+1);
        }
        for(int i=0;i<b.length();i++){
            alphabetB.put(b.charAt(i),alphabetB.getOrDefault(b.charAt(i),0)+1);
        }

        int removal = 0;
        for(Map.Entry<Character,Integer> entry : alphabetA.entrySet()){
            char key = entry.getKey();
            int val = entry.getValue();
                
            removal+=(Math.abs(val-alphabetB.getOrDefault(key,0)));

            if(alphabetB.containsKey(key))alphabetB.remove(key);      
        }
        for(int value: alphabetB.values()){
            removal+=value;
        }
        return removal;
    }