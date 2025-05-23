package queue;

public class ArrayImplementation {
    static class Queue{
       static int size;
        static int rear;
        static int[] queue;

        public Queue(int size){
            size=size;
            queue=new int[size];
            rear=-1;
        }

        public static boolean isEmpty(){
            return rear==-1;
        }

        public static void add(int data){
            if(rear == size-1){
                System.out.println("Queue is full");
            }
            rear = rear+1;
            queue[rear]=data;
        }

        public static int remove(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1; //there is nothing stored in array
            }
            int front = queue[0];
            for(int i=0; i<rear; i++){
                queue[i]=queue[i+1];
            }
            rear--;
            return front;
        }

        public static int peek(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1; //there is nothing stored in array
            }
            return  queue[0];
        }
    }
    public static void main(String[] args) {
        Queue q=new Queue(5);
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);

        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }
    }
}
