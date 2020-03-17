class Solution {
    public int romanToInt(String s) {
        HashMap<Character,Integer> symbols = new HashMap<>();

        symbols.put('I',1);
        symbols.put('V',5);
        symbols.put('X',10);
        symbols.put('L',50);
        symbols.put('C',100);
        symbols.put('D',500);
        symbols.put('M',1000);

        int total = 0;
        for(int i=0;i<s.length();i++){
            char current = s.charAt(i);
            if(i<s.length()-1){
                char next = s.charAt(i+1);
                if(current=='I' && (next=='V'||next=='X')){
                    total += (symbols.get(next) - symbols.get(current));
                    i++;
                }
                else if(current == 'X' && (next=='L'||next=='C')){
                    total += (symbols.get(next) - symbols.get(current));
                    i++;
                }
                else if(current == 'C' && (next=='D'||next=='M')){
                    total += (symbols.get(next) - symbols.get(current));
                    i++;
                }
                else{
                    total+=symbols.get(current);
                }
            }
            else{
                total+=symbols.get(current);
            }
        }
        return total;
    }
}