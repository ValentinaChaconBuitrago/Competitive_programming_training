class Solution {
    public String reverseWords(String s) {

        //Step 1: save all words in a list
        List<String> words = new ArrayList<>();
        int i=0;
        while(i<s.length()){
            char c = s.charAt(i);
            if(c==' ')i++;
            else{
                StringBuilder br = new StringBuilder();
                while(i<s.length() && s.charAt(i)!=' '){
                    br.append(s.charAt(i));
                    i++;
                }
                String word = br.toString();
                words.add(word);
            }
        }

        //Step 2: iterate list backwards and concatenate space
        StringBuilder br = new StringBuilder();
        for(i=words.size()-1;i>=0;i--){
            br.append(words.get(i));
            if(i!=0)br.append(" ");
        }
        //Step 3: return the final string
        return br.toString();
    }
}