class Solution {
    public String addBinary(String a, String b) {
        
        int i=a.length()-1;
        int j=b.length()-1;
        StringBuilder str = new StringBuilder();
        
        int carry = 0;
        while(i>=0 || j>=0 || carry==1){
            int A = i>=0?(a.charAt(i)-'0'):0;
            int B = j>=0?(b.charAt(j)-'0'):0;
            
            int total=A+B;
            
            if(total==2 && carry==1){
                str.append('1');
                carry=1;
            }if(total==2 && carry==0){
                str.append('0');
                carry=1;
            }else if(total==0 && carry==0){
                str.append('0');
            }else if(total==0 && carry==1){
                str.append('1');
                carry=0;
            }else if(total==1 && carry==1){
                str.append('0');
                carry=1;
            }else if(total==1 && carry==0){
                str.append('1');
            }
            i--;
            j--;
        }
        String ans = str.reverse().toString();
        return ans;
    }
}