public class Queue extends Node{

    private static String myName;
    Node front = null;
    Node back = null;

    public Queue() {
        super(myName);
    }//queue constructor

    public void enqueue(String data) {
        Node x = new Node(data);//creates an object using the data entered
        if (back != null) {//not the first element in the queue
            back.next = x;//the pointer in the back now points to the new node created
            //System.out.println(back.next.name);
        }//if
        else {//first element
            front = x;//first element means it is also the front
        }//else
        back = x;//the new node is now in the back of the queue
        //System.out.println(back.name);
    }//enqueue

    public String dequeue() {
        String dequeueVal = null;//return val
        
        if (!isEmpty()) {//nothing to be dequeued if there's nothing in the queue
            String curFront = front.name;
            front = front.next;//now the element behind the element just dequeued is in front
            dequeueVal = curFront;//the node in front is the first to leave
        }//if

        return dequeueVal;
    }//dequeue

    public boolean isEmpty() {
        boolean empty = false;
        if (front == null) {
            empty = true;
        }//if
        
        return empty;
    }//isEmpty
}
