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