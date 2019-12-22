    static String twoStrings(String s1, String s2) {
        int[] alphabet = new int[26];
        for(int i=0;i<s1.length();i++){
            alphabet[(s1.charAt(i)-'a')]++;
        }
        for(int i=0;i<s2.length();i++){
            if(alphabet[(s2.charAt(i) - 'a')]>0) return "YES";
        }
        return "NO";
    }