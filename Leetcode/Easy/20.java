class Solution {
    public boolean isValid(String s) {
        HashMap<Character,Character> brackets = new HashMap<>();
        brackets.put('(',')');
        brackets.put('{','}');
        brackets.put('[',']');

        Stack<Character> opening = new Stack<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            //Step 1: check if it is an oppening tag
            if(brackets.containsKey(c)) opening.push(c);
            //Step 2: check if it is possible to close a set of brackets
            else if(opening.size()>0 && brackets.get(opening.peek()) == c)opening.pop();
            //Step 3: there is no feasible answer
            else return false;
        }
        if(opening.size()>0)return false;
        return true;
    }
}