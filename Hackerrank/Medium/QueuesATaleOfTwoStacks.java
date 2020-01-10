public class Solution {
    private static class MyQueue<T>{
        private Stack<T> first;
        private Stack<T> second;
        private boolean inFirst;
        public MyQueue(){
            first = new Stack<>();
            second = new Stack<>();
            inFirst = true;
        }
        public void checkState(){
            System.out.println("elementos en primera");
            Iterator value = first.iterator();
            while(value.hasNext()){
                System.out.print(value.next() + ", ");
            }
            System.out.println();
            System.out.println("elementos en segunda");
            Iterator valuee = second.iterator();
            while(valuee.hasNext()){
                System.out.print(valuee.next() + ", ");
            }
            System.out.println();
        }
        
        public void enqueue(T obj){
            first.push(obj);
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
    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
              queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
              queue.dequeue();
            } else if (operation == 3) { // print/peek
              System.out.println(queue.peek());
            }
        }
        scan.close();
    }
}
