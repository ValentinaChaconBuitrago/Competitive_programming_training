import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.*;


// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class TestClass {
    private static class TrieNode{
        HashMap<String,TrieNode> children;
        boolean isEndOfWord;
        
        public TrieNode(){
            children = new HashMap<>();
            isEndOfWord = false;
        }
    }
    
    private static TrieNode root;
    
    public static String insertLogin(String login){
        TrieNode node = root;
        int index = 0;
        int i=0;
        for(;i<login.length();i++){
            //System.out.println("Evaluating char: " + login.charAt(i));
            if(Character.isDigit(login.charAt(i))){
                //System.out.println("A number was found");
                break;
            }
            if(!node.children.containsKey(""+login.charAt(i))){
                TrieNode added = new TrieNode();
                node.children.put(""+login.charAt(i),added);
            }
            node = node.children.get(""+login.charAt(i));
        }
        
        String ans = "";
        if(!node.isEndOfWord){
            //System.out.println("End of word done!!");
            node.isEndOfWord = true;
            ans = login;
        }
        else{
            //Case 1: there are no digits to start the count from
            if(i==login.length()){
                //System.out.println("case 1, value of i:" + i);
                int counter = 0;
                while(node.children.containsKey(""+counter)){
                    counter++;
                }
                TrieNode added = new TrieNode();
                node.children.put(""+counter,added);
                ans = login+counter;
            }
            //Case 2: There are digits that comprise the log in
            else{
                //System.out.println("case 2");
                //Step 1: retrieve the digit that is accompanying the login
                int digit = 0;
                String base = login.substring(0,i);
                //System.out.println("Base: " + base);
                while(i<login.length()){
                    digit*=10;
                    digit+=(login.charAt(i)-'0');
                    i++;
                }
                //System.out.println("Digit that is acommpanying the log in: " + digit);
                //Case 2.1: the proposed login doesn't exist yet
                if(!node.children.containsKey(""+digit)){
                    //System.out.println("NEW login");
                    TrieNode added = new TrieNode();
                    node.children.put(""+digit,added);
                    ans = base+digit;
                }else{
                    digit=0;
                    //Case 2.2: the proposed login is already taken
                    while(node.children.containsKey(""+digit)) digit++;
                    //System.out.println("TAKEN login");
                    TrieNode added = new TrieNode();
                    node.children.put(""+digit,added);
                    ans = base+digit;
                }
                
                
            }
            node.isEndOfWord = true;
        }
        
        return ans;
    }
    
    public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        root = new TrieNode();
        while(n>0){
            String login = br.readLine();
            System.out.println(insertLogin(login));
            n--;
        }
    }
}
