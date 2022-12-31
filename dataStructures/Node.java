public class Node {
    
    /*
    This is used to create the 2 attributes of a Linked List.
    They're both set to blank (or null) right now so that they always have some sort of value.
    */
    String name = null; //item name
    Node next; //pointer to the next item in the list

    Node(String myName) {
        this.name = myName;//item name
        this.next = null;
    }//Node constructor

}//Node
