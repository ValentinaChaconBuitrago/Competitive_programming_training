class Solution {
    public void messages(List<String> ans, String digits, String builtWord, int i,                      HashMap<Character,char[]> letters){
        if(i==digits.length()){
            ans.add(builtWord);
            return;
        }
        char[] data = letters.get(digits.charAt(i));
        for(int j=0;j<3;j++){
            messages(ans,digits,builtWord+data[j],i+1,letters);
        }

        if(digits.charAt(i)=='7' || digits.charAt(i)=='9')
            messages(ans,digits,builtWord+data[3],i+1,letters);

    }
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if(digits.isEmpty()) return ans;

        HashMap<Character,char[]> letters = new HashMap<>();
        int number = 2;
        int i=0;
        while(number<10){
            char[] let = new char[4];
            let[0]=(char)('a'+ (i));
            i++;
            let[1]=(char)('a'+ (i));
            i++;
            let[2]=(char)('a'+ (i));
            i++;

            if(number==7 || number==9){
                let[3]=(char)('a'+i);
                i++;
            }
            char num = (char)('0'+number);
            letters.put(num,let);
            number++;
        }

        messages(ans,digits,"",0, letters);
        return ans;
    }
}