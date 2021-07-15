/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doublylinkedlist;

/**
 *
 * @author Tom
 */
public class Node {
    private int Name;//name of node is a number
    private Node next, prev;//creates reference nodes
    
    public Node(int Name){
        this.Name = Name;//Node constructor names node from input
    }
    
    public void setNext(Node next){//sets next reference node to point to next node
        this.next = next;
    }
    public Node getNext(){//returns next node
        return next;
    }
    
    public void setPrev(Node prev)//sets previous reference node to point to previous node
    {
        this.prev = prev;
    }
    public Node getPrev()//returns previous node
    {
        return prev;
    }
    
    public int getName(){//returns node name
        return Name;
    }
    /*        
    @Override
    public String toString(){
        return("name: " + getName());
    }*/
}
