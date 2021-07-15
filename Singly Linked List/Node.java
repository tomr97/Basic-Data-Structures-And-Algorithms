package inlab3;

/**
 *
 * @author b61m524
 */
public class Node {
    private String Name;
    private Node next;
    
    public Node(String Name){
        this.Name = Name;
    }
    
    public void setNext(Node next){
        this.next = next;
    }
    public Node getNext(){
        return next;
    }
    
    public String getName(){
        return Name;
    }
            
    @Override
    public String toString(){
        return("Student name: " + getName());
    }
            
}
