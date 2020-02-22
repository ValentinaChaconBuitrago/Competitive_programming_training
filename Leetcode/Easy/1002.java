class Solution {
    public List<String> commonChars(String[] A) {
        List<String> ans = new ArrayList<>();
        int[] common = new int[26];
        String first = A[0];
        for(int i=0;i<first.length();i++){
            int index = first.charAt(i) - 'a';
            common[index]++;
        }
        int i=1;
        while(i<A.length){
            String current = A[i];
            int[] letters = new int[26];
            for(int j=0;j<current.length();j++){
                int index = current.charAt(j)-'a';
                letters[index]++;
            }
            for(int j=0;j<26;j++){
                common[j]=Math.min(common[j],letters[j]);
            }
            i++;
        }

        for(int k=0;k<26;k++){
            while(common[k]>0){
                char c = (char)(k+'a');
                ans.add(""+c);
                common[k]--;
            }
        }
        return ans;
    }
}