import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class TestClass {
    static final int ALPHABET_SIZE = 26;
    static class TrieNode{
        HashMap<Integer,TrieNode> children;
        boolean isEndOfWord;
        int priority;
        TrieNode(int pPriority){
            priority = pPriority;
            isEndOfWord = false;
            children = new HashMap<>();
        }
    };
    
    static TrieNode root;
    static int maxPriority;
    
    static void insert(String key, int priority){
         int index;
         TrieNode node = root;
         for(int level=0;level<key.length();++level){
            index = key.charAt(level) - 'a';
            if(!node.children.containsKey(index)){
                TrieNode kid = new TrieNode(0);
                node.children.put(index,kid);
            }
            node = node.children.get(index);
         }
         node.isEndOfWord = true;
         node.priority = priority;
    }
    static boolean isLeaf(TrieNode node){
        if(node.children.size()==0)
             return true;
        return false;
    }
    
    static void getPriority(TrieNode node){
        if(node!= null && node.isEndOfWord){
            //System.out.println("la prioridad antes era: " + maxPriority);
            maxPriority = Math.max(maxPriority, node.priority);
            //System.out.println("la prioridad ahora es: " + maxPriority);
        }
        if(node!=null && isLeaf(node)){
            return;
        }
            
        if(node!=null){
            for(Map.Entry element: node.children.entrySet()){
                //System.out.println("examinando el elemento");
                getPriority((TrieNode)element.getValue());
            }
        }
        //System.out.println("sale del metodo");
    }
    
    static void bestResult(String key){
        //Step 1: find the key
        int index;
        TrieNode node = root;
        for(int level = 0;level<key.length();++level){
            index = key.charAt(level) -'a';
                if(!node.children.containsKey(index))
                    return;
                node = node.children.get(index);
        }
        
        //Step 2: move after key if possible and find the topPriority
        //System.out.println("ya encontre mi palabra original");
        if(node != null){
           // System.out.println("el ultimo nodo no es null");
            getPriority(node);
        }
    }
    
    public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nums = br.readLine().split(" ");
        int n = Integer.parseInt(nums[0]);
        int q = Integer.parseInt(nums[1]);
        
        root = new TrieNode(0);
        maxPriority = -1;
        
        while(n>0){
            String[] data = br.readLine().split(" ");
            String key = data[0];
            int priority = Integer.parseInt(data[1]);
            insert(key, priority);
            n--;
        }
        String prevq = "";
        while(q>0){
            String query = br.readLine();
            if(prevq.equals(query))
                System.out.println(maxPriority);
            else{
                maxPriority = -1;
                bestResult(query);
                System.out.println(maxPriority);
                prevq = query;
            }
            q--;
        }
    }
}