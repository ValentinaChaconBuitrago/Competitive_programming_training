    static int getDigit(String num){
        int digits = 0;
        for(int i=0;i<num.length();i++){
            digits+=num.charAt(i)-'0';
        }
        String data = ""+digits;
        if(data.length()==1) return digits;
        else return getDigit(data);
    }

    // Complete the superDigit function below.
    static int superDigit(String n, int k) {
            int temp = getDigit(n);
            int ans = getDigit(""+temp*k);
        return ans;
    }