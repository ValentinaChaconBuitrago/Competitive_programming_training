public class Solution {
    private static class Queue<T>{
        private Stack<T> first;
        private Stack<T> second;
        
        public Queue(){
            first = new Stack();
            second = new Stack();
        }
        public void enqueue(T element){
            first.push(element);
        }

        public void dequeue(){
            if(second.empty()){
                while(!first.empty()){
                    second.push(first.pop());
                }
            }
            second.pop();
        }

        public T peek(){
            if(second.empty()){
                while(!first.empty()){
                    second.push(first.pop());
                }
            }
            return second.peek();
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> queue =  new Queue<>();
        int q = Integer.parseInt(br.readLine());
        while(q>0){
            String[] query = br.readLine().split(" ");
            int type = Integer.parseInt(query[0]);
            if(type==1){
                int num = Integer.parseInt(query[1]);
                queue.enqueue(num);
            }else if(type==2){
                queue.dequeue();
            }else if(type==3){
                System.out.println(queue.peek());
            }
            q--;
        }
    }
}

