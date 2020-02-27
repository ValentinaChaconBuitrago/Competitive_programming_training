class Solution {
    public String customSortString(String S, String T) {
        int[] tQuantity = new int[26];

        //Step 1: store repetitions of each character
        for(int i=0;i<T.length();i++){
            int index = T.charAt(i) -'a';
            tQuantity[index]++;
        }

        //Step 2: append charecters in T in the same order as S
        StringBuilder br = new StringBuilder();
        for(int i=0;i<S.length();i++){
            int index=S.charAt(i)-'a';
            while(tQuantity[index]>0){
                tQuantity[index]--;
                br.append(S.charAt(i));
            }
        }

        //Step 2: append all additional characters
        for(int i=0;i<26;i++){
            while(tQuantity[i]>0){
                char letter = (char)(i+'a');
                br.append(letter);
                tQuantity[i]--;
            }
        }
        return br.toString();
    }
}