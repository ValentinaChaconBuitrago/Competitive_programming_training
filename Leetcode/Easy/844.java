class Solution {
    public String wordWithNoSpace(String S){
        int totalDelete = 0;
        StringBuilder first = new StringBuilder();
        int i=S.length()-1;
        while(i>=0){
            char c = S.charAt(i);
            if(c=='#') totalDelete++;
            else if(c!='#' && totalDelete==0) first.append(c);
            else if(totalDelete!=0) totalDelete--;

            i--;
        }
        return first.toString();
    }
    public boolean backspaceCompare(String S, String T) {
        String first = wordWithNoSpace(S);
        String second = wordWithNoSpace(T);

        return first.equals(second);
    }
}