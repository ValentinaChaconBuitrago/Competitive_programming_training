static String isBalanced(String s) {

        Stack<Character> opening = new Stack<>();
        HashMap<Character,Character> brackets = new HashMap<>();
        brackets.put('(',')');
        brackets.put('{','}');
        brackets.put('[',']');

        String ans = "YES";
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(brackets.containsKey(c))opening.push(c);
            else{//there's a closing parenthesis
                if(!opening.empty() && c==brackets.get(opening.peek()))opening.pop();
                else{
                    ans = "NO";
                    break;
                }
            }
        }
        if(!opening.empty()) ans = "NO";
        
        return ans;
    }