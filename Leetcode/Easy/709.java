class Solution {
    public String toLowerCase(String str) {
       StringBuilder br = new StringBuilder();

        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);

            //Case 1: the char is a lowecase letter
            if(c-'a'>=0 && c-'a'<=25)
                br.append(c);
            //Case 2: the char is an uppercase letter
            else if(c-'A'>=0 && c-'A'<=25){
                int dif = c-'A';
                char n = (char)('a'+dif);
                br.append(n);
            }
            //Case 3: the char is not a letter
            else
                br.append(c);
        }
        return br.toString();
    }
}