public class Stack extends Node{

    private static String myName;
    Node top = null;

    public Stack() {
        super(myName);
    }
    
    public void push(String data) {
        Node x = new Node(data);//creates an object using the data entered
        x.next = top;//the object's pointer is set to the node that was previously the top before it was rudely pushed down
        top = x;//the new top, after being pushed on
    }//push

    public Node pop() {
        Node popVal = null;
        if (!(isEmpty())) {//if it's empty, we skip this
            Node curTop = top;//temp value for the top before it is switched with the next pointer
            top = top.next;//now the element below the element just popped is on top
            popVal = curTop;//the top is popped off the stack
        }//if
        return popVal;
    }//pop

    public boolean isEmpty() {
        boolean empty = false;
        if (top == null) {
            empty = true;
        }//if
        
        return empty;
    }//isEmpty
}//Stack
